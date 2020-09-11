package com.nepxion.polaris.component.discovery.consul.context;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;

import com.nepxion.polaris.component.common.constant.PolarisConstant;

public class ConsulMetadataApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        applicationContext.getBeanFactory().addBeanPostProcessor(new InstantiationAwareBeanPostProcessorAdapter() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof ConsulDiscoveryProperties) {
                    ConsulDiscoveryProperties consulDiscoveryProperties = (ConsulDiscoveryProperties) bean;
                    List<String> metadata = consulDiscoveryProperties.getTags();

                    persistMetaInfo(metadata);
                }

                return bean;
            }
        });
    }

    private void persistMetaInfo(List<String> metadata) {
        metadata.add(PolarisConstant.POLARIS_VERSION_NAME + "=" + PolarisConstant.POLARIS_VERSION_VALUE);

        metadata.add(PolarisConstant.CONSUL_VERSION_NAME + "=" + PolarisConstant.CONSUL_VERSION_VALUE);

        Properties properties = System.getProperties();

        for (String key : properties.stringPropertyNames()) {
            if (StringUtils.startsWithIgnoreCase(key, PolarisConstant.POLARIS_NAME.toLowerCase() + ".")) {
                String value = properties.getProperty(key);

                metadata.add(key + "=" + (StringUtils.isEmpty(value) ? PolarisConstant.UNKNOWN : value));
            }
        }
    }
}