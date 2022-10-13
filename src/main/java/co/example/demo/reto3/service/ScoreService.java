package co.example.demo.reto3.service;

import co.example.demo.reto3.Model.Score;
import co.example.demo.reto3.web.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    public Score save(Score score){
        if(validarCampos(score)) {
            if (score.getIdScore() == null) {
                return scoreRepository.save(score);
            } else {
                Optional<Score> scoreEncontrado = getScore(score.getIdScore());
                if (!scoreEncontrado.isPresent()) {
                    return scoreRepository.save(score);
                } else {
                    return score;
                }
            }
        }
        return score;
    }
    public Score update(Score score){
        if(validarCampos(score)) {
            if (score.getIdScore() != null) {
                Optional<Score> scoreEncontrado = getScore((score.getIdScore()));
                if (scoreEncontrado.isPresent()) {
                    if (score.getMessageText() != null) {
                        scoreEncontrado.get().setMessageText(score.getMessageText());
                    }
                    if (score.getStars() != null) {
                        scoreEncontrado.get().setStars(score.getStars());
                    }
                    return scoreRepository.save(scoreEncontrado.get());
                }
            }
            return score;
        }
        return score;
    }

    public boolean deleteScore(int id) {
        Boolean d = getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return d;
    }
    public boolean validarCampos(Score score){
        return ((score.getStars()>=0 && score.getStars()<=5) && score.getMessageText().length()<=250);

    }
}
