package com.java8.Optional;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        Optional<String> user1 = Optional.of("John");
        Optional<String> user2 = Optional.empty();

        System.out.println(user1.orElse("Default"));
        System.out.println(user2.orElse("Default"));

         System.out.println(user1.orElseGet(() -> generateUser()));
        System.out.println(user2.orElseGet(() -> generateUser()));
    }

    static String generateUser() {
        System.out.println("Generating User...");
        return "Generated User";
    }
}
