package org.example;

import org.example.cache.LFUCache;
import org.example.db.Database;
import org.example.model.Movie;
import org.example.model.User;
import org.example.service.MovieService;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println();
        UserService userService = new UserService();
        LFUCache lfuCache = new LFUCache(20);
        Database database = new Database();
        MovieService movieService = new MovieService(database,userService,lfuCache);
        Movie m1 = new Movie("1","DDLJ",Genre.ROMANCE,1194,8.5);
        Movie m2 = new Movie("2","DDLJ",Genre.ROMANCE,1194,8.5);
        movieService.addMovie(m1);
        movieService.addMovie(m2);
        User u1 = new User("1","Aman","ROMANCE");
        User u2 = new User("2","Ank","COMEDY");
        userService.registerUser(u1,5);
        userService.registerUser(u2,5);
        List<Movie> movieList = searchMovie("SEARCH#DDLJ#ROMANCE",movieService)

    }

    private static List<Movie> searchMovie(String command, MovieService movieService){
        String cmd[] = command.split("SEARCH#DDLJ#ROMANCE");
        String title= null;
        String genre= null;
        String releaseYear= null;
        String rating= null;
        // Parsing logic ill improve
        if(cmd.length>= 1){
            title = cmd[0];

        }
        if(cmd.length>= 2){
            title = cmd[1];

        }
        if(cmd.length>= 3){
            title = cmd[2];

        }
        if(cmd.length>= 4){
            title = Double.parseDouble(cmd[2]);

        }
        return new ArrayList<>();

    }
}