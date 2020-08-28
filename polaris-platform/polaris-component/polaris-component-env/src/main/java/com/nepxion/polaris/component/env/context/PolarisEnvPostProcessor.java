package com.nepxion.polaris.component.env.context;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

import com.nepxion.polaris.component.common.exception.PolarisException;

public abstract class PolarisEnvPostProcessor extends PolarisEnvProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (StringUtils.equals(environment.getClass().getName(), StandardEnvironment.class.getName())) {
            try {
                process(environment);
            } catch (Exception e) {

                throw new PolarisException(e);
            }
        }
    }

    @Override
    protected boolean isEnvLogShown() {
        return false;
    }
}