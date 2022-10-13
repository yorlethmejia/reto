package co.example.demo.reto3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("co.example.demo.reto3.Model")
//@EnableJpaRepositories("co.example.demo.reto3.web")
@SpringBootApplication(scanBasePackages = "co.example.demo.reto3")
public class Reto3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3Application.class, args);
	}

}
