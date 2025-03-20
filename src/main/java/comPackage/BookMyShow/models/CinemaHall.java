package lld8.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CinemaHall {
    private final  String cinemaHallId;
    private final String cinemaHallName;
    private final  String location;

    private final Map<String,Movie> movieMap;
    private final Map<String,Show> shows;

    public CinemaHall(String cinemaHallId, String cinemaHallName, String location) {
        this.cinemaHallId = cinemaHallId;
        this.cinemaHallName = cinemaHallName;
        this.location = location;

        this.movieMap = new HashMap<>();
        this.shows = new HashMap<>();
    }

    public String getCinemaHallId() {
        return cinemaHallId;
    }



    public void addMovies(Movie movie){
        movieMap.put(movie.getMovieId(),movie);
    }

    public void addShows(Show show){
        shows.put(show.getShowId(),show);
    }

   public boolean checkIfMovieExists(String movieId){
        return movieMap.containsKey(movieId);
   }

   public List<Show> getShowsPerMovie(String movieId){
        return shows.values().stream().filter(s->s.getMovieId().equalsIgnoreCase(movieId)).collect(Collectors.toList());
   }

    public void bookSeatsPerShow(String showId, List<String> seatIds){
        shows.get(showId).bookSeatMatrix(seatIds);
    }
    public void cancelSeatsPerShow(String showId, List<String> seatIds){
        shows.get(showId).cancelSeatMatrix(seatIds);
    }

}
