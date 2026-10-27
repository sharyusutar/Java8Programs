package com.java8.FunctionalInterfaces.PredicateFunctionConsumerSupplier;

import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class PredicateFunctionConsumerSupplier {

    public static void main(String[] args) {

        /**
         *
         *  Predicate : A Predicate takes one input and returns a boolean value.
         *
         *  Syntax Predicate predicate = t -> condition;
         *
         *  @FunctionalInterface
         *  public interface Predicate<T> {.......}
         *
         *  Type parameters:
         *  <T> – the type of the input to the predicate
         *
         *  Represents a predicate (boolean-valued function) of one argument.
         *
         *  This is a functional interface
         *  whose functional method is test(Object)
         *
         *  Predicate takes one input and returns a boolean value.
         */
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isEven2 = num -> num % 3 == 0;
        Predicate<Integer> isEven3 = isEven.and(isEven2);


        System.out.println("Is 20 even? " + isEven.test(20));
        System.out.println("isEven.and(isEven2)? " + isEven.and(isEven2));
        System.out.println("Is 20 even? " + isEven3.test(20));

        /**
         * Function : A Function takes one input and returns one output.
         *
         * Syntax Function<T, R> function = input -> output;
         *
         * @FunctionalInterface
         * public interface Function<T, R>
         *
         * Type parameters:
         *             <T> – the type of the input to the function
         *             <R> – the type of the result of the function
         *
         * Represents a function that accepts one argument and produces a result.
         * This is a functional interface whose functional method is apply(Object).
         *
         */
        Function<String, Integer> findLength = str -> str.length();
        System.out.println("Length of Java: " + findLength.apply("Java"));


        /**
         *
         * Consumer : A Consumer takes one input and returns nothing (void).
         *
         * It is generally used for printing, saving data, logging, etc.
         *
         * Syntax Consumer consumer = t -> operation;
         *
         * @FunctionalInterface
         * public interface Consumer<T>
         *
         * Type parameters:
         *          <T> – the type of the input to the operation
         *
         * A Consumer takes one input and returns nothing (void).
         * It is generally used for printing, saving data, logging, etc.
         *
         * Represents an operation that accepts a single input argument and returns no result. Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
         * This is a functional interface whose functional method is accept(Object).
         *
         */
        Consumer<String> greet =
                name -> System.out.println("Welcome " + name);
        greet.accept("Alice");


        /**
         * Supplier
         * A Supplier takes no input and returns a value.
         *
         * @FunctionalInterface
         * public interface Supplier<T>
         *
         * Type parameters:
         * <T> – the type of results supplied by this supplier
         *
         * Represents a supplier of results.
         * There is no requirement that a new or distinct result be returned each time the supplier is invoked.
         * This is a functional interface whose functional method is get().
         */
        Supplier<Integer> randomNum =
                () -> new Random().nextInt(100);
        System.out.println("Random Number: " + randomNum.get());
    }
}