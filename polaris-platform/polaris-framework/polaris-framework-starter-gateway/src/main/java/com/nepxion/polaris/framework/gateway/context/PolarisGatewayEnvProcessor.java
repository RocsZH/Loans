package com.nepxion.polaris.framework.gateway.context;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.context.PolarisEnvPostProcessor;

public class PolarisGatewayEnvProcessor extends PolarisEnvPostProcessor {
    @Override
    public String getName() {
        return PolarisConstant.POLARIS_GATEWAY_NAME;
    }
}