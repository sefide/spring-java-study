package com.heedi.spring.async;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class FutureProcessor {
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();
    private static final Future<Integer> FUTURE_WORK_5_SECONDS = executor.submit(() -> {
        System.out.println("start _ " + LocalDateTime.now());
        int sum = 1 + 1003;
        Thread.sleep(5000);
        return sum;
    });

    public void execute() throws ExecutionException, InterruptedException {
        System.out.println("end _ " + LocalDateTime.now());
        // Future 수행 완료 후 결과 출력 (blocking - 지연완료 객체)
        Integer result = FUTURE_WORK_5_SECONDS.get();

        System.out.println("result : " + result);
        executor.shutdown();
    }

    public void executeTimeout() {
        Integer result = null;
        try {
            result = FUTURE_WORK_5_SECONDS.get(2000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            System.out.println("java.util.concurrent.TimeoutException 발생");
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("ExecutionException | InterruptedException 발생");
            System.out.println(e);
        }
        System.out.println("result : " + result); // null
        executor.shutdown();
    }

    public void executeCancel() {
        FUTURE_WORK_5_SECONDS.cancel(true);

        // java.util.concurrent.CancellationException
        // int result = FUTURE_WORK_5_SECONDS.get();
        System.out.println("isCancelled : " + FUTURE_WORK_5_SECONDS.isCancelled());
        System.out.println("isDone : " + FUTURE_WORK_5_SECONDS.isDone());
        executor.shutdown();
    }

}
