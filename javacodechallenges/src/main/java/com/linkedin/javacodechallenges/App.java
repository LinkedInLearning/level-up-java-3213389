package com.linkedin.javacodechallenges;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.opencsv.exceptions.CsvValidationException;

public class App {
    public static void main(String[] args) {

        List<TicketHolder> ticketHoldersList = new ArrayList<>();

        try {
            ticketHoldersList
                    .addAll(TicketUtils
                            .importTicketHoldersFromCSV("ticketholders.csv"));
        } catch (IOException | CsvValidationException e) {
            System.out.println(e);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the full name under the ticket?");
        String name = scanner.nextLine();

        Optional<TicketHolder> ticketHolderOpt = TicketUtils
                .findTicketHolder(name, ticketHoldersList);

        if (ticketHolderOpt.isEmpty()) {
            System.out.println("I can't let you in because " +
                    "I can't find your name");
            scanner.close();
            return;
        }

        System.out.println("How many are in your party?");
        int numberInParty = scanner.nextInt();
        scanner.close();

        TicketHolder ticketHolder = ticketHolderOpt.get();

        if (!TicketUtils.processTickets(ticketHolder,
                numberInParty, ticketHoldersList)) {
            System.out.println("I can't let your party in " +
                    "because you didn't buy enough tickets.");
            return;
        }

        System.out.println("Enjoy the show!");
    }
}
