package com.nepxion.polaris.component.skywalking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nepxion.discovery.plugin.strategy.adapter.StrategyTracerAdapter;
import com.nepxion.polaris.component.skywalking.adapter.SkywalkingStrategyTracerAdapter;

@Configuration
public class SkywalkingAutoConfiguration {
    @Bean
    public StrategyTracerAdapter strategyTracerAdapter() {
        return new SkywalkingStrategyTracerAdapter();
    }
}