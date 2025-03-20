package org.example;

import java.util.List;

public interface Trie {

    void addTrack(List<String> tags, Integer id);
    void stopTracking(Integer id);
    Integer getCounts(List<String> tags);
}
