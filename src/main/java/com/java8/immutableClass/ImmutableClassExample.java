package com.java8.immutableClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableClassExample {

    private final String id;
    private final String name;
    private final List<String> skills;

    public ImmutableClassExample(String id, String name, List<String> skills) {
        this.id = id;
        this.name = name;
        // Defensive copy prevents changes through the original list.
        this.skills = Collections.unmodifiableList(new ArrayList<>(skills));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        // Safe because the list is unmodifiable and String is immutable.
        return skills;
    }
    static void main() {
        List<String> skills = new ArrayList<>(
                Arrays.asList("Java", "Spring Boot")
        );

        ImmutableClassExample immutableClassExample = new ImmutableClassExample("101", "Sharyu", skills);

        skills.add("SQL");

        System.out.println(immutableClassExample.getSkills());
    }
}
