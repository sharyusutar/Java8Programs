package com.java8.StringsExamples;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharacters {

    public static void main(String[] args) {

        String str = "programming";

        Map<Character, Long> result =
                str.chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));

        result.entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .forEach(System.out::println);
    }
}