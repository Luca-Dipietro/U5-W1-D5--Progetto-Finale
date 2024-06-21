package lucadipietro.U5_W1_D5__Progetto_Finale;

import lucadipietro.U5_W1_D5__Progetto_Finale.service.BuildingsService;
import lucadipietro.U5_W1_D5__Progetto_Finale.service.ReservationsService;
import lucadipietro.U5_W1_D5__Progetto_Finale.service.StationsService;
import lucadipietro.U5_W1_D5__Progetto_Finale.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private UsersService usersService;
    @Autowired
    private ReservationsService reservationsService;
    @Autowired
    private BuildingsService buildingsService;
    @Autowired
    private StationsService stationsService;

    @Override
    public void run(String... args) throws Exception {

    }
}
