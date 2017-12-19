package com.vlogellaa.espresso.ufl.models;


public class Game {
    private String time;
    private String league;
    private String team_one;
    private String team_two;

    public Game(String time, String team_one, String team_two, String league) {
        this.time = time;
        this.team_one = team_one;
        this.team_two = team_two;
        this.league = league;
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

    public String getLeague() { return league; }
}
