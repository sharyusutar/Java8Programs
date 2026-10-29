package com.java8.InterviewQuestions.Epam;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOccurrencesCharacters {

    static void main() {
        String str="hello";

        Map<Character, Long> map = null;

        map =str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

         str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }
}
