package com.java8.StringsExamples;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {

    public static void main(String[] args) {

        String str = "Java";

        String reversed =
                IntStream.range(0, str.length())
                        .mapToObj(i -> String.valueOf(
                                str.charAt(str.length() - 1 - i)))
                        .collect(Collectors.joining());

        System.out.println(reversed);
    }
}
