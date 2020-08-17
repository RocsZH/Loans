package com.nepxion.polaris.component.apollo.config.context;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

import com.ctrip.framework.foundation.Foundation;
import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.common.exception.PolarisException;
import com.nepxion.polaris.component.env.processor.PolarisEnvProcessor;
import com.nepxion.polaris.component.env.provider.PolarisEnvProvider;

public class ApolloEnvProcessor extends PolarisEnvProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (StringUtils.equals(environment.getClass().getName(), StandardEnvironment.class.getName())) {
            try {
                System.out.println("Initialize " + getName() + " env...");

                String appId = Foundation.app().getAppId();
                PolarisEnvProvider.setAppId(appId);

                process(environment);

                System.setProperty(PolarisConstant.APOLLO_VERSION_NAME, PolarisConstant.APOLLO_VERSION_VALUE);
            } catch (Exception e) {
                throw new PolarisException(e);
            }
        }
    }

    @Override
    public String getName() {
        return PolarisConstant.APOLLO_CONFIG_NAME;
    }
}