package com.nepxion.polaris.component.nacos.context;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.Ordered;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.common.exception.PolarisException;
import com.nepxion.polaris.component.env.entity.PolarisEnv;
import com.nepxion.polaris.component.env.processor.PolarisEnvProcessor;

public class NacosEnvApplicationContextInitializer extends PolarisEnvProcessor implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {
    private static final Logger LOG = LoggerFactory.getLogger(NacosEnvApplicationContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (!(applicationContext instanceof AnnotationConfigApplicationContext)) {
            try {
                String env = getEnv();
                if (StringUtils.isBlank(env)) {
                    env = PolarisEnv.DEV.getEnv();
                }

                loadComponentEnv(PolarisConstant.NACOS_NAME, env);
                loadComponentConfig(PolarisConstant.NACOS_NAME);
            } catch (Exception e) {
                LOG.error("Initialize Nacos env failed", e);

                throw new PolarisException(e);
            }
        }
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}