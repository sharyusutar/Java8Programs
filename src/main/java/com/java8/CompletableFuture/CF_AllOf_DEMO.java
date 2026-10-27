package com.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CF_AllOf_DEMO {

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