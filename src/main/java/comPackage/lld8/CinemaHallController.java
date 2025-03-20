package comPackage.lld8;

import comPackage.lld8.models.Show;
import comPackage.lld8.models.CinemaHall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CinemaHallController {
    private final Map<String,CinemaHall> cinemaHalls;

    public CinemaHallController() {
        this.cinemaHalls = new HashMap<>();
    }

    public void addCinemaHall(CinemaHall cinemaHall){
        cinemaHalls.put(cinemaHall.getCinemaHallId(), cinemaHall);
    }

    public void addShowInCinemaHall(String cinemaHallId , Show show){
        cinemaHalls.get(cinemaHallId).addShows(show);
    }

    public List<CinemaHall> showCinemaHallsPermovie(String movieId ){

        return cinemaHalls.values().stream().filter(c->c.checkIfMovieExists(movieId)).collect(Collectors.toList());

//        return cinemaHalls.entrySet().stream().map(Map.Entry::getValue).filter(c->c.checkIfMovieExists(movieId)).collect(Collectors.toList());

//        return cinemaHalls.entrySet().stream().map(e->e.getValue()).filter(c->c.checkIfMovieExists(movieId)).collect(Collectors.toList());

//        List<CinemaHall> cinemaHallList= new ArrayList<>();
//        for(Map.Entry<String,CinemaHall> entry: cinemaHalls.entrySet()){
//            CinemaHall cinemaHall = entry.getValue();
//            if(cinemaHall.checkIfMovieExists(movieId)){
//                cinemaHallList.add(cinemaHall);
//            }
//        }
//        return cinemaHallList;
    }

    public List<Show> displayShowsInCinemaHall(String movieId, String cinemaHallId ){

        return cinemaHalls.values().stream().filter(c->c.getCinemaHallId().equalsIgnoreCase(cinemaHallId)).findFirst().map(c->c.getShowsPerMovie(movieId)).orElse(new ArrayList<>());

//        for(Map.Entry<String,CinemaHall> entry : cinemaHalls.entrySet() ){
//            CinemaHall cinemaHall = entry.getValue();
//            if(cinemaHall.getCinemaHallId().equalsIgnoreCase(cinemaHallId)){
//                return cinemaHall.getShowsPerMovie(movieId);
//            }
//        }
//        return new ArrayList<>();
    }

    public void bookSeatsPerShow(String cinemaHallId, String showId, List<String> seatIds){
        cinemaHalls.get(cinemaHallId).bookSeatsPerShow(showId,seatIds);
    }

    public void cancelSeatsPerShow(String cinemaHallId, String showId, List<String> seatIds){
        cinemaHalls.get(cinemaHallId).cancelSeatsPerShow(showId,seatIds);
    }

}
