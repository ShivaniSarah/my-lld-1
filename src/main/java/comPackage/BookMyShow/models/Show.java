package lld8.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Show {
    private final  String showId;
    private final String cinemaHallId;
    private final  String movieId;
    private final  LocalDate startTime;
    private final  Integer durationInMinutes;
    private final ConcurrentHashMap<String,Seat> seatMatrix;

    public Show(String showId, String cinemaHallId, String movieId, LocalDate startTime, Integer durationInMinutes) {
        this.showId = showId;
        this.cinemaHallId = cinemaHallId;
        this.movieId = movieId;
        this.startTime = startTime;
        this.durationInMinutes = durationInMinutes;
        this.seatMatrix = new ConcurrentHashMap<>();
    }

    public void addSeatMatrix(List<String> listSeatId, List<SeatType> seatTypeList){ // "A1", SeatType.GOLD
        for(int i=0;i<listSeatId.size();i++){
            this.seatMatrix.put( listSeatId.get(i) ,new Seat(listSeatId.get(i),seatTypeList.get(i)));
        }
    }
    public String getShowId() {
        return showId;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getCinemaHallId() {
        return cinemaHallId;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public Map<String, Seat> getSeatMatrix() {
        return seatMatrix;
    }

    public void bookSeatMatrix(List<String> seatIds){
        for(String s: seatIds){
            seatMatrix.get(s).bookSeatBookingStatus();
        }
    }
    public void cancelSeatMatrix(List<String> seatIds){
        for(String s: seatIds){
            seatMatrix.get(s).cancelSeatBookingStatus();
        }
    }
}

