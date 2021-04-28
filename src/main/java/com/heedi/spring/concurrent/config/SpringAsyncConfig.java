package com.heedi.spring.concurrent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class SpringAsyncConfig extends AsyncConfigurerSupport {

    @Bean(name = "defaultThreadPoolTaskExecutor")
    public Executor defaultThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(5);
        threadPoolExecutor.setMaxPoolSize(5);
        threadPoolExecutor.setQueueCapacity(1);
        threadPoolExecutor.setThreadNamePrefix("Executor-");
        threadPoolExecutor.initialize();

        return threadPoolExecutor;
    }

    @Bean(name = "callerRunsThreadPoolTaskExecutor")
    public Executor callerRunsThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(5);
        threadPoolExecutor.setMaxPoolSize(5);
        threadPoolExecutor.setQueueCapacity(1);
        threadPoolExecutor.setThreadNamePrefix("Executor-");
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.initialize();

        return threadPoolExecutor;
    }

    @Bean(name = "discardThreadPoolTaskExecutor")
    public Executor discardThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(5);
        threadPoolExecutor.setMaxPoolSize(5);
        threadPoolExecutor.setQueueCapacity(1);
        threadPoolExecutor.setThreadNamePrefix("Executor-");
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.initialize();

        return threadPoolExecutor;
    }

    @Bean(name = "discardOldestThreadPoolTaskExecutor")
    public Executor discardOldestThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(5);
        threadPoolExecutor.setMaxPoolSize(5);
        threadPoolExecutor.setQueueCapacity(1);
        threadPoolExecutor.setThreadNamePrefix("Executor-");
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        threadPoolExecutor.initialize();

        return threadPoolExecutor;
    }
}
