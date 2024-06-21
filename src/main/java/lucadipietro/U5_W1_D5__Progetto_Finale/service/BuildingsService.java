package lucadipietro.U5_W1_D5__Progetto_Finale.service;

import lombok.extern.slf4j.Slf4j;
import lucadipietro.U5_W1_D5__Progetto_Finale.entities.Building;
import lucadipietro.U5_W1_D5__Progetto_Finale.exceptions.NotFoundException;
import lucadipietro.U5_W1_D5__Progetto_Finale.repositories.BuildingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuildingsService {
    @Autowired
    private BuildingsRepository buildingsRepository;

    public void saveBuilding(Building newBuilding){
        if (buildingsRepository.existsByNameAndCity(newBuilding.getName(),newBuilding.getCity())){
            throw new RuntimeException("L'edificio " + newBuilding.getName() + " situato " + newBuilding.getCity() + " è già nel db");
        }

        buildingsRepository.save(newBuilding);

        log.info("Nuovo edificio " + newBuilding.getName() + " salvato con successo nel db");
    }

    public Building findById(long id){
        return buildingsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(long id) {
        Building found = this.findById(id);
        buildingsRepository.delete(found);
        log.info("Edifico con id " + id + " eliminato correttamente");
    }
}
