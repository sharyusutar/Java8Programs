package com.java8.InterviewQuestions;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayInterview {

    static void main() {
        //1. Maximum and minimum
        int[] arr = {5, 2, 9};
       ArrayList<Integer> arrayList= Arrays.stream(arr)
                .sorted().boxed().collect(Collectors.toCollection(ArrayList::new));

        OptionalInt min=Arrays.stream(arr).min();
        OptionalInt max=Arrays.stream(arr).max();

        //2. Sum and average


        //8. Find duplicate values
         int[] arr8 = {1, 2, 2,2, 3, 3,4};
         Map<Integer,Long> map= Arrays.stream(arr8).boxed().collect(
                 Collectors.groupingBy(Function.identity(), Collectors.counting())
         );

        // Java 8 Stream to find the top 3 highest salaries
        List<Integer> salaries = Arrays.asList(50000, 120000, 75000, 95000, 110000, 60000);
        List<Integer> top3Salaries = salaries.stream()
                .sorted(Comparator.reverseOrder()) // Sort in descending order
                .limit(3)                          // Take only the first 3 elements
                .collect(Collectors.toList());    // Collect into a new list

        // Output: [120000, 110000, 95000]
        System.out.println("Top 3 Salaries: " + top3Salaries);
        System.out.println(map);


    }


}
