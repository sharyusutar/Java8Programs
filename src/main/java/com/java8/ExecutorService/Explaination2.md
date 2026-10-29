Explain ExecutorService. How do you use it?
Answer:

ExecutorService manages task execution through an executor rather than requiring developers to manually create and manage individual threads.

Benefits include thread reuse, task queuing, lifecycle management, and asynchronous execution.

Runnable example:

import java.util.concurrent.*;

public class PaymentExecutor {

    public static void main(String[] args)
            throws Exception {

        ExecutorService executor =
            Executors.newFixedThreadPool(3);

        try {
            Callable<String> task = () -> {
                Thread.sleep(500);
                return "Payment processed by " +
                    Thread.currentThread().getName();
            };

            Future<String> future =
                executor.submit(task);

            System.out.println(future.get());
        } finally {
            executor.shutdown();
        }
    }
}



Follow-up questions:

What is the difference between execute() and submit()?

execute() accepts a Runnable and returns no Future. submit() accepts a Runnable or Callable and returns a Future.

What happens if a task throws an exception?

For submit(), the exception is captured in the Future and surfaced through get() as an ExecutionException. For execute(), an uncaught exception reaches the worker's uncaught-exception handling.

Why should we shut down ExecutorService?

To stop accepting new tasks and allow resources to be released. In production, also consider awaitTermination() and a controlled shutdown strategy.

Senior-level point: Executors.newFixedThreadPool() uses an unbounded queue. For high-volume payment workloads, consider an explicitly configured ThreadPoolExecutor with a bounded queue and rejection policy.