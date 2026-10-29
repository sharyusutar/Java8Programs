package com.java8.FunctionalInterfaces.strings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PalindromeCheck {

    public static void main(String[] args) {

        String str = "MADAM";

        String reversed =
                IntStream.range(0, str.length())
                        .mapToObj(i ->
                                String.valueOf(
                                        str.charAt(str.length()-1-i)))
                        .collect(Collectors.joining());

        System.out.println(str.equals(reversed));
    }
}