package com.nepxion.polaris.component.sentinel.common.context;

import org.springframework.core.env.ConfigurableEnvironment;

import com.alibaba.csp.sentinel.log.LogBase;
import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.context.PolarisEnvPostProcessor;

public class SentinelEnvProcessor extends PolarisEnvPostProcessor {
    @Override
    public void process(ConfigurableEnvironment environment) throws Exception {
        super.process(environment);

        String projectName = getProjectName(environment);
        System.setProperty(PolarisConstant.SENTINEL_PROJECT_NAME, projectName);

        String logPath = getLogPath();
        System.setProperty(LogBase.LOG_DIR, logPath + projectName);

        System.setProperty(PolarisConstant.SENTINEL_VERSION_NAME, PolarisConstant.SENTINEL_VERSION_VALUE);
    }

    @Override
    public String getName() {
        return PolarisConstant.SENTINEL_NAME;
    }
}