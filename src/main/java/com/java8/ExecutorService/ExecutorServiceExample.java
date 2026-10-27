package com.java8.ExecutorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int j=1;j<=20;j++){
            int finalJ = j;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" "+ finalJ);
                }
            }).get();
            //get() is a blocking method.
            // It blocks the thread that calls it, not necessarily the thread executing the task.
        }

    }
}
