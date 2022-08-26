package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TeamTest {

    private static final String PLAYER_ONE = "Sally";
    private static final String PLAYER_TWO = "Roger";

    @Test
    public void teamAttributes() {

        Team team = new Team(PLAYER_ONE, PLAYER_TWO);

        assertEquals(PLAYER_ONE, team.getPlayer1());
        assertEquals(PLAYER_TWO, team.getPlayer2());
        assertEquals(List.of(), team.getScores());
    }

    @Test
    public void sumTotalScore() {

        Team team = new Team(PLAYER_ONE, PLAYER_TWO);
        team.getScores().addAll(List.of(2, 9, 9, 3, 11, 2));

        assertEquals(36, team.sumTotalScore());
    }

    @Test
    public void sumTotalScore_negativeInputs() {

        Team team = new Team(PLAYER_ONE, PLAYER_TWO);
        team.getScores().addAll(List.of(-2, -3, 5));

        assertEquals(5, team.sumTotalScore());
    }

    @Test
    public void sumTotalScore_emptyList() {

        Team team = new Team(PLAYER_ONE, PLAYER_TWO);
        assertEquals(0, team.sumTotalScore());
    }
}
