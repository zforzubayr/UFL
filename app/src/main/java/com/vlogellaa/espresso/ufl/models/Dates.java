package com.vlogellaa.espresso.ufl.models;


import com.vlogellaa.espresso.ufl.util.RandomizeGames;

import java.util.ArrayList;
import java.util.List;

public class Dates {
    private String date;
    private ArrayList<Game> games;

    public Dates(String date) {
        this.date = date;
        games = setGames();
    }

    public String getDate() {
        return date;
    }

    public List<Game> getGames() {
        return games;
    }

    private ArrayList<Game> setGames(){
        RandomizeGames rg = new RandomizeGames();
        return rg.gameList();
    }
}
