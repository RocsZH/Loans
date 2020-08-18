package com.nepxion.polaris.component.consul.discovery.context;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.context.PolarisEnvPostProcessor;

public class ConsulEnvProcessor extends PolarisEnvPostProcessor {
    @Override
    public String getName() {
        return PolarisConstant.CONSUL_DISCOVERY_NAME;
    }
}