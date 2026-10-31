package com.java8.InterviewQuestions.EY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumConsecutiveNumbers {
    static void main() {

        List<Integer> numbers = Arrays.asList(7,2,3,3,5,6,1,3,2);

        // Calculate the sum of every 3 consecutive numbers
        List<Integer> consecutiveSums = IntStream.range(0, numbers.size() - 2)
                .map(i -> numbers.get(i) + numbers.get(i + 1) + numbers.get(i + 2))
                .boxed()
                .collect(Collectors.toList());

        System.out.println(consecutiveSums);

        //Approach2
        // Limit the source range to elements that actually have 2 consecutive neighbors
        ArrayList<Integer> list2 = IntStream.range(0, numbers.size() - 2)
                .mapToObj(i -> {
                    // Use a nested IntStream to sum the 3 consecutive elements
                    int sum = IntStream.range(i, i + 3)
                            .map(numbers::get)
                            .sum();
                    return sum;
                })
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(list2); // Output: [6, 9, 12, 15, 18, 21, 24]



        //Approach3
        List<Integer> consecutiveSums2 = new ArrayList<>();

        IntStream.range(0, numbers.size() - 2)
                .forEach(i -> {
                    System.out.println("i = " + i);
                    int sum = numbers.get(i) + numbers.get(i + 1) + numbers.get(i + 2);
                    consecutiveSums2.add(sum);
                });
        System.out.println(consecutiveSums2);

    }
}
