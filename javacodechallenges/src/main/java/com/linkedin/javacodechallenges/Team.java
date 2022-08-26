package com.linkedin.javacodechallenges;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Team {
  private final String player1;
  private final String player2;
  private final List<Integer> scores;

  public Team(String player1, String player2) {
    this.player1 = player1;
    this.player2 = player2;
    scores = new ArrayList<>();
  }

  public int sumTotalScore() {
    return scores.stream().filter(score -> score > 0)
        .reduce(Integer::sum).orElse(0);
  }
}