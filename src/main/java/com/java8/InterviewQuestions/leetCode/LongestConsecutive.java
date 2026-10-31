package com.java8.InterviewQuestions.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutive {

    static void main() {
        int[] arr = {1, 144, 677, 2, 3,788, 4, 5};
        System.out.println( longestConsecutive(arr));
    }

    static int longestConsecutive(int[] nums) {
        Set<Integer> set =Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int res = set.stream().filter(x-> {
            System.out.println("--------------------------------------------------------------");
            System.out.println("Checking for element  = "+x);
            return !set.contains(x-1);
        }).mapToInt(num->{
            System.out.println("num = "+num);

            Integer count=1;
            while(set.contains(num+count)){
                count++;
            }
             System.out.println("return count = "+count);
            return count;
        }).max().orElse(0);

        return res;
    }
}
