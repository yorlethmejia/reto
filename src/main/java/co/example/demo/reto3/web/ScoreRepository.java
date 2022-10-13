package co.example.demo.reto3.web;

import co.example.demo.reto3.Model.Score;
import co.example.demo.reto3.interfac.ScoreInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ScoreRepository {

    @Autowired
    private ScoreInterface scoreRepository;
    public List<Score> getAll(){
        return (List<Score>) scoreRepository.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreRepository.findById(id);

    }
    public Score save(Score score){
        return scoreRepository.save(score);
    }
    public void delete(Score score){
        scoreRepository.delete(score);
    }
}
