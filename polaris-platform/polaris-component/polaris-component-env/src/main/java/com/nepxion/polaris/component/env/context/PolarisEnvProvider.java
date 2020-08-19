package com.nepxion.polaris.component.env.context;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nepxion.polaris.component.env.constant.PolarisEnvConstant;
import com.nepxion.polaris.component.env.entity.PolarisEnv;

public class PolarisEnvProvider {
    private static final Logger LOG = LoggerFactory.getLogger(PolarisEnvProvider.class);

    private static String env;
    private static String zone;
    private static String appId;

    static {
        initializeDomain();
        initializeEnv();
        initializeZone();
    }

    private static void initializeDomain() {
        // 如果已经设置，则尊重已经设置的值
        String rootDomain = PolarisEnvConstant.ROOT_DOMAIN_NAME;
        if (System.getProperty(rootDomain) == null && System.getenv(rootDomain.toUpperCase()) == null) {
            System.setProperty(rootDomain, PolarisEnvConstant.ROOT_DOMAIN_VALUE);
        }
    }

    private static void initializeEnv() {
        try {
            env = initializeContext(PolarisEnvConstant.ENV_NAME);
        } catch (Exception e) {
            LOG.error("Initialize env failed, use {} env as default", PolarisEnv.DEV.getEnv());
        }

        if (StringUtils.isBlank(env)) {
            env = PolarisEnv.DEV.getEnv();
        }
    }

    private static void initializeZone() {
        try {
            zone = initializeContext(PolarisEnvConstant.ZONE_NAME);
        } catch (Exception e) {
            LOG.error("Initialize zone failed, use no zone as default", PolarisEnv.DEV.getEnv());
        }
    }

    private static String initializeContext(String key) throws Exception {
        String value = System.getProperty(key);
        if (!StringUtils.isBlank(value)) {
            value = value.trim();
        } else {
            value = System.getenv(key.toUpperCase());
            if (!StringUtils.isBlank(value)) {
                value = value.trim();
            } else {
                Properties properties = new Properties();
                String path = getServerPropertiesPath();

                File file = new File(path);
                if (file.exists() && file.canRead()) {
                    FileInputStream inputStream = null;
                    InputStreamReader inputStreamReader = null;

                    try {
                        inputStream = new FileInputStream(file);
                        inputStreamReader = new InputStreamReader(inputStream);

                        properties.load(inputStreamReader);
                    } finally {
                        IOUtils.closeQuietly(inputStreamReader);
                        IOUtils.closeQuietly(inputStream);
                    }
                }

                value = properties.getProperty(key);
                if (!StringUtils.isBlank(value)) {
                    value = value.trim();
                }
            }
        }

        return value;
    }

    public static String getEnv() {
        return env;
    }

    public static String getZone() {
        return zone;
    }

    public static String getAppId() {
        return appId;
    }

    public static void setAppId(String appId) {
        PolarisEnvProvider.appId = appId;
    }

    public static String getServerPropertiesPath() {
        return SystemUtils.IS_OS_WINDOWS ? PolarisEnvConstant.SERVER_PROPERTIES_PATH_WINDOWS : PolarisEnvConstant.SERVER_PROPERTIES_PATH_LINUX;
    }

    public static String getLogPath() {
        return SystemUtils.IS_OS_WINDOWS ? PolarisEnvConstant.LOG_PATH_WINDOWS : PolarisEnvConstant.LOG_PATH_LINUX;
    }
}