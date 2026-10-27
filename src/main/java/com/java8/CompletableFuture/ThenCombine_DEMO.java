package com.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class ThenCombine_DEMO {

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