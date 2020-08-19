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

public abstract class PolarisEnvProcessor {
    private static final Logger LOG = LoggerFactory.getLogger(PolarisEnvProcessor.class);

    public void process(ConfigurableEnvironment environment) throws Exception {
        String name = getName();

        processCommonProperties(environment, name);
        processEnvProperties(environment, name);
    }

    public void processCommonProperties(ConfigurableEnvironment environment, String name) throws Exception {
        String path = PolarisConstant.META_INF_PATH + name + "-" + PolarisConstant.COMMON + "." + PolarisConstant.PROPERTIES_FORMAT;

        processProperties(environment, path);
    }

    public void processEnvProperties(ConfigurableEnvironment environment, String name) throws Exception {
        String env = getEnv();
        String path = PolarisConstant.META_INF_PATH + name + "-" + env + "." + PolarisConstant.PROPERTIES_FORMAT;

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
                    LOG.info("* Env parameter : {} has been set", key);
                } else {
                    System.out.println("* Env parameter : " + key + " has been set");
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

    protected String processValue(ConfigurableEnvironment environment, String key, String value) {
        String zone = PolarisEnvProvider.getZone();

        return processDomainPlaceholder(value, PolarisConstant.ZONE_EXPRESSION, zone);
    }

    // 域名占位处理。占位格式为[-%zone%]
    // 1. 根据server.properties里配置的env和zone，动态解析和创建多活或者多云的域名
    // 2. 域名表达式domainExpression，样例：nacos-fat[-%zone%].nepxion.com，该域名格式为组件-环境-区域.根域，也可以用其它符号代替"-"
    // 3. 区域表达式zoneExpression，样例：[-%zone%]，zone表示用来区别多活、多云和SET单元化的域名后缀或者前缀
    @SuppressWarnings("deprecation")
    protected String processDomainPlaceholder(String domainExpression, String zoneExpression, String zone) {
        String domain = null;
        // 不符合域名表达式的配置项，不做处理直接返回
        if (StringUtils.isNotBlank(domainExpression) && StringUtils.contains(domainExpression, zoneExpression) && StringUtils.contains(domainExpression, "[") && StringUtils.contains(domainExpression, "]") && StringUtils.indexOf(domainExpression, "]") - StringUtils.indexOf(domainExpression, "[") >= zoneExpression.length()) {
            if (StringUtils.isNotBlank(zone)) {
                // 兼容低版本的commons-langs
                domain = StringUtils.replaceAll(domainExpression, zoneExpression, zone);
                domain = StringUtils.replace(domain, "[", StringUtils.EMPTY);
                domain = StringUtils.replace(domain, "]", StringUtils.EMPTY);
            } else {
                // 兼容低版本的commons-langs
                domain = StringUtils.replaceAll(domainExpression, "\\[\\S+\\]", StringUtils.EMPTY);
            }
        } else {
            domain = domainExpression;
        }

        return domain;
    }

    protected boolean isEnvLogShown() {
        return true;
    }

    public String getEnv() {
        return PolarisEnvProvider.getEnv();
    }

    public String getZone() {
        return PolarisEnvProvider.getZone();
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