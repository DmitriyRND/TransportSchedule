package org.example.transportschedule.dto;
import java.time.LocalDateTime;
import java.util.List;

public record TrainDto(
        String departureCity,
        String arrivalCity,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime,
        Double price,

        List<String> stops
) {
}
