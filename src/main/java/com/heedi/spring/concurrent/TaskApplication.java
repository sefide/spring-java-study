package com.heedi.spring.concurrent;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;

@EnableAsync
@RestController
@SpringBootApplication
public class TaskApplication {

    private static TaskProcessor taskProcessor = new TaskProcessor();

    public static void main(String[] args) {
//        run_AbortPolicy();
//        run_CallerRunsPolicy();
        run_DiscardPolicy();
//        run_DiscardOldestPolicy();
    }

    private static void run_AbortPolicy() {
        for (int i = 0; i < 50; i++) {
            taskProcessor.run_AbortPolicy(i);
            System.out.println("task 완료");
        }
    }

    private static void run_CallerRunsPolicy() {
        for (int i = 0; i < 50; i++) {
            taskProcessor.run_CallerRunsPolicy(i);
        }
    }

    private static void run_DiscardPolicy() {
        for (int i = 0; i < 50; i++) {
            taskProcessor.run_DiscardPolicy(i);
        }
    }

    private static void run_DiscardOldestPolicy() {
        for (int i = 0; i < 50; i++) {
            taskProcessor.run_DiscardOldestPolicy(i);
        }
    }
}
