package com.nepxion.polaris.framework.zuul.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.common.exception.PolarisException;
import com.nepxion.polaris.component.env.processor.PolarisEnvProcessor;

public class PolarisZuulEnvProcessor extends PolarisEnvProcessor implements EnvironmentPostProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(PolarisZuulEnvProcessor.class);

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        try {
            LOG.info("Initialize {} env...", getName());

            process();
        } catch (Exception e) {
            LOG.error("Initialize {} env failed", getName(), e);

            throw new PolarisException(e);
        }
    }

    @Override
    public String getName() {
        return PolarisConstant.ZUUL_NAME;
    }
}