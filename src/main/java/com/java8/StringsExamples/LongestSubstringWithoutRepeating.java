package com.java8.StringsExamples;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {

        String str = "abcabcbb";

        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < str.length(); right++) {

            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left++));
            }

            set.add(str.charAt(right));

            maxLength =
                    Math.max(maxLength,
                            right - left + 1);
        }

        System.out.println(maxLength);
    }
}