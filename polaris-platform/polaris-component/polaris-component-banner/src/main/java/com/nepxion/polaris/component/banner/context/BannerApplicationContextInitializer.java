package com.nepxion.polaris.component.banner.context;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringBootVersion;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.Ordered;

import com.nepxion.banner.BannerConstant;
import com.nepxion.banner.Description;
import com.nepxion.banner.DescriptionBanner;
import com.nepxion.banner.LogoBanner;
import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.context.PolarisEnvProvider;
import com.taobao.text.Color;

public class BannerApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (!(applicationContext instanceof AnnotationConfigApplicationContext)) {
            LogoBanner logoBanner = new LogoBanner(BannerApplicationContextInitializer.class, "/logo.txt", "Welcome to " + PolarisConstant.POLARIS_NAME, 7, 5, new Color[] { Color.red, Color.green, Color.cyan, Color.blue, Color.yellow, Color.magenta, Color.red }, true);

            show(applicationContext, logoBanner);

            System.setProperty(BannerConstant.BANNER_SHOWN, "false");
        }
    }

    private void show(ConfigurableApplicationContext applicationContext, LogoBanner logoBanner) {
        String bannerShown = System.getProperty(BannerConstant.BANNER_SHOWN, "true");
        if (!Boolean.valueOf(bannerShown)) {
            return;
        }

        System.out.println("");
        String bannerShownAnsiMode = System.getProperty(BannerConstant.BANNER_SHOWN_ANSI_MODE, "false");
        if (Boolean.valueOf(bannerShownAnsiMode)) {
            System.out.println(logoBanner.getBanner());
        } else {
            System.out.println(logoBanner.getPlainBanner());
        }

        List<Description> descriptions = new ArrayList<Description>();
        descriptions.add(new Description(PolarisConstant.SPRING_APPLICATION_NAME + ":", applicationContext.getEnvironment().getProperty(PolarisConstant.SPRING_APPLICATION_NAME), 0, 1));
        descriptions.add(new Description(PolarisConstant.SPRING_APPLICATION_TYPE + ":", StringUtils.isNotEmpty(applicationContext.getEnvironment().getProperty(PolarisConstant.SPRING_APPLICATION_TYPE)) ? applicationContext.getEnvironment().getProperty(PolarisConstant.SPRING_APPLICATION_TYPE) : PolarisConstant.APPLICATION, 0, 1));
        String appId = PolarisEnvProvider.getAppId();
        if (StringUtils.isNotEmpty(appId)) {
            descriptions.add(new Description(PolarisConstant.APP_ID + ":", appId, 0, 1));
        }
        descriptions.add(new Description(PolarisConstant.SPRING_APPLICATION_DISCOVERY_VERSION + ":", PolarisConstant.DISCOVERY_VERSION, 0, 1));
        String discoveryAgentVersion = System.getProperty(PolarisConstant.SPRING_APPLICATION_DISCOVERY_AGENT_VERSION);
        if (StringUtils.isNotEmpty(discoveryAgentVersion)) {
            descriptions.add(new Description(PolarisConstant.SPRING_APPLICATION_DISCOVERY_AGENT_VERSION + ":", discoveryAgentVersion, 0, 1));
        }
        descriptions.add(new Description(PolarisConstant.SPRING_BOOT_VERSION + ":", SpringBootVersion.getVersion(), 0, 1));

        descriptions.add(new Description(PolarisConstant.POLARIS_VERSION_NAME + ":", PolarisConstant.POLARIS_VERSION_VALUE, 0, 1));
        String rootDomain = PolarisEnvProvider.getRootDomain();
        if (StringUtils.isNotEmpty(rootDomain)) {
            descriptions.add(new Description(PolarisConstant.POLARIS_ROOT_DOMIAN_NAME + ":", rootDomain, 0, 1));
        }
        String zone = PolarisEnvProvider.getZone();
        if (StringUtils.isNotEmpty(zone)) {
            descriptions.add(new Description(PolarisConstant.POLARIS_ZONE_NAME + ":", zone, 0, 1));
        }
        String env = PolarisEnvProvider.getEnv();
        if (StringUtils.isNotEmpty(env)) {
            descriptions.add(new Description(PolarisConstant.POLARIS_ENV_NAME + ":", env, 0, 1));
        }
        descriptions.add(new Description(PolarisConstant.CODES_NAME + ":", PolarisConstant.CODES_VALUE, 0, 1));
        descriptions.add(new Description(PolarisConstant.DOCS_NAME + ":", PolarisConstant.DOCS_VALUE, 0, 1));

        if (StringUtils.isNotEmpty(PolarisConstant.APOLLO_VERSION_VALUE)) {
            descriptions.add(new Description(PolarisConstant.APOLLO_VERSION_NAME + ":", PolarisConstant.APOLLO_VERSION_VALUE, 0, 1));
        }
        if (StringUtils.isNotEmpty(PolarisConstant.NACOS_VERSION_VALUE)) {
            descriptions.add(new Description(PolarisConstant.NACOS_VERSION_NAME + ":", PolarisConstant.NACOS_VERSION_VALUE, 0, 1));
        }
        if (StringUtils.isNotEmpty(PolarisConstant.EUREKA_VERSION_VALUE)) {
            descriptions.add(new Description(PolarisConstant.EUREKA_VERSION_NAME + ":", PolarisConstant.EUREKA_VERSION_VALUE, 0, 1));
        }
        if (StringUtils.isNotEmpty(PolarisConstant.CONSUL_VERSION_VALUE)) {
            descriptions.add(new Description(PolarisConstant.CONSUL_VERSION_NAME + ":", PolarisConstant.CONSUL_VERSION_VALUE, 0, 1));
        }
        if (StringUtils.isNotEmpty(PolarisConstant.ZOOKEEPER_VERSION_VALUE)) {
            descriptions.add(new Description(PolarisConstant.ZOOKEEPER_VERSION_NAME + ":", PolarisConstant.ZOOKEEPER_VERSION_VALUE, 0, 1));
        }
        if (StringUtils.isNotEmpty(PolarisConstant.SENTINEL_VERSION_VALUE)) {
            descriptions.add(new Description(PolarisConstant.SENTINEL_VERSION_NAME + ":", PolarisConstant.SENTINEL_VERSION_VALUE, 0, 1));
        }
        if (StringUtils.isNotEmpty(PolarisConstant.JAEGER_VERSION_VALUE)) {
            descriptions.add(new Description(PolarisConstant.JAEGER_VERSION_NAME + ":", PolarisConstant.JAEGER_VERSION_VALUE, 0, 1));
        }
        String skywalkingAgentVersion = System.getProperty(PolarisConstant.SKY_WALKING_AGENT_VERSION_NAME);
        if (StringUtils.isNotEmpty(skywalkingAgentVersion)) {
            descriptions.add(new Description(PolarisConstant.SKY_WALKING_AGENT_VERSION_NAME + ":", skywalkingAgentVersion, 0, 1));
        }

        DescriptionBanner descriptionBanner = new DescriptionBanner();
        System.out.println(descriptionBanner.getBanner(descriptions));
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}