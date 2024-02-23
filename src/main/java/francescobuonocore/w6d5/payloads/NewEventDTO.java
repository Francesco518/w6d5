package francescobuonocore.w6d5.payloads;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record NewEventDTO(
        @NotEmpty(message = "The title is mandatory")
        String title,
        @NotEmpty(message = "The description is mandatory")
        String description,
        @NotEmpty(message = "The date is mandatory")
        LocalDate date,
        @NotEmpty(message = "The location is mandatory")
        String location,
        @NotEmpty(message = "The availability of the seats is mandatory")
        int availableSeats
) {
}

