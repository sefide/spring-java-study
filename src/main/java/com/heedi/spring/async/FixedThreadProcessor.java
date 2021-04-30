package com.heedi.spring.async;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class FixedThreadProcessor {

    private static final int THREAD_POOL_SIZE = 100;

    private static final Executor executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public void executeFixedThreadPool() {
        IntStream.range(0, 100)
                .forEach(n -> executor.execute(() -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("task " + threadName + " start");
                    task();
                    System.out.println("task " + threadName + " end");
                }));
    }

    private void task() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
