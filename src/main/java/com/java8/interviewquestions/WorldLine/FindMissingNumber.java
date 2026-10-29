package com.java8.interviewquestions.WorldLine;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindMissingNumber {


    static void main(String[] args) {
        int[] arr = {5, 6, 9, 7, 10};

         // 1. Sort Array

        int[] sortedArr=Arrays.stream(arr).sorted().toArray();

        // 2. Look for the index where the consecutive gap is broken

        int missingNumber = IntStream.range(0, sortedArr.length - 1) // 1. Source
                .filter(i -> sortedArr[i + 1] - sortedArr[i] > 1) // 2. Intermediate (Lazy)
                .map(i -> sortedArr[i] + 1)  // 3. Intermediate (Lazy)
                .findFirst()  // 4. Terminal (Executes the stream!)
                .orElse(-1);

        System.out.println(missingNumber);
    }

}
