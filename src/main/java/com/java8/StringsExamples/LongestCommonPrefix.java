package com.java8.StringsExamples;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] arr = {
                "flower",
                "flow",
                "flight"
        };

        String result =
                Arrays.stream(arr)
                        .reduce((a, b) -> {

                            int i = 0;

                            while (i < Math.min(a.length(),
                                    b.length())
                                    && a.charAt(i) ==
                                    b.charAt(i)) {
                                i++;
                            }

                            return a.substring(0, i);

                        }).orElse("");

        System.out.println(result);
    }
}