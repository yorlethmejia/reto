package co.example.demo.reto3.controller;

import co.example.demo.reto3.Model.CountClient;
import co.example.demo.reto3.Model.Reservation;
import co.example.demo.reto3.Model.StatusAmount;
import co.example.demo.reto3.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author USUARIO
 */

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})

public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return reservationService.deleteReservation(id);
    }

    @GetMapping("/report-clients")
    public List<CountClient> getReservationsReportClient(){
        return reservationService.getReportClient();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        Date date1= new Date();
        Date date2= new Date();
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateOne);
            date2=new SimpleDateFormat("yyyy-MM-dd").parse(dateTwo);
        } catch (ParseException ex) {
            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservationService.getReportDates(date1,date2);


    }

    @GetMapping("/report-status")
    public StatusAmount getReservationsStatusReport(){
        return reservationService.getStatus();

    }
}
