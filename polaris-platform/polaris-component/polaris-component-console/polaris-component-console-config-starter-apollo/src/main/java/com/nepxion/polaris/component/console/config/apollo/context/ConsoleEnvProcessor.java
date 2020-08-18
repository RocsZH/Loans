package com.nepxion.polaris.component.console.config.apollo.context;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.context.PolarisEnvPostProcessor;

public class ConsoleEnvProcessor extends PolarisEnvPostProcessor {
    @Override
    public String getName() {
        return PolarisConstant.CONSOLE_NAME;
    }
}