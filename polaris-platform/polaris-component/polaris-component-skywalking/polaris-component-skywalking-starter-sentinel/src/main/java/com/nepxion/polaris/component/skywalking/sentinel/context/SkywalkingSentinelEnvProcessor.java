package com.nepxion.polaris.component.skywalking.sentinel.context;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.context.PolarisEnvPostProcessor;

public class SkywalkingSentinelEnvProcessor extends PolarisEnvPostProcessor {
    @Override
    public String getName() {
        return PolarisConstant.SKYWALKING_SENTINEL_NAME;
    }
}