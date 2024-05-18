package com.codoacodo.tickets.service;

import com.codoacodo.tickets.model.FlightDto;
import com.codoacodo.tickets.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final List<Ticket> ticketList = new ArrayList<Ticket>();

    @Autowired
    private FlightClient flightClient;

    public List<Ticket> getAllTickets() {

        return ticketList;
    }


    public Ticket addTicket(Ticket ticket, Long id) {

        FlightDto flightToTicket = flightClient.getFlightById(id)
                .orElseThrow(() -> new RuntimeException("Flight with id " + id + " not found"));
                ticket.setFlight(flightToTicket);
                ticketList.add(ticket);
                return ticket;
        }

    public Optional<FlightDto> getFlightById(Long id) {

        return flightClient.getFlightById(id);
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketList.stream()
                .filter(ticket -> ticket.getId().equals(id))
                .findFirst();
    }

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        Optional<Ticket> existingTicketOpt = getTicketById(id);
        if (existingTicketOpt.isPresent()) {
            Ticket existingTicket = existingTicketOpt.get();
            existingTicket.setFlight(updatedTicket.getFlight());
            existingTicket.setPassengerName(updatedTicket.getPassengerName());
            existingTicket.setPassengerEmail(updatedTicket.getPassengerEmail());
            existingTicket.setPassengerPassport(updatedTicket.getPassengerPassport());
            return existingTicket;
        } else {
            throw new RuntimeException("Ticket with id " + id + " not found");
        }
    }

    public void deleteTicket(Long id) {
        ticketList.removeIf(ticket -> ticket.getId().equals(id));
    }

}
