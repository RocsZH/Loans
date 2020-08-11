package com.nepxion.polaris.component.sentinel.zuul.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulErrorFilter;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulPostFilter;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulPreFilter;

@Configuration
public class SentinelZuulAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public SentinelZuulPreFilter sentinelZuulPreFilter() {
        return new SentinelZuulPreFilter();
    }

    @Bean
    @ConditionalOnMissingBean
    public SentinelZuulPostFilter sentinelZuulPostFilter() {
        return new SentinelZuulPostFilter();
    }

    @Bean
    @ConditionalOnMissingBean
    public SentinelZuulErrorFilter sentinelZuulErrorFilter() {
        return new SentinelZuulErrorFilter();
    }
}