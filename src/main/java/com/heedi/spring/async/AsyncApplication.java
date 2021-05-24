package com.heedi.spring.async;

import java.util.concurrent.ExecutionException;

public class AsyncApplication {
    private static FutureProcessor futureProcessor;
    private static CompletableFutureProcessor completableFutureProcessor;

    public static void main(String[] args) {
//        executeFixedThreadTest();

        executeFutureTest();
//        executeFutureTimeoutTest();
//        executeFutureCancelTest();
//        executeCompletableFutureTest();
//        executeCompletableFutureFailTest();
    }

    private static void executeFutureTest() {
        futureProcessor = new FutureProcessor();
        try {
            futureProcessor.execute();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println(e);
        }
    }

    private static void executeFutureTimeoutTest() {
        futureProcessor = new FutureProcessor();
        futureProcessor.executeTimeout();
    }

    private static void executeFutureCancelTest() {
        futureProcessor = new FutureProcessor();
        futureProcessor.executeCancel();
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
