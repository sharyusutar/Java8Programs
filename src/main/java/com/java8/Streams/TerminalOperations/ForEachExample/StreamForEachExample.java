package com.java8.Streams.TerminalOperations.ForEachExample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class StreamForEachExample {
    static void main() {


        // 1. Using Stream.forEach with a List and Lambda Expression
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Mango");
        System.out.println("--- 1. List iteration using Lambda ---");

        fruits.stream()
                .forEach(fruit -> System.out.println("Fruit: " + fruit));

        // 2. Using Stream.forEach with a Method Reference (Shorter Syntax)
        System.out.println("\n--- 2. List iteration using Method Reference ---");

        fruits.stream()
                .forEach(System.out::println);

        // 3. Using Stream.forEach after filtering data
        System.out.println("\n--- 3. Iterating after a Filter ---");
        fruits.stream().filter(fruit -> fruit.contains("e")).forEach(System.out::println);

        System.out.println("\n--- 4. Stream iteration using IntStream ---");
        // Traditional For Loop
        /*
        for (int i = 0; i < 8; i++) {
            System.out.println("Index: " + i);
        }

         */

        // 4. Bonus: Using forEach directly on a Map (uses Map.forEach, similar concept)


        Map<Integer, String> employeeMap = new HashMap<>();
        employeeMap.put(101, "Alice");
        employeeMap.put(102, "Bob");
        employeeMap.put(103, "Charlie");

        System.out.println("\n--- 4. Map iteration using forEach ---");
        employeeMap.forEach((i,j)->System.out.println(i));



        // Java 8 ForEach
        System.out.println("\nIntStream.range(0,10).forEach(key-> System.out.println(\"Key: \" + key));\n");

         IntStream.range(0,10).forEach(key-> System.out.println("Key: " + key));
         System.out.println("\nIntStream.range(0,10).forEach(System.out::println);");
         IntStream.range(0,10).forEach(System.out::println);

    }
}
