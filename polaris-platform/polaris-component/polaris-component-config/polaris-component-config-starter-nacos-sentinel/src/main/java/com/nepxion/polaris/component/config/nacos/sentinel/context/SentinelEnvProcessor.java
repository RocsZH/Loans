package com.nepxion.polaris.component.config.nacos.sentinel.context;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.context.PolarisEnvPostProcessor;

public class SentinelEnvProcessor extends PolarisEnvPostProcessor {
    @Override
    public String getName() {
        return PolarisConstant.SENTINEL_CONFIG_NAME;
    }
}