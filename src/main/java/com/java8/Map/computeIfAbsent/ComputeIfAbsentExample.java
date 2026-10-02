package com.java8.Map.computeIfAbsent;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** Standalone Java 8 learning example. No external dependencies. */
public class ComputeIfAbsentExample {
    public static void main(String[] args) {
        demonstrateComputeIfAbsent();
        System.out.println("All checks passed.");
    }

    private static void demonstrateComputeIfAbsent() {
        System.out.println("1. computeIfAbsent - group billing records");
        Map<String, List<String>> records = new HashMap<>();

        // Missing key: create a list, store it, and return that list.
        List<String> firstList = records.computeIfAbsent("ARREARS", key -> {
            System.out.println("Creating list for " + key);
            return new ArrayList<>();
        });
        firstList.add("ARREAR-001");

        // Existing non-null value: reuse it; this lambda is not executed.
        List<String> secondList = records.computeIfAbsent("ARREARS", key -> {
            throw new AssertionError("Existing list should have been reused");
        });
        secondList.add("ARREAR-002");
        System.out.println("ARREARS: " + records.get("ARREARS"));
        System.out.println("Same list reused: " + (firstList == secondList));
        check(firstList == secondList && firstList.size() == 2,
                "Billing records must share the same list");

        // A key mapped to null also causes the value to be computed.
        records.put("PAYMENTS", null);
        records.computeIfAbsent("PAYMENTS", key -> new ArrayList<>())
                .add("PAYMENT-001");
        System.out.println("PAYMENTS: " + records.get("PAYMENTS"));
        check(records.get("PAYMENTS").size() == 1, "Null value must be replaced");
        // HashMap and ArrayList are not thread-safe: this is a sequential example.
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}
