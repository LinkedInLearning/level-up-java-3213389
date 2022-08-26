package com.linkedin.javacodechallenges;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;

import com.google.gson.Gson;

public class App {

    public static Optional<String> parseJoke(String responseBody) {
        try {
            JokeResponse jokeResponse = new Gson().fromJson(responseBody,
                    JokeResponse.class);
            String joke = jokeResponse.getJoke();
            if (joke != null) {
                return Optional.of(jokeResponse.getJoke());
            }
            return Optional.empty();
        } catch (Exception e) {
            System.out.println("Must be out of jokes for now.");
            return Optional.empty();
        }
    }

    public static void main(String[] args) throws IOException,
            InterruptedException {
        // Create a client
        var client = HttpClient.newHttpClient();

        // Create a request
        var request = HttpRequest.newBuilder(
                URI.create("https://icanhazdadjoke.com/"))
                .header("accept", "application/json")
                .build();

        // Use the client to send the request
        var response = client.send(request, BodyHandlers.ofString());

        Optional<String> jokeOpt = parseJoke(response.body());

        jokeOpt.ifPresent(System.out::println);
    }
}