package com.heedi.spring.async;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class FutureProcessor {
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    public void execute() throws ExecutionException, InterruptedException, TimeoutException {
        Future<Integer> future = executor.submit(() -> {
            System.out.println("start _ " + LocalDateTime.now());
            int sum = 1 + 1;
            Thread.sleep(5000);
            return sum;
        });

        System.out.println("end _ " + LocalDateTime.now());
        // future 수행 완료 후 결과 출력
        Integer result = future.get();
        // java.util.concurrent.TimeoutException 발생
        // Integer result = future.get(2000, TimeUnit.MILLISECONDS);
        System.out.println("result : " + result);
    }

}
