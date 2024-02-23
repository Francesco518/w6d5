package francescobuonocore.w6d5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;

    private LocalDate date;

    private String location;

    private int availableSeats;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
