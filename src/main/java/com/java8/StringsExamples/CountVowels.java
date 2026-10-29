package com.java8.StringsExamples;

public class CountVowels {

    public static void main(String[] args) {

        String str = "Java Programming";

        long count =
                str.toLowerCase()
                        .chars()
                        .filter(c ->
                                "aeiou".indexOf(c) != -1)
                        .count();

        System.out.println(count);
    }
}