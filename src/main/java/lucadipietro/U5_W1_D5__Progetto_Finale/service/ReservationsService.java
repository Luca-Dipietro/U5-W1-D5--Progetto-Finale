package lucadipietro.U5_W1_D5__Progetto_Finale.service;

import lucadipietro.U5_W1_D5__Progetto_Finale.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationsService {
    @Autowired
    private ReservationsRepository reservationsRepository;
}
