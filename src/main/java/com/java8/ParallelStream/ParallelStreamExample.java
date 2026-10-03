package com.java8.ParallelStream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/** Standalone Java 8 learning example. No external dependencies. */
public class ParallelStreamExample {
    public static void main(String[] args) {
        demonstrateParallelStream();
        System.out.println("All checks passed.");
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

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}
