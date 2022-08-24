package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<StoreItem> items = List.of(
                new StoreItem("T-Shirt", 19.99, .4),
                new StoreItem("Dress", 34.99, .75),
                new StoreItem("Record Player", 92.99, .75),
                new StoreItem("Hat", 23.99, .1),
                new StoreItem("Jeans", 54.99, .65));

        Optional<StoreItem> leastExpensiveOpt = StoreItem.findLeastExpensive(items);
        if (leastExpensiveOpt.isPresent()) {
            System.out.println("The least expensive item is " +
                    leastExpensiveOpt.get());
        }
    }
}
