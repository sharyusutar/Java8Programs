package com.java8.Streams.streamObjectsIntoMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamObjectsIntoMap {

    static class ComponentPreferenceDetailsModel {
        private final String compCode;
        private final String description;

        ComponentPreferenceDetailsModel(String compCode, String description) {
            this.compCode = compCode;
            this.description = description;
        }

        public String getCompCode() {
            return compCode;
        }

        @Override
        public String toString() {
            return compCode + ": " + description;
        }
    }

    public static void main(String[] args) {
        List<ComponentPreferenceDetailsModel> preferences = Arrays.asList(
                new ComponentPreferenceDetailsModel("SERVICE", "First service preference"),
                new ComponentPreferenceDetailsModel("TAX", "Tax preference"),
                new ComponentPreferenceDetailsModel("SERVICE", "Duplicate service preference")
        );

        Map<String, ComponentPreferenceDetailsModel> preferencesByCode =
                preferences.stream()
                        .collect(Collectors.toMap(
                                ComponentPreferenceDetailsModel::getCompCode,
                                Function.identity(),
                                (first, second) -> first
                        ));

        System.out.println(preferencesByCode.get("SERVICE"));
        System.out.println(preferencesByCode.get("TAX"));
        System.out.println("Map size: " + preferencesByCode.size());
    }
}
