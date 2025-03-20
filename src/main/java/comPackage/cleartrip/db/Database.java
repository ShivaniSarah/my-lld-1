package org.example.db;

import org.example.model.Movie;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Database {
    private  final Map<String, Movie> movieDatabase;

    public Database() {
        this.movieDatabase = new HashMap<>();
    }

    public void addMovie(Movie movie){
        movieDatabase.put(movie.getId(),movie);
    }



    public  List<Movie> searchMovies(String title, String genre, Integer releaseYear, Double rating){
        List<Movie> results = new ArrayList<>();

        movieDatabase.values().stream().filter( movie -> {
            return (title == null) || (movie.getTitle().equalsIgnoreCase(title)) &&
                    (genre == null) || (movie.getGenre().name().equalsIgnoreCase(genre)) &&
                    ((releaseYear == null) || (movie.getReleaseYear() == releaseYear)) &&
                    ((rating == null) || (movie.getRating() >= rating));
        } ).collect(Collectors.toList());

//        for(Movie movie: movieDatabase.values()){
//            if((title == null) || (movie.getTitle().equalsIgnoreCase(title)) &&
//                    (genre == null) || (movie.getGenre().name().equalsIgnoreCase(genre)) &&
//                    ((releaseYear == null) || ( movie.getReleaseYear() == releaseYear )) &&
//                    ( ( rating == null )|| (movie.getRating() >= rating ))
//            )
//                results.add(movie);
//        }

        return  results;
    }
}
