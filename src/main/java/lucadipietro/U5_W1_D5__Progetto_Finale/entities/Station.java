package lucadipietro.U5_W1_D5__Progetto_Finale.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lucadipietro.U5_W1_D5__Progetto_Finale.enums.StationType;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "stations")
public class Station {
    @Id
    @GeneratedValue
    private long id;
    private String description;
    @Enumerated(EnumType.STRING)
    private StationType stationType;
    @Column(name = "num_max_occupants")
    private int numMaxOccupants;
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    @OneToMany(mappedBy = "station")
    private List<Reservation> reservations;

    public Station(String description, StationType stationType, int numMaxOccupants, Building building) {
        this.description = description;
        this.stationType = stationType;
        this.numMaxOccupants = numMaxOccupants;
        this.building = building;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", stationType=" + stationType +
                ", numMaxOccupants=" + numMaxOccupants +
                ", building=" + building +
                '}';
    }
}
