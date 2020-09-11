package com.nepxion.polaris.component.config.apollo.context;

import org.springframework.core.env.ConfigurableEnvironment;

import com.ctrip.framework.foundation.Foundation;
import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.context.PolarisEnvPostProcessor;
import com.nepxion.polaris.component.env.context.PolarisEnvProvider;

public class ApolloEnvProcessor extends PolarisEnvPostProcessor {
    @Override
    public void process(ConfigurableEnvironment environment) throws Exception {
        String appId = Foundation.app().getAppId();
        PolarisEnvProvider.setAppId(appId);

        super.process(environment);

        System.setProperty(PolarisConstant.APOLLO_VERSION_NAME, PolarisConstant.APOLLO_VERSION_VALUE);
    }

    @Override
    public String getName() {
        return PolarisConstant.APOLLO_CONFIG_NAME;
    }
}