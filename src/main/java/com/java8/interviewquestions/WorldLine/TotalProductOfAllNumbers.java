package com.java8.interviewquestions.WorldLine;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class TotalProductOfAllNumbers {

    static void main() {

        /*
         * [1, 2, 3, 4]   <-- input
         * [24, 12, 8, 6]  <-- output  (Product of all except current 24 = 2*3*4 , 12 = 1*3*4 etc.)
         */
        int[] input = {1, 2, 3, 4};
        System.out.println(Arrays.toString(input));


        int[] output= IntStream.range(0,input.length)
                .map(i->{
                    int leftProduct = IntStream.range(0,i)
                            .map(left->input[left])
                            .reduce(1, (a,b)->a*b);


                    int rightProduct = IntStream.range(i+1,input.length)
                            .map(right->input[right])
                            .reduce(1, (a,b)->a*b);

                    return leftProduct*rightProduct;

                }).toArray();

         System.out.println(Arrays.toString(output));
    }
}
