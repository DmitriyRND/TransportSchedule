package org.example.transportschedule.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
@Data
public class BusDto {
    @NotBlank(message = "departureCity is null")
    private String departureCity;

    @NotBlank(message = "arrivalCity is null")
    private String arrivalCity;

    private LocalDate departureTime;

    private LocalDate arrivalTime;
    @NotBlank(message = "price is null")
    @Positive(message = "price must be a positive number.")
    private double price;
}
