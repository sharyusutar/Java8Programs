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

/** Standalone Java 8 examples. No external libraries or services required. */
public class BankingJava8Demo {
    public static void main(String[] args) {
        demonstrateComputeIfAbsent();
        demonstrateDates();
        demonstrateParallelStream();
        System.out.println("\nAll checks passed.");
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

    private static void demonstrateDates() {
        System.out.println("\n2. LocalDate and ZoneId - determine a calendar date");
        Instant timestamp = Instant.parse("2026-01-15T20:00:00Z");
        Date legacyDate = Date.from(timestamp);
        ZoneId utc = ZoneId.of("UTC");
        ZoneId india = ZoneId.of("Asia/Kolkata");

        // Date -> Instant -> date/time in a selected zone -> calendar date.
        LocalDate utcDate = legacyDate.toInstant().atZone(utc).toLocalDate();
        LocalDate indiaDate = legacyDate.toInstant().atZone(india).toLocalDate();
        System.out.println("Timestamp: " + timestamp);
        System.out.println("UTC date: " + utcDate);
        System.out.println("India date: " + indiaDate);
        check(utcDate.equals(LocalDate.of(2026, 1, 15)), "Unexpected UTC date");
        check(indiaDate.equals(LocalDate.of(2026, 1, 16)), "Unexpected India date");

        // This matches the project's system-default-zone conversion pattern.
        ZoneId systemZone = ZoneId.systemDefault();
        LocalDate systemDate = resolveDate(legacyDate, systemZone);
        System.out.println("System zone: " + systemZone);
        System.out.println("Date in system zone: " + systemDate);
        System.out.println("Missing date fallback: " + resolveDate(null, systemZone));
        // The last three outputs depend on the machine and the day of execution.
        // A bank's business date may differ from the current calendar date.
    }

    private static LocalDate resolveDate(Date date, ZoneId zone) {
        Objects.requireNonNull(zone, "zone must not be null");
        if (date == null) {
            return LocalDate.now(zone);
        }
        return date.toInstant().atZone(zone).toLocalDate();
    }

    private static void demonstrateParallelStream() {
        System.out.println("\n3. parallelStream - total component amounts due");
        List<PaymentComponent> components = Arrays.asList(
                new PaymentComponent("PRINCIPAL", new BigDecimal("1000.00")),
                new PaymentComponent("INTEREST", new BigDecimal("2000.00")),
                new PaymentComponent("FEES", new BigDecimal("3000.00")),
                new PaymentComponent("OTHER", new BigDecimal("4000.00"))
        );

        BigDecimal sequential = components.stream()
                .map(PaymentComponent::getAmountDue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal parallel = components.parallelStream()
                .map(PaymentComponent::getAmountDue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Sequential total: " + sequential);
        System.out.println("Parallel total: " + parallel);
        check(parallel.compareTo(new BigDecimal("10000.00")) == 0,
                "Expected total of 10000.00");
        check(parallel.compareTo(sequential) == 0, "Totals must match");

        // Optional defensive variant: ignore null records and amounts.
        // In production, invalid data may need rejection rather than skipping.
        List<PaymentComponent> withMissingData = Arrays.asList(
                new PaymentComponent("PRINCIPAL", new BigDecimal("1000.00")),
                null,
                new PaymentComponent("FEES", null)
        );
        BigDecimal validAmountTotal = withMissingData.parallelStream()
                .filter(Objects::nonNull)
                .map(PaymentComponent::getAmountDue)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total after ignoring missing data: " + validAmountTotal);
        check(validAmountTotal.compareTo(new BigDecimal("1000.00")) == 0,
                "Unexpected filtered total");
        // No shared mutable accumulator. BigDecimal.add returns a new value.
        // Small lists like this usually do not benefit from parallel processing.
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static class PaymentComponent {
        private final String code;
        private final BigDecimal amountDue;
        PaymentComponent(String code, BigDecimal amountDue) {
            this.code = code;
            this.amountDue = amountDue;
        }
        public String getCode() { return code; }
        public BigDecimal getAmountDue() { return amountDue; }
    }
}
