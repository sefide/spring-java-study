package com.heedi.spring.async;

import java.util.concurrent.ExecutionException;

public class AsyncApplication {
    private static CompletableFutureProcessor completableFutureProcessor;

    public static void main(String[] args) {
//        executeFixedThreadTest();

        executeFutureTest();
//        executeCompletableFutureTest();
//        executeCompletableFutureFailTest();
    }

    private static void executeFutureTest() {
        FutureProcessor futureProcessor = new FutureProcessor();
        try {
            futureProcessor.execute();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void executeFixedThreadTest() {
        FixedThreadProcessor fixedThreadProcessor = new FixedThreadProcessor();
        fixedThreadProcessor.execute();
    }

    private static void executeCompletableFutureTest() {
        completableFutureProcessor = new CompletableFutureProcessor();
        completableFutureProcessor.execute();
    }

    private static void executeCompletableFutureFailTest() {
        completableFutureProcessor = new CompletableFutureProcessor();
        completableFutureProcessor.executeFail();
    }
}
