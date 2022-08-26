package com.linkedin.javacodechallenges;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TeamUtils {

  public static void generateTeamsScores(List<Team> teams,
      int numberOfRounds) {
    Random random = new Random();
    teams.forEach(team -> {
      for (int i = 0; i < numberOfRounds; i++) {
        team.getScores().add(random.nextInt(11));
      }
    });
  }

  public static void revealResults(List<Team> teams) {

    if (teams.size() == 0 || teams.stream()
        .allMatch(team -> team.getScores().isEmpty())) {
      System.out.println("The game hasn't started yet.");
      return;
    }

    TreeMap<Integer, List<Team>> scoreTeamsMap = teams.stream()
        .collect(Collectors.groupingBy(Team::sumTotalScore,
            TreeMap::new, Collectors.toList()));
    Iterator<Integer> scoreResultsIterator = scoreTeamsMap.descendingKeySet()
        .stream()
        .iterator();

    System.out.println("Now for the results, the WINNER is...");
    announceResult(scoreResultsIterator.next(), scoreTeamsMap);

    while (scoreResultsIterator.hasNext()) {
      System.out.println("Then we have... ");
      announceResult(scoreResultsIterator.next(), scoreTeamsMap);
    }
  }

  private static void announceResult(int score,
      TreeMap<Integer, List<Team>> scoreTeamsMap) {

    List<Team> playersWithScore = scoreTeamsMap.get(score);

    if (playersWithScore.size() > 1) {
      System.out.println("It's a TIE!");
    }

    playersWithScore
        .forEach(team -> System.out.println("With " + score +
            " points, it's team " + team.getPlayer1() + " and " +
            team.getPlayer2() + "!"));

    System.out.println();
  }

}