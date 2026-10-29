package com.java8.interviewquestions;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayInterview {

    static void main() {
        //1. Maximum and minimum
        int[] arr = {5, 2, 9};
       ArrayList<Integer> arrayList= Arrays.stream(arr)
                .sorted().boxed().collect(Collectors.toCollection(ArrayList::new));

        OptionalInt min=Arrays.stream(arr).min();
        OptionalInt max=Arrays.stream(arr).max();
    }


}
