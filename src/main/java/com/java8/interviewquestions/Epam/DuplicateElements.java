package com.java8.interviewquestions.Epam;

import java.util.*;

public class DuplicateElements {

    public static List<Integer> findDuplicateElements(int[] list){
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicateEelement = new ArrayList<>();
        for(int i = 0; i < list.length; i++){
            if(!set.add(list[i])){
                duplicateEelement.add(list[i]);
            }
        }
        //        return duplicateEelement;
        // Java 8
        Set<Integer> set2 = new HashSet<>();

         return Arrays.stream(list).filter(e->set2.add(e)).boxed().toList();

    }
    static void main() {
        int[] arr = {1,2,3,2,4,5,1};
        System.out.println(findDuplicateElements(arr));
    }
}
