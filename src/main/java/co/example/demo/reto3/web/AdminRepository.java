package co.example.demo.reto3.web;

import co.example.demo.reto3.Model.Admin;
import co.example.demo.reto3.interfac.AdminInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
    @Autowired
    private AdminInterface adminRepository;

    public List<Admin> getAll(){
        return (List<Admin>) adminRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.findById(id);
    }

    public Admin save(Admin admin){
        return adminRepository.save(admin);

    }
    public void delete(Admin admin){
        adminRepository.delete(admin);
    }

}
