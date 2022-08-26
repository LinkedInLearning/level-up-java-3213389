package com.linkedin.javacodechallenges;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JokeResponse {
  private String id;
  private String joke;
  private int status;
}