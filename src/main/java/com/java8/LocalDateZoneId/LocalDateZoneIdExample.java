package com.java8.LocalDateZoneId;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class LocalDateZoneIdExample {
    public static void main(String[] args) {
        demonstrateDates();
        System.out.println("All checks passed.");
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

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}

