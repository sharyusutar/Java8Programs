package com.java8.interviewquestions.WorldLine;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class TotalProductOfAllNumbers {

    static void main() {

        int[] input = {1, 2, 3, 4};
        //expected output TotalProductOfAllNumbers except currrent

        int[] output= IntStream.range(0,input.length)
                .map(i->{
                    int leftProduct = IntStream.range(0,i)
                            .map(j->input[j])
                            .reduce(1, (a,b)->a*b);


                    int rightProduct = IntStream.range(i+1,input.length)
                            .map(j->input[j])
                            .reduce(1, (a,b)->a*b);
                    return leftProduct*rightProduct;
                }).toArray();

         System.out.println(Arrays.toString(output));
    }
}
