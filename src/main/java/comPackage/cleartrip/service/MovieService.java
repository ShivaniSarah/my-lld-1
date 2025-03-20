package org.example.service;

import org.example.cache.LFUCache;
import org.example.db.Database;
import org.example.model.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MovieService {

    private final Database database;
    UserService  userService;
    LFUCache globalCache;
    private   int l1CacheHits;
    private  int l2cacheHits;
    private int databaseHits;
    private   int totalSearches;

    public MovieService(Database database, UserService userService, LFUCache globalCache) {
        this.database = database;
        this.globalCache = globalCache;
        this.userService= userService;
        this.l1CacheHits = 0;
        this.l2cacheHits =0;
        this.databaseHits = 0;
        this.totalSearches = 0;
    }

    public void addMovie(Movie movie){
        database.addMovie(movie);
    }

    public List<Movie> searchMovies(String userId, String title, String genre, Integer releaseYear, Double rating){
        totalSearches++;
        String query = generateQueryKey(title,genre,releaseYear,rating);
        List<Movie> result = userService.getMovies(userId,query);
        if(Objects.nonNull(result)){
            l1CacheHits++;
            return result;
        }

        result = globalCache.get(query);
        if(Objects.nonNull(result)){
            l2cacheHits++;
            userService.updateCache(userId,query,result);
            return result;

        }

        result = database.searchMovies(title,genre,releaseYear,rating);
        databaseHits++;
        userService.updateCache(userId,query,result);
        globalCache.put(query,result);
        return result;
    }

    private String  generateQueryKey(String title, String genre, Integer releaseYear, Double rating){
        return
                (Objects.nonNull(title)? title: "")+ "#"+
                        (Objects.nonNull(genre)? genre: "")+ "#"+
                        (Objects.nonNull(releaseYear)? releaseYear: "")+ "#"+
                        (Objects.nonNull(rating)?rating : "");

    }

    public  Map<String,Integer> getStats(){
        Map<String,Integer> stats = new HashMap<>();
        stats.put("l1CacheHits", l1CacheHits);
        stats.put("l2cacheHits", l2cacheHits);
        stats.put("totalSearches", totalSearches);
        stats.put("totalSearches", totalSearches);
        return stats;
    }

}
