package org.example.service;

import org.example.CacheLevel;
import org.example.cache.LFUCache;
import org.example.model.CacheData;

public class CacheService {
    private UserService userService;
    private final LFUCache lfuCache;

    public CacheService(LFUCache lfuCache, UserService userService) {
        this.lfuCache = lfuCache;
        this.userService = userService;
    }

    public void clearCache(String userId, CacheLevel cacheLevel){
        if (cacheLevel.equals(CacheLevel.LEVEL_1)) {

            userService.clearCache(userId);
        }
        else {
            lfuCache.clear();
        }
    }
}
