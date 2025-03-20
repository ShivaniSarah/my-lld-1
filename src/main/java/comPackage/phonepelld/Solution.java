package org.example;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

        // depenedency injection
        Trie trie = new TrieImpl();
        PendencySystemController pendencySystemController = new PendencySystemControllerImpl(trie);
        PendencySystem pendencySystem = new PendencySystemImpl(pendencySystemController);

        pendencySystem.startTracking(1112, new ArrayList<String>(){{add("UPI"); add("Karnataka"); add("Bangalore");}});
        pendencySystem.startTracking(2451, new ArrayList<String>(){{add("UPI"); add("Karnataka"); add("Mysore");}});
        pendencySystem.startTracking(3421, new ArrayList<String>(){{add("UPI"); add("Rajasthan"); add("Jaipur");}});
        pendencySystem.startTracking(1221, new ArrayList<String>(){{add("Wallet"); add("Karnataka"); add("Bangalore");}});

        System.out.println(pendencySystem.getCounts(new ArrayList<String>(){{add("UPI");}}));
        System.out.println(pendencySystem.getCounts(new ArrayList<String>(){{add("UPI");add("Karnataka");}}));
        System.out.println(pendencySystem.getCounts(new ArrayList<String>(){{add("UPI");add("Karnataka");add("Bangalore");}}));
        System.out.println(pendencySystem.getCounts(new ArrayList<String>(){{add("Bangalore");}}));

        pendencySystem.startTracking(4221, new ArrayList<String>(){{add("Wallet"); add("Karnataka"); add("Bangalore");}});
        pendencySystem.stopTracking(1112);
        pendencySystem.stopTracking(2451);

        System.out.println(pendencySystem.getCounts(new ArrayList<String>(){{add("UPI");}}));
        System.out.println(pendencySystem.getCounts(new ArrayList<String>(){{add("Wallet");}}));
        System.out.println(pendencySystem.getCounts(new ArrayList<String>(){{add("UPI");add("Karnataka");add("Bangalore");}}));

    }
}