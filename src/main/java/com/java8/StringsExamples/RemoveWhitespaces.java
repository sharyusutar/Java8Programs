package com.java8.StringsExamples;

import java.util.stream.Collectors;

public class RemoveWhitespaces {

    public static void main(String[] args) {

        String str = "Java Programming";

        String result =
                str.chars()
                        .filter(ch -> !Character.isWhitespace(ch))
                        .mapToObj(ch -> String.valueOf((char) ch))
                        .collect(Collectors.joining());

        System.out.println(result);
    }
}