package com.java8.ComputeOnMap.computeIfAbsent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyProgramPractice {
    static void main() {
        demonstrateComputeIfAbsent();
        System.out.println("All checks passed.");
    }

    static void demonstrateComputeIfAbsent() {
        System.out.println("1. computeIfAbsent - group billing records");
        Map<String,List<String>> records=new HashMap<>();


        List<String> firstList=records.computeIfAbsent("ARREARS",key->{
            System.out.println("Creating list for " + key);
            return new ArrayList<>();
        });

        System.out.println("firstList"+firstList);
        firstList.add("ARREAR-001");
        System.out.println("Added to firstList"+firstList);

        // Existing non-null value: reuse it; this lambda is not executed.
        System.out.println("Checking secondList");
         List<String> secondList=records.computeIfAbsent("ARREARS",key->{
             throw new AssertionError("Existing list should have been reused");
         });
        secondList.add("ARREAR-002");

        System.out.println("secondList"+secondList);
        System.out.println("Checking PAYMENTS");
       // A key mapped to null also causes the value to be computed.
        records.put("PAYMENTS",null);
        records.computeIfAbsent("PAYMENTS",key -> new ArrayList<>());
        check(records.get("PAYMENTS").size()==1, "Value must be added");
        records.computeIfAbsent("PAYMENTS",key -> new ArrayList<>()).add("PAYMENT-001");

        System.out.println("PAYMENTS: " + records.get("PAYMENTS"));
        check(records.get("PAYMENTS").size()==1, "Value must be added");

    }

    private static void check(Boolean condition, String message){
        if(!condition){
            throw new AssertionError(message);
        }
    }
}
