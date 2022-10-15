package co.example.demo.reto3.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "admin")
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String name;



    public Integer getIdAdmin() {return id; }

    public void setIdAdmin(Integer id) {this.id = id; }

    public String getEmail() {return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {return password; }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

