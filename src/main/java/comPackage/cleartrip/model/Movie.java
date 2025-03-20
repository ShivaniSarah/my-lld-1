package org.example.model;

import org.example.Genre;

public class Movie {

    private final String id;
    private final String title;
    private final Genre genre;
    private final int releaseYear;
    private final double rating;

    public Movie(String id, String title, Genre genre, int releaseYear, double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

//    private filterMovies(Movie movie){
//        if((title == null) || (movie.getTitle().equalsIgnoreCase(title)) &&
//                (genre == null) || (movie.getGenre().name().equalsIgnoreCase(genre)) &&
//                ((releaseYear == null) || ( movie.getReleaseYear() == releaseYear )) &&
//                ( ( rating == null )|| (movie.getRating() >= rating ))
//        )
//            return true;
//        return false;
//    }
}