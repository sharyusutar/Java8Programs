package com.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class Exceptionally_DEMO {

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
