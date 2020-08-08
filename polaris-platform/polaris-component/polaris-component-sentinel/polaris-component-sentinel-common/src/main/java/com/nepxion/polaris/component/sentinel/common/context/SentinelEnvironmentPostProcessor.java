package com.nepxion.polaris.component.sentinel.common.context;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import com.alibaba.csp.sentinel.log.LogBase;
import com.ctrip.framework.foundation.Foundation;
import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.entity.PolarisEnv;
import com.nepxion.polaris.component.env.processor.PolarisEnvProcessor;
import com.nepxion.polaris.component.sentinel.common.exception.SentinelException;

public class SentinelEnvironmentPostProcessor extends PolarisEnvProcessor implements EnvironmentPostProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(SentinelEnvironmentPostProcessor.class);

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        try {
            String appId = Foundation.app().getAppId();
            System.setProperty(PolarisConstant.SENTINEL_PROJECT_NAME, appId);

            String logPath = getLogPath();
            System.setProperty(LogBase.LOG_DIR, logPath + appId);

            String env = getEnv();
            if (StringUtils.isBlank(env)) {
                env = PolarisEnv.DEV.getEnv();
            }
            loadComponentEnv(PolarisConstant.SENTINEL_NAME, env);

            loadComponentConfig(PolarisConstant.SENTINEL_NAME);

            System.setProperty(PolarisConstant.SENTINEL_VERSION_NAME, PolarisConstant.SENTINEL_VERSION_VALUE);
        } catch (Exception e) {
            LOG.error("Initialize Sentinel environment failed", e.getMessage());

            throw new SentinelException(e.getMessage());
        }
    }
}