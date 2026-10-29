package com.java8.FunctionalInterfaces.strings;

import java.util.stream.Collectors;

/**
 * What is Anagram?
 *
 * Two strings are anagrams if they contain the same characters with the same frequency, but possibly in a different order
 */
public class AnagramCheck {

    public static void main(String[] args) {

        String s1 = "listen";
        String s2 = "silent";

        String sorted1 =
                s1.chars()
                        .sorted()
                        .mapToObj(c -> String.valueOf((char)c))
                        .collect(Collectors.joining());

        String sorted2 =
                s2.chars()
                        .sorted()
                        .mapToObj(c -> String.valueOf((char)c))
                        .collect(Collectors.joining());

        System.out.println(sorted1.equals(sorted2));
    }
}