package co.example.demo.reto3.interfac;

import co.example.demo.reto3.Model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author USUARIO
 */

public interface ReservationInterface extends CrudRepository<Reservation, Integer> {

    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClient();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<Reservation>findAllByStatus(String status);




}
