package com.nepxion.polaris.component.env.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.ConfigurablePropertyResolver;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySourcesPropertyResolver;
import org.springframework.test.context.junit4.SpringRunner;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.processor.PolarisEnvProcessor;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PolarisTestApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PolarisEnvTest {
    private static final Logger LOG = LoggerFactory.getLogger(PolarisEnvTest.class);

    private static long startTime;

    @Autowired
    private ConfigurableEnvironment environment;

    @BeforeClass
    public static void beforeTest() {
        startTime = System.currentTimeMillis();
    }

    @AfterClass
    public static void afterTest() {
        LOG.info("* Finished automation test in {} seconds", (System.currentTimeMillis() - startTime) / 1000);
    }

    @Test
    public void test1() {
        // System.setProperty("test.a", "A");
        // System.setProperty("test.b", "${test.a}-B");
        // System.setProperty("test.c", "${test.b}-C");
        // System.setProperty("test.d", "${test.c}-D");

        // 占位符测试。如果System.setProperty已设置，忽略内置默认的配置项，占位符内外可以合并
        Map<String, Object> propertySource = new HashMap<String, Object>();
        environment.getPropertySources().addLast(new MapPropertySource(PolarisConstant.POLARIS_PROPERTY_SOURCE, propertySource));

        String path = PolarisConstant.META_INF_PATH + "test" + "-" + PolarisConstant.COMMON + "." + PolarisConstant.PROPERTIES_FORMAT;

        PolarisEnvProcessor polarisEnvProcessor = new PolarisEnvProcessor() {
            @Override
            public String getName() {
                return null;
            }
        };

        Properties properties = null;
        try {
            properties = polarisEnvProcessor.processProperties(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String key : properties.stringPropertyNames()) {
            if (environment.getProperty(key) == null && System.getProperty(key) == null && System.getenv(key.toUpperCase()) == null) {
                String value = properties.getProperty(key);

                System.setProperty(key, value);
            }
        }

        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            if (environment.getProperty(key) == null && System.getProperty(key) == null && System.getenv(key.toUpperCase()) == null) {
                if (StringUtils.isNotBlank(value) && StringUtils.contains(value, "${") && StringUtils.contains(value, "}") && StringUtils.indexOf(value, "}") - StringUtils.indexOf(value, "${") >= 1) {
                    propertySource.put(key, value);

                    // 占位符转换后，塞回System.setProperty，保证environment.getProperty和System.getProperty都能取到该值
                    String newValue = environment.getProperty(key);
                    System.setProperty(key, newValue);

                    LOG.info("* Env parameter : {} = {}", key, newValue);
                }
            } else {
                LOG.info("* Env parameter : {} = {}", key, value);
            }
        }

        System.out.println(environment.getProperty("test.a"));
        System.out.println(environment.getProperty("test.b"));
        System.out.println(environment.getProperty("test.c"));
        System.out.println(environment.getProperty("test.d"));

        System.out.println(System.getProperty("test.a"));
        System.out.println(System.getProperty("test.b"));
        System.out.println(System.getProperty("test.c"));
        System.out.println(System.getProperty("test.d"));
    }

    // @Test
    public void test2() {
        // System.setProperty("test.a", "A");
        // System.setProperty("test.b", "${test.a}-B");
        // System.setProperty("test.c", "${test.b}-C");
        // System.setProperty("test.d", "${test.c}-D");

        String path = PolarisConstant.META_INF_PATH + "test" + "-" + PolarisConstant.COMMON + "." + PolarisConstant.PROPERTIES_FORMAT;

        PolarisEnvProcessor polarisEnvProcessor = new PolarisEnvProcessor() {
            @Override
            public String getName() {
                return null;
            }
        };

        Properties properties = null;
        try {
            properties = polarisEnvProcessor.processProperties(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 占位符测试。如果System.setProperty已设置，忽略内置默认的配置项，占位符内外可以合并
        MutablePropertySources propertySources = new MutablePropertySources();
        propertySources.addFirst(new PropertiesPropertySource("systemProperties", System.getProperties()));
        propertySources.addLast(new PropertiesPropertySource("polarisProperties", properties));

        ConfigurablePropertyResolver propertyResolver = new PropertySourcesPropertyResolver(propertySources);

        System.out.println(propertyResolver.getProperty("test.a"));
        System.out.println(propertyResolver.getProperty("test.b"));
        System.out.println(propertyResolver.getProperty("test.c"));
        System.out.println(propertyResolver.getProperty("test.d"));

        System.out.println(System.getProperty("test.a"));
        System.out.println(System.getProperty("test.b"));
        System.out.println(System.getProperty("test.c"));
        System.out.println(System.getProperty("test.d"));
    }
}