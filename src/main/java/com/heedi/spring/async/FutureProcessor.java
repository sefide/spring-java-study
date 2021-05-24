package com.heedi.spring.async;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureProcessor {
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    public void execute() throws ExecutionException, InterruptedException {
        Future<Integer> future = executor.submit(() -> {
            System.out.println("start _ " + LocalDateTime.now());
            int sum = 1 + 1;
            Thread.sleep(5000);
            return sum;
        });

        System.out.println("end _ " + LocalDateTime.now());
        Integer result = future.get();
        // future 수행 완료 후 결과 출력
        System.out.println("result : " + result);
    }

}
