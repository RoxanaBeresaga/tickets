package com.codoacodo.tickets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
    public class FlightDto {
        private Long id;
        private String origin;
        private String destiny;
        private String departureTime;
        private String arrivingTime;
        private double convertedPrice;
    }

