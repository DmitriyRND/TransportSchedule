package org.example.transportschedule.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record BusDto(
        @NotBlank(message = "departureCity is null")
        String departureCity,
        @NotBlank(message = "arrivalCity is null")
        String arrivalCity,
        LocalDateTime departureTime,
        LocalDateTime arrivalTime,
        @NotBlank(message = "price is null")
        @Positive(message = "price must be a positive number.")
        Double price
) {

}
