package com.heedi.spring.concurrent;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TaskProcessor {

    @Async("threadPoolTaskExecutor")
    public void run_AbortPolicy(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }

    @Async("callerRunsThreadPoolTaskExecutor")
    public void run_CallerRunsPolicy(int i) {
        System.out.println(i);
    }

    @Async("discardThreadPoolTaskExecutor")
    public void run_DiscardPolicy(int i) {
        System.out.println(i);
    }

    @Async("discardOldestThreadPoolTaskExecutor")
    public void run_DiscardOldestPolicy(int i) {
        System.out.println(i);
    }

}
