package org.example.model;

import java.util.List;

public class CacheData {
    private final String query;
    private final List<Movie> result;
    private int frequency;

    public CacheData(String query, List<Movie> result) {
        this.query = query;
        this.result = result;
        this.frequency = 1;
    }

    public void incrementFrequency(){
        this.frequency++;
    }

    public String getQuery() {
        return query;
    }

    public List<Movie> getResult() {
        return result;
    }

    public int getFrequency() {
        return frequency;
    }
}
