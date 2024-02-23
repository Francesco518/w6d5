package francescobuonocore.w6d5.payloads;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class NewEventPayload {
    private long userId;

    private String title;

    private String description;

    private LocalDate date;

    private String location;

    private int availableSeats;
}


