package com.nepxion.polaris.framework.console.context;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.common.exception.PolarisException;
import com.nepxion.polaris.component.env.processor.PolarisEnvProcessor;

public class PolarisConsoleEnvProcessor extends PolarisEnvProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (StringUtils.equals(environment.getClass().getName(), StandardEnvironment.class.getName())) {
            try {
                System.out.println("Initialize " + getName() + " env...");

                process(environment);
            } catch (Exception e) {
                throw new PolarisException(e);
            }
        }
    }

    @Override
    public String getName() {
        return PolarisConstant.POLARIS_CONSOLE_NAME;
    }
}