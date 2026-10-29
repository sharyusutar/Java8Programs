package com.java8.StringsExamples;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachWord {

    public static void main(String[] args) {

        String str =
                "Java is awesome";

        String result =
                Arrays.stream(str.split(" "))
                        .map(word ->
                                new StringBuilder(word)
                                        .reverse()
                                        .toString())
                        .collect(
                                Collectors.joining(" "));

        System.out.println(result);
    }
}