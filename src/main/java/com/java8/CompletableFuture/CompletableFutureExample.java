package com.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/** Standalone Java 8+ demo. No Spring or external dependencies required. */
public class CompletableFutureExample {
    public static void main(String[] args) {
        demonstrate(true, false);
        demonstrate(false, false);
        demonstrate(true, true);
    }

    private static void demonstrate(boolean isAsync, boolean simulateFailure) {
        System.out.println("\n--- isAsync=" + isAsync
                + ", simulateFailure=" + simulateFailure + " ---");
        log("Submitting batch of 100 invoices");

        CompletableFuture<?> completion;
        if (isAsync) {
            CompletableFuture<String> responseFuture =
                    CompletableFuture.supplyAsync(() ->
                            blockingHttpCall(simulateFailure));

            completion = responseFuture.whenComplete((response, throwable) -> {
                if (throwable != null) {
                    log("Request failed: " + rootCause(throwable).getMessage());
                } else {
                    log("Response: " + response);
                }
            });
        } else {
            // Despite isAsync=false, runAsync ALSO starts background work.
            CompletableFuture<Void> responseFuture =
                    CompletableFuture.runAsync(() -> {
                        blockingHttpCall(simulateFailure);
                        // The response value is discarded in this branch.
                    });

            completion = responseFuture.whenComplete((unused, throwable) -> {
                if (throwable != null) {
                    log("Request failed: " + rootCause(throwable).getMessage());
                } else {
                    log("Request finished; runAsync returns no response value");
                }
            });
        }

        log("Calling thread can continue doing other work");

        // Only for this console demo: keep the process alive and separate runs.
        // Joining the callback stage also ensures its logging has finished.
        // A caller that joins here DOES wait, even though work was scheduled async.
        try {
            completion.join();
        } catch (CompletionException exception) {
            log("join() still reports failure: whenComplete did not recover it");
        }
    }

    private static String blockingHttpCall(boolean simulateFailure) {
        log("Simulated HTTP POST started; this worker blocks for 2 seconds");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Request interrupted", exception);
        }
        if (simulateFailure) {
            throw new IllegalStateException("Batch service unavailable");
        }
        return "200 OK - batch accepted";
    }

    private static Throwable rootCause(Throwable throwable) {
        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        return throwable;
    }

    private static void log(String message) {
        System.out.println("[" + Thread.currentThread().getName() + "] " + message);
    }
}
