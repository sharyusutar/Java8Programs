package com.java8.FunctionalInterfaces.strings;
/**
 * Java 8 Streams are not a good fit for this problem because:
 *
 * You need a mutable stack state
 * You need early termination (break)
 * You need to compare current closing bracket with the most recent opening bracket (LIFO)
 *
 * Interviewers generally prefer the classic Stack solution.
 */

import java.util.Stack;
import java.util.stream.IntStream;

public class BalancedParenthesesJava8 {

    public static void main(String[] args) {

        String str = "({[]})";

        Stack<Character> stack = new Stack<>();

        boolean balanced =
                IntStream.range(0, str.length())
                        .allMatch(i -> {

                            char ch = str.charAt(i);

                            if (ch == '(' ||
                                    ch == '{' ||
                                    ch == '[') {

                                stack.push(ch);
                                return true;
                            }

                            if (stack.isEmpty()) {
                                return false;
                            }

                            char top = stack.pop();

                            return (ch == ')' && top == '(') ||
                                    (ch == '}' && top == '{') ||
                                    (ch == ']' && top == '[');
                        });

        balanced = balanced && stack.isEmpty();

        System.out.println(balanced);
    }
}