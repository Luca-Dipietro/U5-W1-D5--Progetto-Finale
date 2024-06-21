package lucadipietro.U5_W1_D5__Progetto_Finale.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "reservation_date")
    private LocalDate reservationDate;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    public Reservation(LocalDate reservationDate, User user, Station station) {
        this.reservationDate = reservationDate;
        this.expirationDate = reservationDate.plusDays(1);
        this.user = user;
        this.station = station;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationDate=" + reservationDate +
                ", expirationDate=" + expirationDate +
                ", user=" + user +
                ", station=" + station +
                '}';
    }
}
