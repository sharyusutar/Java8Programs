package com.java8.Streams.TerminalOperations.reduce;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DisbursementTotalExample {
    public static void main(String[] args) {
        // Sample data: valid objects, a null object, and a null amount.
        List<Disbursement> disbursements = Arrays.asList(
                new Disbursement(new BigDecimal("10000.00")),
                null,
                new Disbursement(null),
                new Disbursement(new BigDecimal("5000.00"))
        );

        BigDecimal total = calculateTotal(disbursements);
        System.out.println("Total disbursed amount: " + total);

        // An empty list has no amounts to add, so the result is zero.
        BigDecimal emptyTotal = calculateTotal(Collections.emptyList());
        System.out.println("Empty list total: " + emptyTotal);

        // A list containing only missing records/amounts also totals zero.
        BigDecimal missingTotal = calculateTotal(Arrays.asList(
                null, new Disbursement(null)
        ));
        System.out.println("Missing amounts total: " + missingTotal);

        // Verify results without requiring a test framework or -ea flag.
        checkTotal(total, new BigDecimal("15000.00"));
        checkTotal(emptyTotal, BigDecimal.ZERO);
        checkTotal(missingTotal, BigDecimal.ZERO);
        System.out.println("All checks passed.");
    }

    static BigDecimal calculateTotal(List<Disbursement> disbursements) {
        // The list itself must exist; null elements inside it are allowed.
        Objects.requireNonNull(disbursements, "disbursements must not be null");

        return disbursements.stream()             // Process the list's objects.
                .filter(Objects::nonNull)             // Ignore null objects.
                .map(Disbursement::getAmount)         // Extract each object's amount.
                .filter(Objects::nonNull)             // Ignore null amounts.
                .reduce(BigDecimal.ZERO, BigDecimal::add); // Add amounts, starting at 0.
    }

    private static void checkTotal(BigDecimal actual, BigDecimal expected) {
        // compareTo compares numeric value regardless of decimal scale.
        if (actual.compareTo(expected) != 0) {
            throw new AssertionError("Expected " + expected + ", got " + actual);
        }
    }

    static class Disbursement {
        private final BigDecimal amount;

        Disbursement(BigDecimal amount) {
            this.amount = amount;
        }

        BigDecimal getAmount() {
            return amount;
        }
    }
}
