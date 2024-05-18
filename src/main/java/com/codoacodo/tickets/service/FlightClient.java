package com.codoacodo.tickets.service;

import com.codoacodo.tickets.model.FlightDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "flight-api")
public interface FlightClient {
    @GetMapping("/flights")
    List<FlightDto> geAllFlights();

    @GetMapping("/flights/{id}")
    Optional<FlightDto> getFlightById(@PathVariable Long id);
}
