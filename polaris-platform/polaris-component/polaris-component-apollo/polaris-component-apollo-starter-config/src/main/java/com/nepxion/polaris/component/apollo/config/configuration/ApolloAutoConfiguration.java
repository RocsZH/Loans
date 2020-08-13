package com.nepxion.polaris.component.apollo.config.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nepxion.polaris.component.apollo.config.provider.ApolloAppIdProvider;
import com.nepxion.polaris.component.env.provider.PolarisAppIdProvider;

@Configuration
public class ApolloAutoConfiguration {
    @Bean
    public PolarisAppIdProvider polarisAppIdProvider() {
        return new ApolloAppIdProvider();
    }
}
