package com.java8.FunctionalInterfaces.strings;

public class Permutations {

    public static void main(String[] args) {

        String str = "ABC";

        permute(str, "");
    }

    private static void permute(String str, String result) {

        if (str.isEmpty()) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char current = str.charAt(i);

            String remaining =
                    str.substring(0, i) +
                            str.substring(i + 1);

            permute(remaining, result + current);
        }
    }
}