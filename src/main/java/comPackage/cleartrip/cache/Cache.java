package org.example.cache;

import org.example.model.Movie;

import java.util.List;

public interface Cache {

    void put(String key, List<Movie> value);
    List<Movie> get(String key);
    void clear();

}
