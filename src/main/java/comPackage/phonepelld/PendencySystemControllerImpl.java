package org.example;

import java.util.List;

class PendencySystemControllerImpl implements PendencySystemController {

    private Trie trie;

    PendencySystemControllerImpl(Trie trie) {
        this.trie = trie;
    }

    @Override
    public void startTracking(Integer id, List<String> hierarchicalTags) {
        trie.addTrack(hierarchicalTags, id);
    }

    @Override
    public void stopTracking(Integer id) {
        try {
            trie.stopTracking(id);
        } catch(IdNotFoundException e) {
            throw new InvalidIDException("Id not found");
        }

    }

    @Override
    public Integer getCounts(List<String> tags) {
        return trie.getCounts(tags);
    }

}