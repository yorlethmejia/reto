package co.example.demo.reto3.service;

import co.example.demo.reto3.Model.Client;
import co.example.demo.reto3.Model.CountClient;
import co.example.demo.reto3.Model.Reservation;
import co.example.demo.reto3.Model.StatusAmount;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.example.demo.reto3.web.ClientRepository;
import co.example.demo.reto3.web.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
/**
 *
 * @author USUARIO
 */

@Service

public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    @Autowired
    private ClientRepository clientRepository;


    public Reservation save (Reservation reservation){
        if (reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservation1 = reservationRepository.getReservation(reservation.getIdReservation());
            if(reservation1.isPresent()){
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= reservationRepository.getReservation(reservation.getIdReservation());
            if(e.isPresent()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int id) {
        Boolean d = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }

    public List<CountClient> getTopClients() {
            return reservationRepository.getTopClients();
    }
    public List<Reservation> getReservationsPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a= new Date();
        Date b=new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (a.before(b)){
            return reservationRepository.getReservationPeriod(a,b);
        }else{
            return new ArrayList<>();
        }
    }

    public StatusAmount getReservationsStatusReport(){
        List<Reservation>completed=reservationRepository.getReservationsByStatus("completed");
        List<Reservation>cancelled=reservationRepository.getReservationsByStatus("cancelled");
        return new StatusAmount(completed.size(),cancelled.size());
    }

    public StatusAmount getStatus() {
        StatusAmount status = new StatusAmount();
        List<Reservation> reservations=reservationRepository.getAll();
        int contF=0;
        int contC=0;
        for(Reservation res:reservations){
            if(res.getStatus().equals("completed")){
                contF=contF+1;
            }else if(res.getStatus().equals("cancelled")){
                contC=contC+1;
            }
        }
        status.setCompleted(contF);
        status.setCancelled(contC);
        return status;
    }
    public List<CountClient> getReportClient() {
        List<CountClient> repoclient=new ArrayList<CountClient>();
        List<Client> clients=clientRepository.getAll();
        long total=0;
        for(Client cli:clients){
            for(Reservation res:cli.getReservations()){
                total=total+1;
            }
            CountClient reportclient= new CountClient();
            reportclient.setTotal(total);
            reportclient.setClient(cli);
            repoclient.add(reportclient);
            total=0;
        }
        return repoclient;
    }
    public List<Reservation> getReportDates(Date date1, Date date2) {
        List<Reservation> reservations= reservationRepository.getAll();
        List<Reservation> reservationsDate =new ArrayList<Reservation>();
        for(Reservation res:reservations){
            if(date1.compareTo(res.getStartDate()) * res.getStartDate().compareTo(date2) >= 0){
                reservationsDate.add(res);
            }
        }
        return reservationsDate;
    }


}
