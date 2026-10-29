package com.java8.InterviewQuestions;
import java.util.*;
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


    }


}
