package com.java8.StringsExamples;

import java.util.stream.Collectors;

public class SortCharacters {

    public static void main(String[] args) {

        String str = "dcba";

        String sorted =
                str.chars()
                        .sorted()
                        .mapToObj(c -> String.valueOf((char)c))
                        .collect(Collectors.joining());

        System.out.println(sorted);
    }
}