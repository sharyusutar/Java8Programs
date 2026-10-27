package com.java8.interviewquestions.EY;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class SecondLargest {

    public static Integer secondLargest(Integer[] arr){
        return  Arrays.stream(arr).distinct().sorted(Collections.reverseOrder())
                  .skip(1).findFirst().orElse(null);
    }
    static void main() {
        Integer[] arr = {10, 20, 4, 45, 99, 99};
         System.out.println(secondLargest(arr));

    }
}
