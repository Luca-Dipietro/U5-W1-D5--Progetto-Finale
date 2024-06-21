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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String name;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;

    public User(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
