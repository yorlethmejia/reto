package co.example.demo.reto3.web;

import co.example.demo.reto3.Model.Client;
import co.example.demo.reto3.Model.CountClient;
import co.example.demo.reto3.Model.Message;
import co.example.demo.reto3.Model.Reservation;
import co.example.demo.reto3.interfac.ReservationInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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

    public List<CountClient> getTopClients(){
        List<CountClient>res=new ArrayList<>();
        List<Object[]>report=extencionesCrud.countTotalReservationsByClient();
        for(int i=0;i<report.size();i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }

    public List<Reservation> getReservationPeriod(Date a, Date b){
        return extencionesCrud.findAllByStartDateAfterAndStartDateBefore(a,b);
    }

    public List<Reservation> getReservationsByStatus(String status) {
        return extencionesCrud.findAllByStatus(status);
    }
}
