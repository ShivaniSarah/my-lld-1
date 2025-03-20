package org.example.cache;

import org.example.model.CacheData;
import org.example.model.Movie;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class LRUCache implements  Cache{

    private final int size;
    private final LinkedHashMap<String,CacheData> cache;

    public LRUCache(int size) {
        this.size = size;
        this.cache = new LinkedHashMap<>();
    }
// m3->m4->m1->m6
    @Override
    public void put(String key, List<Movie> values) {
        if(cache.size()>=size){
            Iterator<String> it  = cache.keySet().iterator();
            it.next();
            it.remove();
        }
        cache.put(key,new CacheData(key,values));
    }

    @Override
    public List<Movie> get(String key) {
        CacheData entry = cache.get(key);
//        if(Objects.nonNull(entry))  cache.put(entry.getKey(),entry.getVa)
        return Objects.nonNull(entry)? entry.getResult() : null ;

    }

    public void clear() {
        cache.clear();
    }
}
