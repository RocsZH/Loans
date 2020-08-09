package com.nepxion.polaris.component.banner.context;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nepxion.banner.BannerConstant;
import com.nepxion.banner.Description;
import com.nepxion.banner.DescriptionBanner;
import com.nepxion.banner.LogoBanner;
import com.nepxion.discovery.common.constant.DiscoveryConstant;
import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.taobao.text.Color;

public class BannerApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (!(applicationContext instanceof AnnotationConfigApplicationContext)) {
            LogoBanner logoBanner = new LogoBanner(BannerApplicationContextInitializer.class, "/logo.txt", "Welcome to " + PolarisConstant.POLARIS_NAME, 7, 5, new Color[] { Color.red, Color.green, Color.cyan, Color.blue, Color.yellow, Color.magenta, Color.red }, true);

            show(logoBanner);

            System.setProperty(BannerConstant.BANNER_SHOWN, "false");
        }
    }

    private void show(LogoBanner logoBanner) {
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

        String serverType = StringUtils.capitalize(System.getProperty(DiscoveryConstant.SPRING_APPLICATION_TYPE));

        List<Description> descriptions = new ArrayList<Description>();
        descriptions.add(new Description(PolarisConstant.SERVER + ":", PolarisConstant.POLARIS_NAME + " " + (StringUtils.isNotEmpty(serverType) ? serverType : PolarisConstant.APPLICATION), 0, 1));
        descriptions.add(new Description(PolarisConstant.VERSION + ":", PolarisConstant.POLARIS_VERSION_VALUE, 0, 1));
        descriptions.add(new Description(PolarisConstant.CODES + ":", PolarisConstant.CODES_VALUE, 0, 1));
        descriptions.add(new Description(PolarisConstant.DOCS + ":", PolarisConstant.DOCS_VALUE, 0, 1));

        DescriptionBanner descriptionBanner = new DescriptionBanner();
        System.out.println(descriptionBanner.getBanner(descriptions));
    }
}