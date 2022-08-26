package com.linkedin.javacodechallenges;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketUtils {

    public static List<TicketHolder> importTicketHoldersFromCSV(
            String filename) throws IOException, CsvValidationException {

        List<TicketHolder> ticketHolderList = new ArrayList<>();

        if (!filename.contains(".csv")) {
            System.out.println("This is not a CSV file: " + filename);
            return ticketHolderList;
        }

        FileInputStream fis = new FileInputStream(filename);
        InputStreamReader reader = new InputStreamReader(fis,
                StandardCharsets.UTF_8);
        CSVReader csvReader = new CSVReader(reader);
        csvReader.readNext();

        String[] row;
        while ((row = csvReader.readNext()) != null) {
            ticketHolderList.add(new TicketHolder(row[0].trim(),
                    Integer.parseInt(row[1])));
        }

        csvReader.close();

        return ticketHolderList;
    }

    public static Optional<TicketHolder> findTicketHolder(
            String name, List<TicketHolder> ticketHoldersList) {

        return ticketHoldersList.stream()
                .filter(ticketHolder -> StringUtils.equalsIgnoreCase(name,
                        ticketHolder.getName()))
                .findFirst();
    }

    public static boolean processTickets(
            TicketHolder ticketHolder, int numberInParty,
            List<TicketHolder> ticketHolderList) {

        int leftover = ticketHolder.getQuantity() - numberInParty;

        if (leftover < 0) {
            System.out.println("You don't have enough tickets for " +
                    "your whole party. You only have "+
                    ticketHolder.getQuantity());
            return false;
        }

        if (leftover != 0) {
            System.out.println("I see you still have more coming. " +
                    "I'm keeping your name on the list for them!");
            ticketHolder.setQuantity(leftover);
            return true;
        }

        ticketHolderList.remove(ticketHolder);
        return true;
    }
}