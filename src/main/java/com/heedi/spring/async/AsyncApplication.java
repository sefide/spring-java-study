package com.heedi.spring.async;

public class AsyncApplication {
    private static FixedThreadProcessor fixedThreadProcessor;
    private static CompletableFutureProcessor completableFutureProcessor;

    public static void main(String[] args) {
        FixedThreadProcessor();
        executeCompletableFutureTest();
        executeCompletableFutureFailTest();
    }

    private static void FixedThreadProcessor() {
        fixedThreadProcessor = new FixedThreadProcessor();
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
