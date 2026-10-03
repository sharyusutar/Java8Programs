package com.java8.comparator.helper;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ComparatorHelpersDemo {

    public static void main(String[] args) {
        List<SlpTbEventLogModel> eventsToRevList = new ArrayList<>(Arrays.asList(
                new SlpTbEventLogModel(102, "Apply discount"),
                new SlpTbEventLogModel(105, "Collect payment"),
                new SlpTbEventLogModel(103, "Generate invoice"),
                new SlpTbEventLogModel(105, "Duplicate payment event")
        ));

        System.out.println("Original events:");
        eventsToRevList.forEach(System.out::println);

        // comparing() uses ascending order; reversed() changes it to descending.
        // The method reference is equivalent to: event -> event.getEventSeqNo()
        // sort() changes the existing list.
        eventsToRevList.sort(
                Comparator.comparing(SlpTbEventLogModel::getEventSeqNo)
                        .reversed()
        );

        System.out.println("\nDescending sequence order:");
        eventsToRevList.forEach(System.out::println);

        // Function extracts the key: an event's sequence number.
        Function<SlpTbEventLogModel, Integer> sequenceKey =
                SlpTbEventLogModel::getEventSeqNo;

        // Predicate answers: is this the first time we have seen this key?
        Predicate<SlpTbEventLogModel> firstOccurrence = distinctByKey(sequenceKey);

        // This example deliberately uses a sequential stream.
        List<SlpTbEventLogModel> uniqueEvents = eventsToRevList.stream()
                .filter(firstOccurrence)
                .collect(Collectors.toList());

        System.out.println("\nAfter filtering duplicate sequence numbers:");
        uniqueEvents.forEach(System.out::println);

        System.out.println("\nSimulated reversal workflow (prints only):");
        uniqueEvents.forEach(event -> System.out.println("Reverse: " + event));
    }

    // Illustrative implementation, not the original billing service's source.
    // T is the item type. The Function accepts T (or a supertype) and returns
    // a key of any type. The returned Predicate accepts T and returns boolean.
    public static <T> Predicate<T> distinctByKey(
            Function<? super T, ?> keyExtractor) {
        Set<Object> seenKeys = new HashSet<>();

        // Set.add() returns true for a new key and false for a duplicate.
        // Each call to distinctByKey() creates a fresh set.
        // This stateful predicate is for sequential use only; do not reuse it
        // for a separate filtering operation or use it in a parallel stream.
        return item -> seenKeys.add(keyExtractor.apply(item));
    }

    static class SlpTbEventLogModel {
        private final Integer eventSeqNo;
        private final String description;

        SlpTbEventLogModel(Integer eventSeqNo, String description) {
            this.eventSeqNo = eventSeqNo;
            this.description = description;
        }

        public Integer getEventSeqNo() {
            return eventSeqNo;
        }

        @Override
        public String toString() {
            return eventSeqNo + " - " + description;
        }
    }
}