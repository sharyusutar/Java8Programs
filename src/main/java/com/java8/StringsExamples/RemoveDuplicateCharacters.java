package com.java8.StringsExamples;

import java.util.stream.Collectors;

public class RemoveDuplicateCharacters {

    public static void main(String[] args) {

        String str = "programming";

        String result =
                str.chars()
                        .distinct()
                        .mapToObj(c -> String.valueOf((char)c))
                        .collect(Collectors.joining());

        System.out.println(result);
    }
}