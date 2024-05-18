package com.codoacodo.tickets.controller;

import com.codoacodo.tickets.model.FlightDto;
import com.codoacodo.tickets.model.Ticket;
import com.codoacodo.tickets.service.FlightClient;
import com.codoacodo.tickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {


    @Autowired
    private TicketService ticketService;

    @Autowired
    private FlightClient flightClient;

    @GetMapping("")
    public List<Ticket> getAllTickets(){

        return ticketService.getAllTickets();
    }

    @GetMapping("/flights")
    public List<FlightDto> getAllFligts(){

        return flightClient.geAllFlights();
    }

    /*
    @PostMapping("/add")
    public Ticket addTicket(@RequestBody Ticket ticket) {

        return ticketService.addTicket(ticket);
    } */

    @PostMapping("/add/{flightId}")
    public Ticket addTicket(@RequestBody Ticket ticket, @PathVariable Long flightId) {

        return ticketService.addTicket(ticket, flightId);
    }

    @GetMapping("/flights/{id}")
    public Optional<FlightDto> getFlightById(@PathVariable Long id) {

        return ticketService.getFlightById(id);
    }


    @GetMapping("/{id}")
    public Optional<Ticket> getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @PutMapping("/update/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        return ticketService.updateTicket(id, ticket);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }

}
