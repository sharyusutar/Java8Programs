package com.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class ThenRun_DEMO {

    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> "Task Completed")
                .thenRun(() ->
                        System.out.println("Next Task"))
                .join();
    }
}