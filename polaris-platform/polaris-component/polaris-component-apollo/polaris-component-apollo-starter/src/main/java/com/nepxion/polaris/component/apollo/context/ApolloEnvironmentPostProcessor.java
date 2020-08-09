package com.nepxion.polaris.component.apollo.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.common.exception.PolarisException;
import com.nepxion.polaris.component.env.processor.PolarisEnvProcessor;

public class ApolloEnvironmentPostProcessor extends PolarisEnvProcessor implements EnvironmentPostProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(ApolloEnvironmentPostProcessor.class);

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        try {
            LOG.info("Initialize Apollo env...");

            String env = getEnv();

            loadEnvProperties(PolarisConstant.APOLLO_NAME, env);
            loadConfigProperties(PolarisConstant.APOLLO_NAME);

            System.setProperty(PolarisConstant.APOLLO_VERSION_NAME, PolarisConstant.APOLLO_VERSION_VALUE);
        } catch (Exception e) {
            LOG.error("Initialize Apollo env failed", e);

            throw new PolarisException(e);
        }
    }
}