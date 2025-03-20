package org.example;

import java.util.List;

class PendencySystemImpl implements PendencySystem {

    private PendencySystemController pendencySystemController;

    PendencySystemImpl(PendencySystemController pendencySystemController) {
        this.pendencySystemController = pendencySystemController;
    }

    @Override
    public void startTracking(Integer id, List<String> hierarchicalTags) {
        pendencySystemController.startTracking(id, hierarchicalTags);
    }

    @Override
    public void stopTracking(Integer id) {
        pendencySystemController.stopTracking(id);
    }

    @Override
    public Integer getCounts(List<String> tags) {
        return pendencySystemController.getCounts(tags);
    }
}
