package co.example.demo.reto3.service;


import java.util.List;
import java.util.Optional;
import co.example.demo.reto3.Model.Tool;
import co.example.demo.reto3.web.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */

@Service

public class ToolService {
    @Autowired
    private ToolRepository toolRepository;

    public List<Tool> getAll(){
        return toolRepository.getAll();
    }

    public Optional<Tool> getTool(int id){
        return toolRepository.getTool(id);
    }

    public Tool save (Tool tool){
        if(validarCampos(tool)) {
            if (tool.getId() == null) {
                return toolRepository.save(tool);
            } else {
                Optional<Tool> tool1 = toolRepository.getTool(tool.getId());
                if (!tool1.isPresent()) {
                    return toolRepository.save(tool);
                } else {
                    return tool;
                }
            }
        }
        return tool;
    }
    public boolean validarCampos(Tool tool){
        return (tool.getBrand().length()<=45 && tool.getName().length()<=45 &&
                String.valueOf(tool.getYear()).length()==4 && tool.getDescription().length()<=250);

    }

    public Tool update(Tool tool){
        if(tool.getId()!=null){
            Optional<Tool> e= toolRepository.getTool(tool.getId());
            if(e.isPresent()){
                if(tool.getName()!=null){
                    e.get().setName(tool.getName());
                }
                if(tool.getBrand()!=null){
                    e.get().setBrand(tool.getBrand());
                }
                if(tool.getYear()!=null){
                    e.get().setYear(tool.getYear());
                }
                if(tool.getDescription()!=null){
                    e.get().setDescription(tool.getDescription());
                }
                if(tool.getCategory()!=null){
                    e.get().setCategory(tool.getCategory());
                }
                toolRepository.save(e.get());
                return e.get();
            }else{
                return tool;
            }
        }else{
            return tool;
        }
    }


    public boolean deleteTool(int id) {
        Boolean d = getTool(id).map(tool -> {
            toolRepository.delete(tool);
            return true;
        }).orElse(false);
        return d;
    }
}
