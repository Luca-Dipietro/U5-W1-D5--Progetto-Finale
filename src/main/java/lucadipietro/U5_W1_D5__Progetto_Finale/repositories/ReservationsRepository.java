package lucadipietro.U5_W1_D5__Progetto_Finale.repositories;

import lucadipietro.U5_W1_D5__Progetto_Finale.entities.Reservation;
import lucadipietro.U5_W1_D5__Progetto_Finale.entities.Station;
import lucadipietro.U5_W1_D5__Progetto_Finale.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservation,Long> {
    boolean existsByStationAndReservationDate(Station station, LocalDate reservationDate);
    boolean existsByUserAndReservationDate(User user, LocalDate reservationDate);
}
