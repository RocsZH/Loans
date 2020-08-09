package com.nepxion.polaris.component.eureka.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.Ordered;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.common.exception.PolarisException;
import com.nepxion.polaris.component.env.processor.PolarisEnvProcessor;

public class EurekaEnvApplicationContextInitializer extends PolarisEnvProcessor implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {
    private static final Logger LOG = LoggerFactory.getLogger(EurekaEnvApplicationContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (!(applicationContext instanceof AnnotationConfigApplicationContext)) {
            try {
                LOG.info("Initialize Eureka env...");

                process(PolarisConstant.EUREKA_NAME);
            } catch (Exception e) {
                LOG.error("Initialize Eureka env failed", e);

                throw new PolarisException(e);
            }
        }
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}