package co.example.demo.reto3.web;


import co.example.demo.reto3.Model.Category;
import co.example.demo.reto3.Model.Client;
import co.example.demo.reto3.interfac.ClientInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */

@Repository

public class ClientRepository {
    @Autowired
    private ClientInterface extencionesCrud;

    public List<Client> getAll(){
        return (List<Client>) extencionesCrud.findAll();
    }

    public Optional<Client> getClient(int id){
        return extencionesCrud.findById(id);
    }

    public Client save(Client client){
        return extencionesCrud.save(client);
    }

    public void delete(Client client){
        extencionesCrud.delete(client);
    }

}
