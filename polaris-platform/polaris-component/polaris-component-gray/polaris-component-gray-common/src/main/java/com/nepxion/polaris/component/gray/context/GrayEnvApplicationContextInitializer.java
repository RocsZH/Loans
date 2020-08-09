package com.nepxion.polaris.component.gray.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.Ordered;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.common.exception.PolarisException;
import com.nepxion.polaris.component.env.processor.PolarisEnvProcessor;

public class GrayEnvApplicationContextInitializer extends PolarisEnvProcessor implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {
    private static final Logger LOG = LoggerFactory.getLogger(GrayEnvApplicationContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (!(applicationContext instanceof AnnotationConfigApplicationContext)) {
            try {
                LOG.info("Initialize Gray env...");

                process(PolarisConstant.GRAY_NAME);
            } catch (Exception e) {
                LOG.error("Initialize Gray env failed", e);

                throw new PolarisException(e);
            }
        }
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}