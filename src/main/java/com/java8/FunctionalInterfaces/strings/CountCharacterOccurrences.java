package com.java8.FunctionalInterfaces.strings;

public class CountCharacterOccurrences {

    public static void main(String[] args) {

        String str = "banana";

        long count =
                str.chars()
                        .filter(ch -> ch == 'a')
                        .count();

        System.out.println(count);
    }
}