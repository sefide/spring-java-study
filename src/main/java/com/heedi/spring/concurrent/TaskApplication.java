package com.heedi.spring.concurrent;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class TaskApplication implements CommandLineRunner {

    private static TaskProcessor taskProcessor = new TaskProcessor();

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 50; i++) {
//        taskProcessor.run_AbortPolicy(i);
        taskProcessor.run_CallerRunsPolicy(i);
//            taskProcessor.run_DiscardPolicy(i);
//        taskProcessor.run_DiscardOldestPolicy(i);
        }

    }
}
