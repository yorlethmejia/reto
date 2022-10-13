package co.example.demo.reto3.web;

import co.example.demo.reto3.Model.Message;
import co.example.demo.reto3.Model.Reservation;
import co.example.demo.reto3.interfac.ReservationInterface;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author USUARIO
 */

@Repository

public class ReservationRepository {
    @Autowired
    private ReservationInterface extencionesCrud;

    public List<Reservation> getAll(){
        return (List<Reservation>) extencionesCrud.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return extencionesCrud.findById(id);
    }

    public Reservation save(Reservation reservation){
        return extencionesCrud.save(reservation);
    }

    public void delete(Reservation reservation){
        extencionesCrud.delete(reservation);
    }
}
