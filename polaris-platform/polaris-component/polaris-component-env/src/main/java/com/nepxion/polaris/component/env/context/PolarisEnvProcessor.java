package com.nepxion.polaris.component.env.context;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.constant.PolarisEnvConstant;

public abstract class PolarisEnvProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(PolarisEnvProcessor.class);

    public void process(ConfigurableEnvironment environment) throws Exception {
        String name = getName();

        processCommonProperties(environment, name);
        processEnvProperties(environment, name);
    }

    public void processCommonProperties(ConfigurableEnvironment environment, String name) throws Exception {
        String path = PolarisEnvConstant.META_INF_PATH + name + "-" + PolarisConstant.COMMON + "." + PolarisConstant.PROPERTIES_FORMAT;

        processProperties(environment, path);
    }

    public void processEnvProperties(ConfigurableEnvironment environment, String name) throws Exception {
        String env = getEnv();
        String path = PolarisEnvConstant.META_INF_PATH + name + "-" + env + "." + PolarisConstant.PROPERTIES_FORMAT;

        processProperties(environment, path);
    }

    public void processProperties(ConfigurableEnvironment environment, String path) throws Exception {
        Properties properties = processProperties(path);

        boolean isEnvLogShown = isEnvLogShown();
        for (String key : properties.stringPropertyNames()) {
            // 如果已经设置，则尊重已经设置的值
            if (environment.getProperty(key) == null && System.getProperty(key) == null && System.getenv(key.toUpperCase()) == null) {
                String value = properties.getProperty(key);

                value = processValue(environment, key, value);

                if (isEnvLogShown) {
                    LOG.info("* Env parameter : {} = {}", key, value);
                } else {
                    System.out.println("* Env parameter : " + key + " = " + value);
                }

                System.setProperty(key, value);
            } else {
                if (isEnvLogShown) {
                    LOG.info("* Env parameter : {} has been set outside", key);
                } else {
                    System.out.println("* Env parameter : " + key + " has been set outside");
                }
            }
        }
    }

    public Properties processProperties(String path) throws Exception {
        Properties properties = new Properties();

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(path);
        try {
            inputStream = resource.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);

            properties.load(inputStreamReader);
        } finally {
            IOUtils.closeQuietly(inputStreamReader);
            IOUtils.closeQuietly(inputStream);
        }

        return properties;
    }

    // 提供扩展点，供实现端实现配置值的再加工
    protected String processValue(ConfigurableEnvironment environment, String key, String value) {
        return value;
    }

    protected boolean isEnvLogShown() {
        return true;
    }

    public String getRootDomain() {
        return PolarisEnvProvider.getRootDomain();
    }

    public String getZone() {
        return PolarisEnvProvider.getZone();
    }

    public String getEnv() {
        return PolarisEnvProvider.getEnv();
    }

    public String getAppId() {
        return PolarisEnvProvider.getAppId();
    }

    public String getSpringApplicationName(ConfigurableEnvironment environment) {
        return environment.getProperty(PolarisConstant.SPRING_APPLICATION_NAME, String.class, PolarisConstant.UNKNOWN);
    }

    public String getProjectName(ConfigurableEnvironment environment) {
        String appId = getAppId();
        if (StringUtils.isNotEmpty(appId)) {
            return appId;
        }

        return getSpringApplicationName(environment);
    }

    public String getServerPropertiesPath() {
        return PolarisEnvProvider.getServerPropertiesPath();
    }

    public String getLogPath() {
        return PolarisEnvProvider.getLogPath();
    }

    public abstract String getName();
}