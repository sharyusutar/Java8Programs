package com.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CF_1_RunAsync_DEMO {
    public static void main(String[] args) {

        CompletableFuture<Void> future =
                CompletableFuture.runAsync(() -> {
                    System.out.println("Running in background");
                });

        future.join();
    }
}
