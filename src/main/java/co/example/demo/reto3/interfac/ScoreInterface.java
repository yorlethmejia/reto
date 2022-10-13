package co.example.demo.reto3.interfac;

import co.example.demo.reto3.Model.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreInterface extends CrudRepository<Score, Integer> {
}
