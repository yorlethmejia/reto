package co.example.demo.reto3.interfac;

import co.example.demo.reto3.Model.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author USUARIO
 */

public interface ReservationInterface extends CrudRepository<Reservation, Integer> {

}
