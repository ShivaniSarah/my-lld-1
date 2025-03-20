package org.example.service;

import org.example.cache.LRUCache;
import org.example.model.Movie;
import org.example.model.User;

import java.util.*;

public class UserService {

    private  final Map<String, User> users;
    private  final Map<String, LRUCache> userCaches;

    public UserService() {
        this.users = new HashMap<>();
        this.userCaches = new HashMap<>();
    }

    public void registerUser(User user,int cacheSize){
        users.put(user.getId(),user);
        userCaches.put(user.getId(),new LRUCache(cacheSize));
    }

    public List<Movie> getMovies(String userId, String query){
        LRUCache userCache = userCaches.get(userId);
        if(Objects.isNull(userCache)){
            throw new RuntimeException("User not present"+userId);
        }
        List<Movie> result = userCache.get(query);
        if(Objects.isNull(result)){
            return result;
        }
        return null;

    }

    public void updateCache(String userId, String query, List<Movie> result){
        LRUCache userCache = userCaches.get(userId);
        if(Objects.isNull(userCache)){
            throw new RuntimeException("User not present"+userId);
        }
        userCache.put(query,result);

    }

    public void clearCache(String userId) {
        LRUCache userCache = userCaches.get(userId);
        if(Objects.isNull(userCache)){
            throw new RuntimeException("User not present"+userId);
        }
        userCache.clear();
    }
}
