package com.nepxion.polaris.component.env.test;

import java.util.Properties;

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
    public void test() {
        System.out.println(environment.getProperty("spring.application.name"));

        // System.setProperty("test.a", "A");
        // System.setProperty("test.b", "B");
        // System.setProperty("test.b", "${test.a}-B");
        // System.setProperty("test.c", "${test.a}-C");

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
        // test.a=a
        // test.b=${test.a}-b
        // test.c=${test.b}-c
        MutablePropertySources propertySources = new MutablePropertySources();
        propertySources.addFirst(new PropertiesPropertySource("systemProperties", System.getProperties()));
        propertySources.addLast(new PropertiesPropertySource("polarisProperties", properties));

        ConfigurablePropertyResolver propertyResolver = new PropertySourcesPropertyResolver(propertySources);

        System.out.println(propertyResolver.getProperty("test.a"));
        System.out.println(propertyResolver.getProperty("test.b"));
        System.out.println(propertyResolver.getProperty("test.c"));
    }
}