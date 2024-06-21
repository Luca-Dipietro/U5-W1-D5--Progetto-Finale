package lucadipietro.U5_W1_D5__Progetto_Finale.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String address;
    private String city;
    @OneToMany(mappedBy = "building")
    private List<Station> stations;

    public Building(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
