package com.java8.ExecutorService;


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
