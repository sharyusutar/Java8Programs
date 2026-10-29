package com.java8.StringsExamples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {

    public static void main(String[] args) {

        String str = "I Love Java";

        List<String> words =
                Arrays.asList(str.split(" "));

        Collections.reverse(words);

        System.out.println(
                String.join(" ", words));
    }
}