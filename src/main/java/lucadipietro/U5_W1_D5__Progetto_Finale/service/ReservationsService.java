package lucadipietro.U5_W1_D5__Progetto_Finale.service;

import lombok.extern.slf4j.Slf4j;
import lucadipietro.U5_W1_D5__Progetto_Finale.entities.Building;
import lucadipietro.U5_W1_D5__Progetto_Finale.entities.Reservation;
import lucadipietro.U5_W1_D5__Progetto_Finale.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class ReservationsService {
    @Autowired
    private ReservationsRepository reservationsRepository;

    public void saveReservation(Reservation newReservation){
        if (newReservation.getReservationDate().isBefore(LocalDate.now())) throw new RuntimeException("La data non può essere prima di quella odierna!");

        if (reservationsRepository.existsByStationAndReservationDate(newReservation.getStation(),newReservation.getReservationDate())){
            throw new RuntimeException("La postazione è già prenotata per questa data");
        }

        if(reservationsRepository.existsByUserAndReservationDate(newReservation.getUser(),newReservation.getReservationDate())){
            throw new RuntimeException("L'utente ha già una prenotazione per questa data");
        }

        reservationsRepository.save(newReservation);

        log.info("Nuova prenotazione creata con successo nel db");
    }
}
