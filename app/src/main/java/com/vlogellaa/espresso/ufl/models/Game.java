package com.vlogellaa.espresso.ufl.models;


public class Game {
    private String time;
    private String team_one;
    private String team_two;

    public Game(String time, String team_one, String team_two) {
        this.time = time;
        this.team_one = team_one;
        this.team_two = team_two;
    }

    public String getTime() {
        return time;
    }

    public String getTeam_one() {
        return team_one;
    }

    public String getTeam_two() {
        return team_two;
    }
}
