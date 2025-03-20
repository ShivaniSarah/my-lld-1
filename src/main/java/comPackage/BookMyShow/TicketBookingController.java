package lld8;
import lld8.models.Seat;
import lld8.models.Show;
import lld8.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketBookingController {

    private final CinemaHallController cinemaHallController;
    private final Map<String, Ticket> allTicketsMap;

    public TicketBookingController(CinemaHallController cinemaHallController) {
        this.cinemaHallController = cinemaHallController;
        this.allTicketsMap = new HashMap<>();
    }

    public void bookTicket(Ticket ticket){
        allTicketsMap.put(ticket.getTicketId(),ticket);
        cinemaHallController.bookSeatsPerShow(ticket.getCinemaHallId(),ticket.getShowId(),ticket.getSeatsBooked());
    }

    public void cancelTicket(String ticketId){
        Ticket ticket = allTicketsMap.get(ticketId);
        cinemaHallController.cancelSeatsPerShow(ticket.getCinemaHallId(),ticket.getShowId(),ticket.getSeatsBooked());

    }
}
