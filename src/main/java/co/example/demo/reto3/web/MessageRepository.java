package co.example.demo.reto3.web;


import co.example.demo.reto3.Model.Message;
import co.example.demo.reto3.Model.Tool;
import co.example.demo.reto3.interfac.MessageInterface;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author USUARIO
 */

@Repository

public class MessageRepository {
    @Autowired
    private MessageInterface extencionesCrud;

    public List<Message> getAll(){
        return (List<Message>) extencionesCrud.findAll();
    }

    public Optional<Message> getMessage(int id){
        return extencionesCrud.findById(id);
    }

    public Message save(Message message){
        return extencionesCrud.save(message);
    }

    public void delete(Message message){
        extencionesCrud.delete(message);
    }
}
