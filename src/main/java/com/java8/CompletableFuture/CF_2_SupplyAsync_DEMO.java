package com.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CF_2_SupplyAsync_DEMO {
    public static void main(String[] args) {

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {
                    return "Hello Java";
                });

        System.out.println(future.join());
    }
}
