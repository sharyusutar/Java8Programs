package com.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class ThenAccept_DEMO {

    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> "Java 8")
                .thenAccept(System.out::println)
                .join();
    }
}
