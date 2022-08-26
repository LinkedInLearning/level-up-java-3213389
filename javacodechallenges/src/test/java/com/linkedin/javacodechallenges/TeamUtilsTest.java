package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TeamUtilsTest {

  private static final Team team1 = new Team("Sally", "Roger");
  private static final Team team2 = new Team("Eric", "Rebecca");
  private static final Team team3 = new Team("Tony", "Shannon");

  private final ByteArrayOutputStream printOut = new ByteArrayOutputStream();

  @Before
  public void setUpEach() {
    System.setOut(new PrintStream(printOut));
  }

  @After
  public void cleanUpEach() {
    System.setOut(System.out);
    team1.getScores().clear();
    team2.getScores().clear();
    team3.getScores().clear();
  }

  @Test
  public void generateTeamsScores() {
    List<Team> teams = List.of(team1, team2, team3);
    int numberOfRounds = 4;

    TeamUtils.generateTeamsScores(teams, numberOfRounds);

    teams.forEach(team -> {
      List<Integer> scores = team.getScores();
      assertEquals(numberOfRounds, scores.size());
      scores.forEach(score -> assertTrue(score >= 0));
    });
  }

  @Test
  public void generateTeamsScores_emptyTeamsInput() {

    List<Team> teams = List.of();
    TeamUtils.generateTeamsScores(teams, 3);

    assertEquals(0, teams.size());
  }

  @Test
  public void generateTeamsScores_noRounds() {

    List<Team> teams = List.of(team1, team2, team3);
    int numberOfRounds = 0;

    TeamUtils.generateTeamsScores(teams, numberOfRounds);

    teams.forEach(team -> assertEquals(numberOfRounds, team.getScores().size()));
  }

  @Test
  public void revealResults() {
    team1.getScores().addAll(List.of(2, 4, 5));
    team2.getScores().addAll(List.of(8, 3, 4));
    team3.getScores().addAll(List.of(9, 2, 1));

    List<Team> teams = List.of(team1, team2, team3);
    TeamUtils.revealResults(teams);

    assertEquals("Now for the results, the WINNER is...\n" +
        "With 15 points, it's team Eric and Rebecca!\n" +
        "\n" +
        "Then we have... \n" +
        "With 12 points, it's team Tony and Shannon!\n" +
        "\n" +
        "Then we have... \n" +
        "With 11 points, it's team Sally and Roger!\n" +
        "\n", printOut.toString());
  }

  @Test
  public void revealResults_unevenRounds() {
    team1.getScores().addAll(List.of(2, 5));
    team2.getScores().addAll(List.of(8, 3, 4));
    team3.getScores().addAll(List.of(9));

    List<Team> teams = List.of(team1, team2, team3);
    TeamUtils.revealResults(teams);

    assertEquals("Now for the results, the WINNER is...\n" +
        "With 15 points, it's team Eric and Rebecca!\n" +
        "\n" +
        "Then we have... \n" +
        "With 9 points, it's team Tony and Shannon!\n" +
        "\n" +
        "Then we have... \n" +
        "With 7 points, it's team Sally and Roger!\n" +
        "\n", printOut.toString());
  }

  @Test
  public void revealResults_noScores() {

    List<Team> teams = List.of(team1, team2, team3);
    TeamUtils.revealResults(teams);

    assertEquals("The game hasn't started yet.\n", printOut.toString());
  }

  @Test
  public void revealResults_noTeams() {

    List<Team> teams = List.of();
    TeamUtils.revealResults(teams);

    assertEquals("The game hasn't started yet.\n", printOut.toString());
  }

  @Test
  public void revealResults_tiedWinner() {

    List<Team> teams = List.of(team1, team2, team3);
    team1.getScores().addAll(List.of(3, 3, 3, 3));
    team2.getScores().addAll(List.of(4, 2, 2, 4));
    team3.getScores().addAll(List.of(5, 0, 3, 2));

    TeamUtils.revealResults(teams);

    assertEquals("Now for the results, the WINNER is...\n" +
        "It's a TIE!\n" +
        "With 12 points, it's team Sally and Roger!\n" +
        "With 12 points, it's team Eric and Rebecca!\n" +
        "\n" +
        "Then we have... \n" +
        "With 10 points, it's team Tony and Shannon!\n" +
        "\n", printOut.toString());
  }

  @Test
  public void revealResults_tiedNonWinner() {

    List<Team> teams = List.of(team1, team2, team3);
    team1.getScores().addAll(List.of(3, 4, 2, 5));
    team2.getScores().addAll(List.of(1, 4, 2, 3));
    team3.getScores().addAll(List.of(5, 0, 3, 2));

    TeamUtils.revealResults(teams);

    assertEquals("Now for the results, the WINNER is...\n" +
        "With 14 points, it's team Sally and Roger!\n" +
        "\n" +
        "Then we have... \n" +
        "It's a TIE!\n" +
        "With 10 points, it's team Eric and Rebecca!\n" +
        "With 10 points, it's team Tony and Shannon!\n" +
        "\n", printOut.toString());
  }
}
