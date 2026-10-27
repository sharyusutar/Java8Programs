package com.java8.PredicateFunctionConsumerSupplier

In Java 8, Predicate, Function, Consumer, and Supplier are Functional Interfaces available in the java.util.function package. They are commonly used with Lambda Expressions and Streams.

1. Predicate

A Predicate takes one input and returns a boolean value.

Syntax
Predicate<T> predicate = t -> condition;

Example: Check whether a number is even
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {

        Predicate<Integer> isEven = num -> num % 2 == 0;

        System.out.println(isEven.test(10)); // true
        System.out.println(isEven.test(7));  // false
    }
}

Output
true
false

Common Method
test(T t)

2. Function<T, R>

A Function takes one input and returns one output.

Syntax
Function<T, R> function = input -> output;

Example: Convert String to Uppercase
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {

        Function<String, String> toUpperCase =
        str -> str.toUpperCase();

        System.out.println(toUpperCase.apply("java"));
    }
}

Output
JAVA

Common Method
apply(T t)

3. Consumer

A Consumer takes one input and returns nothing (void).

It is generally used for printing, saving data, logging, etc.

Syntax
Consumer<T> consumer = t -> operation;

Example: Print a Name
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        Consumer<String> printName =
        name -> System.out.println("Hello " + name);

        printName.accept("John");
    }
}

Output
Hello John

Common Method
accept(T t)

4. Supplier

A Supplier takes no input and returns a value.

Syntax
Supplier<T> supplier = () -> value;

Example: Generate a Random Number
import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {

        Supplier<Integer> randomNumber =
        () -> new Random().nextInt(100);

        System.out.println(randomNumber.get());
    }
}

Output
57


(Output changes every run.)

Common Method
get()

Combined Runnable Program
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalInterfacesDemo {

    public static void main(String[] args) {

        // Predicate
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 20 even? " + isEven.test(20));

        // Function
        Function<String, Integer> findLength = str -> str.length();
        System.out.println("Length of Java: " + findLength.apply("Java"));

        // Consumer
        Consumer<String> greet =
        name -> System.out.println("Welcome " + name);
        greet.accept("Alice");

        // Supplier
        Supplier<Integer> randomNum =
        () -> new Random().nextInt(100);
        System.out.println("Random Number: " + randomNum.get());
    }
}

Sample Output
Is 20 even? true
Length of Java: 4
Welcome Alice
Random Number: 73

Quick Comparison Table
Interface	Input	Output	MethodPredicate	1	boolean	test()
Function<T,R>	1	1	apply()
Consumer	1	void	accept()
Supplier	0	1	get()
Memory Trick
Predicate → Checks a condition → Returns true/false
Function → Transforms data → Returns a result
Consumer → Consumes data → No return value
Supplier → Supplies data → No input needed

Think of a user registration system:

Predicate -> Is age >= 18?
Function  -> Convert username to uppercase
Consumer  -> Save/Print user details
Supplier  -> Generate User ID


This is the most common real-world usage pattern of these four Java 8 functional interfaces.