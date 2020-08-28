package com.nepxion.polaris.component.env.context;

import java.io.IOException;
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
        String env = getEnv();

        boolean isEnvLogShown = isEnvLogShown();
        if (isEnvLogShown) {
            LOG.info("Initialize {} {} env...", name, env);
        } else {
            System.out.println("Initialize " + name + " " + env + " env...");
        }

        processEnvProperties(environment, name, PolarisConstant.COMMON, true);
        processEnvProperties(environment, name, env, false);
    }

    public void processEnvProperties(ConfigurableEnvironment environment, String name, String env, boolean canMissing) throws IOException {
        String path = PolarisEnvConstant.META_INF_PATH + name + "-" + env + "." + PolarisConstant.PROPERTIES_FORMAT;

        try {
            processProperties(environment, env, path);
        } catch (IOException e) {
            boolean isEnvLogShown = isEnvLogShown();
            if (canMissing) {
                if (isEnvLogShown) {
                    LOG.warn("* Not found {}, ignore to process...", path);
                } else {
                    System.out.println("* Not found " + path + ", ignore to process...");
                }
            } else {
                if (isEnvLogShown) {
                    LOG.error("* Not found {}, failed to process...", path);
                } else {
                    System.out.println("* Not found " + path + ", failed to process...");
                }

                throw e;
            }
        }
    }

    public void processProperties(ConfigurableEnvironment environment, String env, String path) throws IOException {
        Properties properties = processProperties(path);

        boolean isEnvLogShown = isEnvLogShown();
        for (String key : properties.stringPropertyNames()) {
            // 如果已经设置，则尊重已经设置的值
            if (environment.getProperty(key) == null && System.getProperty(key) == null && System.getenv(key.toUpperCase()) == null) {
                String value = properties.getProperty(key);

                value = processValue(environment, key, value);

                if (isEnvLogShown) {
                    LOG.info("* Env[{}] parameter : {} = {}", env, key, value);
                } else {
                    System.out.println("* Env[" + env + "] parameter : " + key + " = " + value);
                }

                System.setProperty(key, value);
            } else {
                if (isEnvLogShown) {
                    LOG.info("* Env[{}] parameter : {} has been set outside", env, key);
                } else {
                    System.out.println("* Env[" + env + "] parameter : " + key + " has been set outside");
                }
            }
        }
    }

    public Properties processProperties(String path) throws IOException {
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