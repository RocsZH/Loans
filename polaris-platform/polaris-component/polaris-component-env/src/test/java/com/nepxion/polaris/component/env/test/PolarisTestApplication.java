package com.nepxion.polaris.component.env.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PolarisTestApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PolarisTestApplication.class).run(args);
    }
}