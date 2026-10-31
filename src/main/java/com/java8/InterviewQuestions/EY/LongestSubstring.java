package com.java8.InterviewQuestions.EY;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static String findLongestUniqueSubstring(String str) {
        int n = str.length();
        int left = 0, right = 0;
        int maxLen = 0;
        int startIdx = 0;

        Set<Character> set = new HashSet<>();

        while (right < n) {
            char c = str.charAt(right);
            // If duplicate is found, shrink the window from the left
            while (set.contains(c)) {
                set.remove(str.charAt(left));
                left++;
            }
            set.add(c);

            // Update max length and start index
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                startIdx = left;
            }
            right++;
        }

        return str.substring(startIdx, startIdx + maxLen);
    }

    public static void main(String[] args) {
        String str = "GeeksForGeeks";
        String result = findLongestUniqueSubstring(str);
        System.out.println("Required output: " + result);
    }
}