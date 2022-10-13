package co.example.demo.reto3.interfac;

import co.example.demo.reto3.Model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminInterface extends CrudRepository<Admin, Integer> {
}
