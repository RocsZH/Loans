package com.nepxion.polaris.component.sentinel.common.context;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.alibaba.csp.sentinel.log.LogBase;
import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.common.exception.PolarisException;
import com.nepxion.polaris.component.env.processor.PolarisEnvProcessor;

public class SentinelEnvApplicationContextInitializer extends PolarisEnvProcessor implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    private static final Logger LOG = LoggerFactory.getLogger(SentinelEnvApplicationContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (!(applicationContext instanceof AnnotationConfigApplicationContext)) {
            try {
                LOG.info("Initialize {} env...", getName());

                process(applicationContext.getEnvironment());

                String projectName = getProjectName(applicationContext.getEnvironment());
                System.setProperty(PolarisConstant.SENTINEL_PROJECT_NAME, projectName);
                
                String logPath = getLogPath();
                System.setProperty(LogBase.LOG_DIR, logPath + projectName);

                System.setProperty(PolarisConstant.SENTINEL_VERSION_NAME, PolarisConstant.SENTINEL_VERSION_VALUE);
            } catch (Exception e) {
                LOG.error("Initialize {} env failed", getName(), e);

                throw new PolarisException(e);
            }
        }
    }

    @Override
    protected String decorateValue(Environment environment, String key, String value) {
        // 处理Nacos作为Datasource下，dataId加上服务名前缀
        if (StringUtils.endsWith(key, PolarisConstant.NACOS_DATA_ID)) {
            return getSpringApplicationName(environment) + PolarisConstant.DASH + value;
        }

        return super.decorateValue(environment, key, value);
    }

    @Override
    public String getName() {
        return PolarisConstant.SENTINEL_NAME;
    }
}