package lucadipietro.U5_W1_D5__Progetto_Finale.repositories;

import lucadipietro.U5_W1_D5__Progetto_Finale.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingsRepository extends JpaRepository<Building,Long> {
    boolean existsByNameAndCity(String name, String city);
}
