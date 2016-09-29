package com.example.config;

import com.google.common.eventbus.AsyncEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author victorzagnitko
 */
@Configuration
public class EventBusConfiguration {

    @Bean
    public AsyncEventBus asyncEventBusBean(@Autowired Executor executor) {
        return new AsyncEventBus(executor);
    }

    @Bean(destroyMethod = "shutdownNow")
    public Executor executors() {
        return Executors.newSingleThreadExecutor();
    }

}
