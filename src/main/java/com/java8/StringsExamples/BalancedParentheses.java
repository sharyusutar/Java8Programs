package com.java8.StringsExamples;

import java.util.Stack;

/**
 * A string is balanced if every opening bracket has a matching closing bracket in the correct order.
 */
public class BalancedParentheses {

    public static void main(String[] args) {

        String str = "({[]})";

        Stack<Character> stack = new Stack<>();

        boolean balanced = true;

        for (char ch : str.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {

                stack.push(ch);

            } else {

                if (stack.isEmpty()) {
                    balanced = false;
                    break;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {

                    balanced = false;
                    break;
                }
            }
        }

        balanced = balanced && stack.isEmpty();

        System.out.println(balanced);
    }
}