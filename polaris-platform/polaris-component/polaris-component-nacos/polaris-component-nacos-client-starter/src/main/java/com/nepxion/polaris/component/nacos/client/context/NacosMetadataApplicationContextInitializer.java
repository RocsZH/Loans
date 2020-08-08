package com.nepxion.polaris.component.nacos.client.context;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.nepxion.polaris.component.common.constant.PolarisConstant;

public class NacosMetadataApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
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
    }
}