package com.java8.StringsExamples;

public class StringRotation {

    public static void main(String[] args) {

        String s1 = "ABCD";
        String s2 = "CDAB";

        boolean result =
                (s1 + s1).contains(s2);

        System.out.println(result);
    }
}