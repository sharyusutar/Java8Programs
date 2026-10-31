package com.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Test {
    static void main() {
        //GeeksForGeeks

        String str="GeeksForGeeks";

        //Substring

        // No duplicate
        //largest

        //Reequired output eksForG
        Set<Character> set = new LinkedHashSet<>();
        str.chars().mapToObj(c -> {
                    Character ch = (char) c;
                    set.add(ch);
                    return set;
                }
            ).collect(Collectors.toSet());

               //.map(c->c.toString()).collect(Collectors.joining());

        //System.out.println(set);
        final String[] res = {""};
        set.stream().iterator().forEachRemaining(c -> {
            //System.out.println(String.valueOf(c));
            res[0] =  res[0].concat(String.valueOf(c));

        });

        System.out.println(Arrays.stream(res).collect(Collectors.joining()));

    }
}
