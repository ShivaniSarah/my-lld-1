package org.example.cache;

import org.example.model.CacheData;
import org.example.model.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LFUCache implements Cache{

    private final int size;
    private final Map<String, CacheData> cache;

    public LFUCache(int size) {
        this.size = size;
        this.cache = new HashMap<>();
    }

    @Override
    public void put(String key, List<Movie> values) {

        if(cache.size()>= size){
            String lfukey = null;
            int minFrequency = Integer.MAX_VALUE;
            for( Map.Entry<String,CacheData> entry : cache.entrySet()){
                if(entry.getValue().getFrequency() <minFrequency){
                    minFrequency = entry.getValue().getFrequency();
                    lfukey = entry.getKey();
                }

            }
            if(Objects.nonNull(lfukey)){
                cache.remove(lfukey);
            }
        }

        cache.put(key,new CacheData(key,values));

    }

    @Override
    public List<Movie> get(String key) {
        CacheData entry = cache.get(key);
        if(Objects.nonNull(entry)){
            entry.incrementFrequency();
            return  entry.getResult();
        }
        return null;
    }

    public void clear() {
        cache.clear();
    }
}
