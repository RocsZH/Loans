package com.nepxion.polaris.component.prometheus.micrometer.context;

import org.springframework.core.env.ConfigurableEnvironment;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.context.PolarisEnvPostProcessor;

public class MicrometerEnvProcessor extends PolarisEnvPostProcessor {
    @Override
    public void process(ConfigurableEnvironment environment) throws Exception {
        super.process(environment);

        String projectName = getProjectName(environment);
        System.setProperty(PolarisConstant.MANAGEMENT_METRICS_TAGS_APPLICATION_NAME, projectName);
    }

    @Override
    public String getName() {
        return PolarisConstant.PROMETHEUS_MICROMETER_NAME;
    }
}