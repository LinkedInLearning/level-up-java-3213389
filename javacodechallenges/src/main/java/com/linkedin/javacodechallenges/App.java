package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
        public static List<String> findStudentsWithIncompleteVolunteerEvents(
                        List<String> students,
                        Map<String, List<String>> attendeesMapping) {
                Map<String, Integer> studentsEventCount = students.stream()
                                .collect(Collectors.toMap(s -> s, n -> 0));
                attendeesMapping.values()
                                .forEach(list -> list.stream()
                                                .filter(student -> studentsEventCount.containsKey(student))
                                                .forEach(filteredStudent -> studentsEventCount.put(filteredStudent,
                                                                studentsEventCount.get(filteredStudent) + 1)));
                return studentsEventCount.entrySet().stream()
                                .filter(map -> map.getValue() < 2)
                                .map(studentsWithIncompleteVolunteerEventsMap -> studentsWithIncompleteVolunteerEventsMap
                                                .getKey())
                                .collect(Collectors.toList());
        }

        public static void main(String[] args) {
                List<String> students = List.of("Sally", "Polly", "Molly",
                                "Tony", "Harry");

                Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                                "Midnight Breakfast", List.of("Polly", "Molly"));

                System.out.println(findStudentsWithIncompleteVolunteerEvents(
                                students, attendeesMapping));
        }

}
