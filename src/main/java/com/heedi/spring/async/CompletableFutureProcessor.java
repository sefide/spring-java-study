package com.heedi.spring.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFutureProcessor {

    private static final int THREAD_POOL_SIZE = 10;
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

    public void executeFail() {

        IntStream.range(0, 100)
                .forEach(i -> CompletableFuture.supplyAsync(() -> failTask(i))
                                .exceptionally(e -> {
                                    System.out.println(e.getMessage());
                                    throw new IllegalArgumentException("실패 했 습 니 다 !! ");
//                                    return 0;
                                })
                                .thenAccept(this::acceptTask)
                );

        // join 시 IllegalArgumentException 발생
    }

    private void acceptTask(int i) {
        System.out.println("통과 : " + i);
    }

    private int failTask(int i) {
        if (i % 2 == 1) {
            throw new RuntimeException("홀수는 안됩니다.");
        }

        return i;
    }
}
