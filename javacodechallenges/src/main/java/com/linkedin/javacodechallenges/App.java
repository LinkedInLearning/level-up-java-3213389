package com.linkedin.javacodechallenges;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class App {
    public static void redactTextFile(String fileName,
            String[] redactedWordsArray) {
        if (!fileName.contains(".txt")) {
            System.out.println("This is not a text file.");
            return;
        }

        try {
            File originalFile = new File(fileName);
            BufferedReader originalFileReader = new BufferedReader(new FileReader(originalFile));

            File redactedFile = new File("redacted-" +
                    fileName);
            BufferedWriter redactedFileWriter = new BufferedWriter(
                    new FileWriter(redactedFile));

            String currentLine = originalFileReader.readLine();

            while (currentLine != null) {
                for (String redactedWord : redactedWordsArray) {
                    currentLine = StringUtils
                            .replaceIgnoreCase(currentLine,
                                    redactedWord, "REDACTED");
                }

                redactedFileWriter.append(currentLine).append("\n");
                currentLine = originalFileReader.readLine();
            }

            originalFileReader.close();
            redactedFileWriter.close();

        } catch (IOException e) {
            System.out.println("Trouble reading or writing to file"
                    + e);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What file would you like to " +
                "redact information from?");
        String fileName = scanner.nextLine();

        System.out.println("What words would you like to redact? " +
                "Separate each word or phrase with a comma. " +
                "If you phrase includes punctuation, include " +
                "that in your input.");
        String redactedWords = scanner.nextLine();
        String[] redactedWordsList = redactedWords.split(",");

        redactTextFile(fileName, redactedWordsList);

        scanner.close();
    }
}
