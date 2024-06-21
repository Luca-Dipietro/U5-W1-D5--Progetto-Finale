package lucadipietro.U5_W1_D5__Progetto_Finale.service;

import lombok.extern.slf4j.Slf4j;
import lucadipietro.U5_W1_D5__Progetto_Finale.entities.Station;
import lucadipietro.U5_W1_D5__Progetto_Finale.enums.StationType;
import lucadipietro.U5_W1_D5__Progetto_Finale.exceptions.NotFoundException;
import lucadipietro.U5_W1_D5__Progetto_Finale.repositories.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StationsService {
    @Autowired
    private StationsRepository stationsRepository;

    public void saveStation(Station newStation){
        stationsRepository.save(newStation);

        log.info("La postazione nell'edificio " + newStation.getBuilding().getName() + " salvata con successo nel db");
    }

    public Station findById(long id){
        return stationsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(long id) {
        Station found = this.findById(id);
        stationsRepository.delete(found);
        log.info("Edifico con id " + id + " eliminato correttamente");
    }

    public List<Station> searchByCityAndStationType(StationType stationType, String city) {
        return stationsRepository.searchByCityAndStationType(stationType, city);
    }
}
