package com.nepxion.polaris.component.env.processor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.nepxion.polaris.component.common.constant.PolarisConstant;

public class PolarisEnvProcessor {
    public String getEnv() throws Exception {
        String env = System.getProperty(PolarisConstant.ENV);
        if (!StringUtils.isBlank(env)) {
            env = env.trim();
        } else {
            env = System.getenv(PolarisConstant.ENV.toUpperCase());
            if (!StringUtils.isBlank(env)) {
                env = env.trim();
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

                env = properties.getProperty(PolarisConstant.ENV);
                if (!StringUtils.isBlank(env)) {
                    env = env.trim();
                }
            }
        }

        return env;
    }

    public void loadEnvProperties(String componentName, String env) throws Exception {
        String path = PolarisConstant.META_INF_PATH + componentName + "-" + env + "." + PolarisConstant.PROPERTIES_FORMAT;

        loadProperties(path);
    }

    public void loadConfigProperties(String componentName) throws Exception {
        String path = PolarisConstant.META_INF_PATH + componentName + "-" + PolarisConstant.CONFIG + "." + PolarisConstant.PROPERTIES_FORMAT;

        loadProperties(path);
    }

    public void loadProperties(String path) throws Exception {
        Properties properties = initializeProperties(path);

        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);

            System.setProperty(key, value);
        }
    }

    public Properties initializeProperties(String path) throws Exception {
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

    public String getServerPropertiesPath() {
        return SystemUtils.IS_OS_WINDOWS ? PolarisConstant.SERVER_PROPERTIES_PATH_WINDOWS : PolarisConstant.SERVER_PROPERTIES_PATH_LINUX;
    }

    public String getLogPath() {
        return SystemUtils.IS_OS_WINDOWS ? PolarisConstant.LOG_PATH_WINDOWS : PolarisConstant.LOG_PATH_LINUX;
    }
}