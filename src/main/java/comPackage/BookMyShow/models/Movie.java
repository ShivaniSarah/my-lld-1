package lld8.models;

public class Movie {
    private final String movieId;
    private final String movieName;

    public Movie(String movieId, String movieName) {
        this.movieId = movieId;
        this.movieName = movieName;
    }

    public String getMovieId() {
        return movieId;
    }
}
