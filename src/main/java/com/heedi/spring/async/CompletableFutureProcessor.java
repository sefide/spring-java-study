package com.heedi.spring.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFutureProcessor {

    private static final int THREAD_POOL_SIZE = 100;
    private static final Executor executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public void execute() {
        List<CompletableFuture<String>> completableFutures = new ArrayList<>();

        IntStream.range(0, 100)
                .forEach(i -> completableFutures.add(
                        CompletableFuture.supplyAsync(() -> task("I'm "), executor)
                ));

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()]))
                .thenApply(Void -> completableFutures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()))
                .join()
                .forEach(System.out::println);
    }

    private String task(String s) {
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName());
            return s + "Hungry";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
