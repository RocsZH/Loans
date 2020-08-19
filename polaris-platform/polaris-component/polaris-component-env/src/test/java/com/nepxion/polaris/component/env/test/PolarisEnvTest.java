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
import com.nepxion.polaris.component.env.constant.PolarisEnvConstant;
import com.nepxion.polaris.component.env.context.PolarisEnvProcessor;
import com.nepxion.polaris.component.env.context.PolarisEnvProvider;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PolarisTestApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PolarisEnvTest {
    private static final Logger LOG = LoggerFactory.getLogger(PolarisEnvTest.class);

    private static long startTime;

    @Autowired
    private ConfigurableEnvironment environment;

    private static Properties properties;

    @BeforeClass
    public static void beforeTest() {
        startTime = System.currentTimeMillis();

        // System.setProperty("test.a", "AAA");
        // System.setProperty("test.b", "${test.a}-BBB");
        // System.setProperty("test.c", "${test.b}-CCC");
        // System.setProperty("test.d", "${test.c}-DDD");

        String path = PolarisEnvConstant.META_INF_PATH + "test" + "-" + PolarisConstant.COMMON + "." + PolarisConstant.PROPERTIES_FORMAT;

        PolarisEnvProcessor polarisEnvProcessor = new PolarisEnvProcessor() {
            @Override
            public String getName() {
                return null;
            }
        };

        try {
            properties = polarisEnvProcessor.processProperties(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void afterTest() {
        System.out.println("System Property      : test.a = " + System.getProperty("test.a"));
        System.out.println("System Property      : test.b = " + System.getProperty("test.b"));
        System.out.println("System Property      : test.c = " + System.getProperty("test.c"));
        System.out.println("System Property      : test.d = " + System.getProperty("test.d"));

        LOG.info("* Finished automation test in {} seconds", (System.currentTimeMillis() - startTime) / 1000);
    }

    @Test
    public void test1() {
        // 占位符测试，占位符内外可以合并
        Map<String, Object> propertySource = new HashMap<String, Object>();
        environment.getPropertySources().addLast(new MapPropertySource("polarisPropertySource", propertySource));

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

                    // 占位符转换后，塞回System.setProperty，保证environment.getProperty能取到该值
                    String newValue = environment.getProperty(key);
                    System.setProperty(key, newValue);

                    LOG.info("* Env parameter : {} = {}", key, newValue);
                } else {
                    LOG.info("* Env parameter : {} = {}", key, value);
                }
            } else {
                LOG.info("* Env parameter : {} = {}", key, value);
            }
        }

        System.out.println("Environment Property : test.a = " + environment.getProperty("test.a"));
        System.out.println("Environment Property : test.b = " + environment.getProperty("test.b"));
        System.out.println("Environment Property : test.c = " + environment.getProperty("test.c"));
        System.out.println("Environment Property : test.d = " + environment.getProperty("test.d"));
    }

    // @Test
    public void test2() {
        // 占位符测试，占位符内外可以合并
        // 该方式无法读取application.properties定义的占位符
        MutablePropertySources propertySources = new MutablePropertySources();
        propertySources.addFirst(new PropertiesPropertySource("systemProperties", System.getProperties()));
        propertySources.addLast(new PropertiesPropertySource("polarisProperties", properties));
        ConfigurablePropertyResolver propertyResolver = new PropertySourcesPropertyResolver(propertySources);

        System.out.println("Environment Property : test.a = " + propertyResolver.getProperty("test.a"));
        System.out.println("Environment Property : test.b = " + propertyResolver.getProperty("test.b"));
        System.out.println("Environment Property : test.c = " + propertyResolver.getProperty("test.c"));
        System.out.println("Environment Property : test.d = " + propertyResolver.getProperty("test.d"));
    }

    // @Test
    public void test3() {
        System.out.println(processValue(environment, "spring.cloud.nacos.discovery.server-addr", "nacos-fat[-%zone%].nepxion.com"));
    }

    public static final String ZONE_EXPRESSION = "%" + PolarisEnvConstant.ZONE_NAME + "%";

    protected String processValue(ConfigurableEnvironment environment, String key, String value) {
        String domainExpression = value;
        String zoneExpression = ZONE_EXPRESSION;
        String zone = PolarisEnvProvider.getZone();

        return processDomainPlaceholder(domainExpression, zoneExpression, zone);
    }

    // 域名占位处理
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
}