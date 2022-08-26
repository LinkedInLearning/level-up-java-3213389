package com.linkedin.javacodechallenges;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Team team1 = new Team("Sally", "Roger");
        Team team2 = new Team("Eric", "Rebecca");
        Team team3 = new Team("Tony", "Shannon");

        List<Team> teams = List.of(team1, team2, team3);
        int numberOfRounds = 4;

        TeamUtils.generateTeamsScores(teams, numberOfRounds);

        TeamUtils.revealResults(teams);
    }
}
