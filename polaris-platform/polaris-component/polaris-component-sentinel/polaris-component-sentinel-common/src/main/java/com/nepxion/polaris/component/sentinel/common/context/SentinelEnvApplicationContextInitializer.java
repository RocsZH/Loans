package com.nepxion.polaris.component.sentinel.common.context;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alibaba.csp.sentinel.log.LogBase;
import com.ctrip.framework.foundation.Foundation;
import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.common.exception.PolarisException;
import com.nepxion.polaris.component.env.processor.PolarisEnvProcessor;

public class SentinelEnvApplicationContextInitializer extends PolarisEnvProcessor implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final Logger LOG = LoggerFactory.getLogger(SentinelEnvApplicationContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (!(applicationContext instanceof AnnotationConfigApplicationContext)) {
            try {
                LOG.info("Initialize Sentinel env...");

                String env = getEnv();

                loadEnvProperties(PolarisConstant.SENTINEL_NAME, env);
                loadConfigProperties(PolarisConstant.SENTINEL_NAME);

                String appId = Foundation.app().getAppId();
                System.setProperty(PolarisConstant.SENTINEL_PROJECT_NAME, appId);

                String logPath = getLogPath();
                System.setProperty(LogBase.LOG_DIR, logPath + appId);

                System.setProperty(PolarisConstant.SENTINEL_VERSION_NAME, PolarisConstant.SENTINEL_VERSION_VALUE);
            } catch (Exception e) {
                LOG.error("Initialize Sentinel env failed", e);

                throw new PolarisException(e);
            }
        }
    }
}