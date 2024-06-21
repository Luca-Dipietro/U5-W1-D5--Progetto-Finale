package lucadipietro.U5_W1_D5__Progetto_Finale;

import com.github.javafaker.Faker;
import lucadipietro.U5_W1_D5__Progetto_Finale.entities.Building;
import lucadipietro.U5_W1_D5__Progetto_Finale.entities.Station;
import lucadipietro.U5_W1_D5__Progetto_Finale.entities.User;
import lucadipietro.U5_W1_D5__Progetto_Finale.enums.StationType;
import lucadipietro.U5_W1_D5__Progetto_Finale.service.BuildingsService;
import lucadipietro.U5_W1_D5__Progetto_Finale.service.ReservationsService;
import lucadipietro.U5_W1_D5__Progetto_Finale.service.StationsService;
import lucadipietro.U5_W1_D5__Progetto_Finale.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

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
        Faker faker = new Faker();
        Random random = new Random();

        for (int i = 0; i < 10; i++){
            User user = new User(faker.leagueOfLegends().champion(),faker.gameOfThrones().character(),faker.internet().emailAddress());
            usersService.saveUser(user);
        }

        for (int i = 0; i < 5; i++){
            Building building = new Building(faker.company().name(),faker.address().fullAddress(),faker.address().city());
            buildingsService.saveBuilding(building);
        }

        for (int i = 0; i < 5; i++){
            StationType stationType = StationType.values()[random.nextInt(StationType.values().length)];
            Station station = new Station(faker.howIMetYourMother().catchPhrase(),stationType,faker.number().numberBetween(2,50),buildingsService.findById(faker.number().numberBetween(1,5)));
            stationsService.saveStation(station);
        }

    }
}
