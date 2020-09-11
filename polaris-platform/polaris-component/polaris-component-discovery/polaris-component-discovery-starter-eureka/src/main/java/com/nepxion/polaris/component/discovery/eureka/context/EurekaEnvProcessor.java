package com.nepxion.polaris.component.discovery.eureka.context;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.context.PolarisEnvPostProcessor;

public class EurekaEnvProcessor extends PolarisEnvPostProcessor {
    @Override
    public String getName() {
        return PolarisConstant.EUREKA_DISCOVERY_NAME;
    }
}