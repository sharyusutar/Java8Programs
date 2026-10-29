package com.java8.FunctionalInterfaces.strings;

import java.util.Arrays;

public class CountWords {

    public static void main(String[] args) {

        String str =
                "Java is awesome";

        long count =
                Arrays.stream(
                                str.trim()
                                        .split("\\s+"))
                        .count();

        System.out.println(count);
    }
}