package org.example;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TrieImpl implements Trie  {

    private TrieNode rootNode;
    private Map<Integer, TrieNode> metadataLookup;
    private Lock lock;

    TrieImpl() {
        this.rootNode = new TrieNode();
        this.metadataLookup = new HashMap<>();
        this.lock = new ReentrantLock();
    }


    @Override
    public void addTrack(List<String> tags, Integer id) {
        try {
            lock.lock();
            TrieNode currentNode = this.rootNode;
            for(String tag : tags) {
                if(currentNode.getChildren().containsKey(tag)) {
                    currentNode = currentNode.getChildren().get(tag);
                } else {
                    Map<String, TrieNode> children = currentNode.getChildren();
                    children.put(tag, new TrieNode());
                    currentNode = currentNode.getChildren().get(tag);
                }
            }
            // add the tracker
            currentNode.addMetadata(id);
            this.metadataLookup.put(id, currentNode);
        } finally {
            lock.unlock();
        }

    }

    @Override
    public void stopTracking(Integer id) {
        try {
            lock.lock();
            if(!this.metadataLookup.containsKey(id)) {
                throw new IdNotFoundException("passed ID does not exitst");
            }
            TrieNode trieNode = this.metadataLookup.get(id);
            Set<Integer> ids = trieNode.getMetadata();
            ids.remove(id);
        } finally {
            lock.unlock();
        }

    }

    @Override
    public Integer getCounts(List<String> tags) {
        // Step 1: reach to the targetNode
        TrieNode currentNode = this.rootNode;
        for(String tag : tags) {
            if(currentNode.getChildren().containsKey(tag)) {
                currentNode = currentNode.getChildren().get(tag);
            } else {
                return 0;
            }
        }

        int count = 0;

        // Step 2: Apply BFS and count all the entities in the sub tree
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(currentNode);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                TrieNode node = queue.poll();
                count += node.getMetadata().size();
                Map<String, TrieNode> children = node.getChildren();
                for(Map.Entry<String, TrieNode> entry : children.entrySet()) {
                    queue.offer(entry.getValue());
                }
            }
        }
        return count;

    }
}
