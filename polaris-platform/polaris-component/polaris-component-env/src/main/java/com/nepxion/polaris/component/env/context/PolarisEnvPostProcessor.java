package com.nepxion.polaris.component.env.context;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

import com.nepxion.polaris.component.common.exception.PolarisException;

public abstract class PolarisEnvPostProcessor extends PolarisEnvProcessor implements EnvironmentPostProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(PolarisEnvProcessor.class);

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (StringUtils.equals(environment.getClass().getName(), StandardEnvironment.class.getName())) {
            try {
                LOG.info("Initialize {} env...", getName());

                process(environment);
            } catch (Exception e) {
                LOG.error("Initialize {} env failed", getName(), e);

                throw new PolarisException(e);
            }
        }
    }
}