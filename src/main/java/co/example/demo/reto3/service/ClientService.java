package co.example.demo.reto3.service;

import co.example.demo.reto3.Model.Category;
import co.example.demo.reto3.Model.Client;
import co.example.demo.reto3.web.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */

@Service

public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save (Client client){
        if (validarCampos(client)) {
            if (client.getIdClient() == null) {
                return clientRepository.save(client);
            } else {
                Optional<Client> client1 = clientRepository.getClient(client.getIdClient());
                if (client1.isEmpty()) {
                    return clientRepository.save(client);
                } else {
                    return client;
                }
            }
        }
        return client;
    }
    public boolean validarCampos(Client client){
        return (client.getEmail().length() + client.getPassword().length()+client.getName().length()<=340
                &&(client.getAge()>0 && client.getAge()<=150)

        );


    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= clientRepository.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                clientRepository.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int id) {
        Boolean d = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return d;
    }
}
