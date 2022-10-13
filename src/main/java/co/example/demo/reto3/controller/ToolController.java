package co.example.demo.reto3.controller;

import co.example.demo.reto3.Model.Tool;
import co.example.demo.reto3.service.ToolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/Tool")

public class ToolController {
    @Autowired
    private ToolService toolService;

    @GetMapping("/all")
    public List<Tool> getAll(){
        return toolService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Tool> getTool(@PathVariable("id") int id){
        return toolService.getTool(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool save (@RequestBody Tool tool){
        return toolService.save(tool);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool update(@RequestBody Tool tool) {
        return toolService.update(tool);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return toolService.deleteTool(id);
    }
}
