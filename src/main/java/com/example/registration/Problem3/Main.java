package com.example.registration.Problem3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Jone", 20);
        Player p2 = new Player("Smith", 15);
        Player p3 = new Player("Smith", 20);
        List<Player> players = new ArrayList<Player>();
        players.add(p1);players.add(p2);players.add(p3);
        Collections.sort(players, new Checker());
        for(Player p: players){
            System.out.println(String.format("%s %s",p.getName(),p.getScore()));
        }
    }
}
