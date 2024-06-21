package lucadipietro.U5_W1_D5__Progetto_Finale.repositories;

import lucadipietro.U5_W1_D5__Progetto_Finale.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationsRepository extends JpaRepository<Station,Long> {
}
