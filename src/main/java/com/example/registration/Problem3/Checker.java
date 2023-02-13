package com.example.registration.Problem3;

import java.util.Comparator;

public class Checker implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        if(p1.getScore() > p2.getScore()){
            return 1;
        }
        else if(p1.getScore() < p2.getScore()){
            return -1;
        }
        else {
            return p1.getName().compareTo(p2.getName());
        }
    }
}
