package lucadipietro.U5_W1_D5__Progetto_Finale.repositories;

import lucadipietro.U5_W1_D5__Progetto_Finale.entities.Station;
import lucadipietro.U5_W1_D5__Progetto_Finale.enums.StationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationsRepository extends JpaRepository<Station,Long> {
    @Query("SELECT s FROM Station s WHERE s.stationType = :stationType AND s.building.city = :city")
    List<Station> searchByCityAndStationType(StationType stationType, String city);
}
