package co.example.demo.reto3.web;

import co.example.demo.reto3.Model.Category;
import co.example.demo.reto3.interfac.CategoryInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 *
 * @author USUARIO
 */

@Repository

public class CategoryRepository {
    @Autowired
    private CategoryInterface extencionesCrud;

    public List<Category> getAll(){
        return (List<Category>) extencionesCrud.findAll();
    }

    public Optional<Category> getCategory(int id){
        return extencionesCrud.findById(id);
    }

    public Category save(Category category){
        return extencionesCrud.save(category);
    }

    public void delete(Category category){
        extencionesCrud.delete(category);
    }



}
