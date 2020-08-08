package com.nepxion.polaris.component.nacos.context;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.util.StringUtils;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.nepxion.polaris.component.common.constant.PolarisConstant;

public class NacosMetadataApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        applicationContext.getBeanFactory().addBeanPostProcessor(new InstantiationAwareBeanPostProcessorAdapter() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof NacosDiscoveryProperties) {
                    NacosDiscoveryProperties nacosDiscoveryProperties = (NacosDiscoveryProperties) bean;
                    Map<String, String> metadata = nacosDiscoveryProperties.getMetadata();

                    persistMetaInfo(metadata);
                }

                return bean;
            }
        });
    }

    private void persistMetaInfo(Map<String, String> metadata) {
        metadata.put(PolarisConstant.POLARIS_VERSION_NAME, PolarisConstant.POLARIS_VERSION_VALUE);

        metadata.put(PolarisConstant.NACOS_VERSION_NAME, PolarisConstant.NACOS_VERSION_VALUE);

        String sentinelVersion = System.getProperty(PolarisConstant.SENTINEL_VERSION_NAME);
        metadata.put(PolarisConstant.SENTINEL_VERSION_NAME, StringUtils.isEmpty(sentinelVersion) ? PolarisConstant.UNKNOWN : sentinelVersion);

        String skyWalkingAgentVersion = System.getProperty(PolarisConstant.SKY_WALKING_AGENT_VERSION_NAME);
        metadata.put(PolarisConstant.SKY_WALKING_AGENT_VERSION_NAME, StringUtils.isEmpty(skyWalkingAgentVersion) ? PolarisConstant.UNKNOWN : skyWalkingAgentVersion);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}