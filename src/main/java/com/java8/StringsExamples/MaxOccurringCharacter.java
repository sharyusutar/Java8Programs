package com.java8.StringsExamples;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxOccurringCharacter {

    public static void main(String[] args) {

        String str = "programming";

        Character result =
                str.chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .get()
                        .getKey();

        System.out.println(result);
    }
}