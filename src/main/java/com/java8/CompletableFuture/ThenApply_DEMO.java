package com.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class ThenApply_DEMO {

    public static void main(String[] args) {

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> "java")
                        .thenApply(String::toUpperCase);

        System.out.println(future.join());
    }

}