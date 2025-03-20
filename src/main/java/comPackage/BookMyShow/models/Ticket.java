package lld8.models;

import java.time.LocalDate;
import java.util.List;

public class Ticket {
    private final String ticketId;
    private final String userId;
    private final String showId;
    private final double totalAmountPaid;
    private final LocalDate bookingTime;
    private final List<String> seatsBooked;
    private final String cinemaHallId;

    public Ticket(String ticketId, String userId, String showId, Integer noOfPeople, double totalAmountPaid, LocalDate bookingTime, List<String> seatsBooked, String cinemaHallId) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.showId = showId;
        this.totalAmountPaid = totalAmountPaid;
        this.bookingTime = bookingTime;
        this.seatsBooked = seatsBooked;
        this.cinemaHallId = cinemaHallId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getUserId() {
        return userId;
    }

    public String getShowId() {
        return showId;
    }

    public double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public LocalDate getBookingTime() {
        return bookingTime;
    }

    public List<String> getSeatsBooked() {
        return seatsBooked;
    }

    public String getCinemaHallId() {
        return cinemaHallId;
    }
}
