package com.java8.StringsExamples;

public class LengthWithoutLengthMethod {

    public static void main(String[] args) {

        String str = "Java";

        long count =
                str.chars().count();

        System.out.println(count);
    }
}