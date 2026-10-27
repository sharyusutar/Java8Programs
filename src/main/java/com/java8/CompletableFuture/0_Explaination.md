What is CompletableFuture?

CompletableFuture is a class introduced in Java 8 under the java.util.concurrent package.

It is used for asynchronous programming, meaning you can execute tasks in the background without blocking the main thread.

Before Java 8, we used Future:

Future<String> future = executorService.submit(task);


Problem with Future:

Cannot manually complete the result easily.
Cannot chain multiple tasks.
Cannot combine multiple futures.
Limited exception handling.

CompletableFuture solves all these problems.

Why Use CompletableFuture?

Suppose:

Fetch user details from a database.
Fetch user orders.
Generate a report.

With normal code:

User user = getUser();
Orders orders = getOrders();
Report report = createReport(user, orders);


Each step waits for the previous step.

With CompletableFuture, tasks can run concurrently and be chained efficiently.

Creating a CompletableFuture
1. runAsync()

Used when no result is returned.

import java.util.concurrent.CompletableFuture;

public class RunAsyncDemo {
public static void main(String[] args) {

        CompletableFuture<Void> future =
                CompletableFuture.runAsync(() -> {
                    System.out.println("Running in background");
                });

        future.join();
    }
}


Output:

Running in background

2. supplyAsync()

Used when a result is returned.

import java.util.concurrent.CompletableFuture;

public class SupplyAsyncDemo {
public static void main(String[] args) {

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {
                    return "Hello Java";
                });

        System.out.println(future.join());
    }
}


Output:

Hello Java

Chaining Operations
thenApply()

Transforms the result.

import java.util.concurrent.CompletableFuture;

public class ThenApplyDemo {
public static void main(String[] args) {

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> "java")
                                 .thenApply(String::toUpperCase);

        System.out.println(future.join());
    }
}


Output:

JAVA

Flow
"java"
|
thenApply
|
"JAVA"

thenAccept()

Consumes the result without returning anything.

import java.util.concurrent.CompletableFuture;

public class ThenAcceptDemo {
public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> "Java 8")
                         .thenAccept(System.out::println)
                         .join();
    }
}


Output:

Java 8

thenRun()

Execute another task after completion.

import java.util.concurrent.CompletableFuture;

public class ThenRunDemo {

    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> "Task Completed")
                         .thenRun(() ->
                                System.out.println("Next Task"))
                         .join();
    }
}


Output:

Next Task

Combining Multiple Futures
thenCombine()

Combine results from two futures.

import java.util.concurrent.CompletableFuture;

public class ThenCombineDemo {

    public static void main(String[] args) {

        CompletableFuture<String> first =
                CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> second =
                CompletableFuture.supplyAsync(() -> " Java");

        CompletableFuture<String> result =
                first.thenCombine(
                        second,
                        (a, b) -> a + b
                );

        System.out.println(result.join());
    }
}


Output:

Hello Java

Wait for All Tasks
allOf()

Runs multiple tasks and waits for all.

import java.util.concurrent.CompletableFuture;

public class AllOfDemo {

    public static void main(String[] args) {

        CompletableFuture<String> f1 =
                CompletableFuture.supplyAsync(() -> "Task1");

        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(() -> "Task2");

        CompletableFuture<String> f3 =
                CompletableFuture.supplyAsync(() -> "Task3");

        CompletableFuture.allOf(f1, f2, f3).join();

        System.out.println("All tasks completed");
    }
}


Output:

All tasks completed

Wait for Any Task
anyOf()

Returns when the first task completes.

CompletableFuture<Object> result =
CompletableFuture.anyOf(f1, f2, f3);

System.out.println(result.join());

Exception Handling
exceptionally()

Provides fallback value.

import java.util.concurrent.CompletableFuture;

public class ExceptionDemo {

    public static void main(String[] args) {

        CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> {
                    int x = 10 / 0;
                    return x;
                }).exceptionally(ex -> {
                    System.out.println(ex.getMessage());
                    return -1;
                });

        System.out.println(future.join());
    }
}


Output:

/ by zero
-1

Real-World Example

Suppose you're calling two microservices:

import java.util.concurrent.CompletableFuture;

public class EmployeeService {

    public static void main(String[] args) {

        CompletableFuture<String> employee =
                CompletableFuture.supplyAsync(() -> {
                    sleep(2000);
                    return "Employee Details";
                });

        CompletableFuture<String> salary =
                CompletableFuture.supplyAsync(() -> {
                    sleep(1000);
                    return "Salary Details";
                });

        employee.thenCombine(
                salary,
                (e, s) -> e + " + " + s
        ).thenAccept(System.out::println)
         .join();
    }

    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


Without parallel execution:

2 sec + 1 sec = 3 sec


With CompletableFuture:

≈ 2 sec


because both tasks run simultaneously.

Important Interview Methods
Method	PurposerunAsync()	Async task, no return
supplyAsync()	Async task with return value
thenApply()	Transform result
thenAccept()	Consume result
thenRun()	Execute next task
thenCompose()	Chain dependent futures
thenCombine()	Combine two futures
allOf()	Wait for all futures
anyOf()	Wait for first future
exceptionally()	Handle exceptions
join()	Wait and get result
get()	Wait and get result (checked exception)
Interview One-Liner

CompletableFuture is a Java 8 class that enables asynchronous, non-blocking programming, allowing tasks to run in parallel, chain dependent operations, combine results, and handle exceptions efficiently.