package com.java8.InterviewQuestions;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;


public class TestOld {
    static void main() {
        List<Integer> list= Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
         /*
         Given a string find max occurrence of character and return array with starting index and count
                Input
                String s1="aabbbcccc"
                Output [5,4]
          */

        String str="aabbbccccqqqqq";
        Map<Character,Integer> map=new HashMap<>();
        Set<Character> hashSet=new HashSet<>();
        Set<Character> finalHashSet = hashSet;
        /*
        hashSet = str.chars()
                .map(c-> (char)c
                 )
                .map(c->{
                    int count=0;
                    if(finalHashSet.add((char) c)){
                        count++;
                    }

                }).collect()
                */


        Map<Character, Long> map2=
                 str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                ;
        System.out.println(map2);
        AtomicReference<Character> result = new AtomicReference<>();
        AtomicLong rcnt= new AtomicLong();
         map2.forEach((c,i)->{
            if(rcnt.get()<i){
                rcnt.set(i);
                result.set(c);

            }
         });
        System.out.println(result.get());
         int index= str.indexOf(result.get());
        System.out.println(""+index +" "+map2.get(result.get()));

    }
}
