package com.vlogellaa.espresso.ufl.util;


import com.vlogellaa.espresso.ufl.db.Teams;
import com.vlogellaa.espresso.ufl.models.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RandomizeGames {
    public ArrayList<Game> gameList(){
        ArrayList<Game> games= new ArrayList<>();
        int randomNum = 1 + (int)(Math.random() * 5);

        for(int index = 1; index <= randomNum; index++){
            games.add(generateGame());
        }

        return games;
    }

    private Game generateGame(){
        List<String> teams = pickRandomTeams();
        return new Game(teams.get(0), teams.get(1), setRandomTimes());
    }

    private List<String> pickRandomTeams() {
        List<String> copy = new LinkedList<>(Arrays.asList(Teams.ALL_TEAMS));
        Collections.shuffle(copy);
        return copy.subList(0, 2);
    }

    private String setRandomTimes(){
        String hour = (int) (Math.random() * 23) + "";
        String minute = (int) (Math.random() * 59) + "";
        if (hour.length() == 1){
             hour = "0" + hour;
        }

        if (minute.length() == 1){
            minute = "0" + minute;
        }
        
        return  hour + ":" + minute;
    }

}
