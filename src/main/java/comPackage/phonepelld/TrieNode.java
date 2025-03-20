package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TrieNode {
    private Map<String, TrieNode> children;
    private Set<Integer> metadata;

    TrieNode() {
        children = new HashMap<>();
        metadata = new HashSet<>();
    }

    Map<String, TrieNode> getChildren() {
        return children;
    }

    void addMetadata(Integer id) {
        metadata.add(id);
    }

    Set<Integer> getMetadata() {
        return metadata;
    }

}
