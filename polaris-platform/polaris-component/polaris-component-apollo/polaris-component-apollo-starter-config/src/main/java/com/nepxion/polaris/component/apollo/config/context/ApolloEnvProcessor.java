package com.nepxion.polaris.component.apollo.config.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import com.ctrip.framework.foundation.Foundation;
import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.common.exception.PolarisException;
import com.nepxion.polaris.component.env.processor.PolarisEnvProcessor;
import com.nepxion.polaris.component.env.provider.PolarisEnvProvider;

public class ApolloEnvProcessor extends PolarisEnvProcessor implements EnvironmentPostProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(ApolloEnvProcessor.class);

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        try {
            LOG.info("Initialize {} env...", getName());

            String appId = Foundation.app().getAppId();
            PolarisEnvProvider.setAppId(appId);

            process(environment);

            System.setProperty(PolarisConstant.APOLLO_VERSION_NAME, PolarisConstant.APOLLO_VERSION_VALUE);
        } catch (Exception e) {
            LOG.error("Initialize {} env failed", getName(), e);

            throw new PolarisException(e);
        }
    }

    @Override
    public String getName() {
        return PolarisConstant.APOLLO_CONFIG_NAME;
    }
}