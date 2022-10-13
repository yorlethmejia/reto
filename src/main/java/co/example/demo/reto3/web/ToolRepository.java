package co.example.demo.reto3.web;

import co.example.demo.reto3.Model.Category;
import co.example.demo.reto3.Model.Tool;
import co.example.demo.reto3.interfac.ToolInterface;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author USUARIO
 */

@Repository

public class ToolRepository {
    @Autowired
    private ToolInterface extencionesCrud;

    public List<Tool> getAll(){
        return (List<Tool>) extencionesCrud.findAll();
    }

    public Optional<Tool> getTool(int id){
        return extencionesCrud.findById(id);
    }

    public Tool save(Tool tool){
        return extencionesCrud.save(tool);
    }

    public void delete(Tool tool){
        extencionesCrud.delete(tool);
    }
}
