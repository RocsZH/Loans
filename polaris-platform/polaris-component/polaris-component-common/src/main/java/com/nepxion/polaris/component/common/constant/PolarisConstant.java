package com.nepxion.polaris.component.common.constant;

import com.nepxion.discovery.common.constant.DiscoveryConstant;
import com.nepxion.polaris.component.common.util.PolarisVersion;

public class PolarisConstant extends DiscoveryConstant {
    public static final String POLARIS_NAME = "Polaris";

    public static final String POLARIS_VERSION_NAME = "polaris.version";
    public static final String POLARIS_VERSION_VALUE = "1.0.0";

    public static final String APOLLO_CONFIG_NAME = "apollo-config";
    public static final String APOLLO_VERSION_NAME = "polaris.apollo.version";
    public static final String APOLLO_VERSION_VALUE = PolarisVersion.getVersion("com.ctrip.framework.apollo.ConfigService");

    public static final String NACOS_DISCOVERY_NAME = "nacos-discovery";
    public static final String NACOS_CONFIG_NAME = "nacos-config";
    public static final String NACOS_VERSION_NAME = "polaris.nacos.version";
    public static final String NACOS_VERSION_VALUE = PolarisVersion.getNacosVersion();
    public static final String NACOS_DATA_ID = "nacos.dataId";

    public static final String EUREKA_DISCOVERY_NAME = "eureka-discovery";
    public static final String EUREKA_VERSION_NAME = "polaris.eureka.version";
    public static final String EUREKA_VERSION_VALUE = PolarisVersion.getVersion("org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient");

    public static final String CONSUL_DISCOVERY_NAME = "consul-discovery";
    public static final String CONSUL_VERSION_NAME = "polaris.consul.version";
    public static final String CONSUL_VERSION_VALUE = PolarisVersion.getVersion("org.springframework.cloud.consul.ConsulProperties");

    public static final String SENTINEL_NAME = "sentinel";
    public static final String SENTINEL_CONFIG_NAME = "sentinel-config";
    public static final String SENTINEL_VERSION_NAME = "polaris.sentinel.version";
    public static final String SENTINEL_VERSION_VALUE = PolarisVersion.getVersion("com.alibaba.csp.sentinel.SphU");
    public static final String SENTINEL_PROJECT_NAME = "project.name";

    public static final String SKY_WALKING_AGENT_VERSION_NAME = "polaris.skywalking.agent.version";

    public static final String SKYWALKING_NAME = "skywalking";
    public static final String SKYWALKING_SENTINEL_NAME = "skywalking-sentinel";

    public static final String JAEGER_NAME = "jaeger";
    public static final String JAEGER_SENTINEL_NAME = "jaeger-sentinel";

    public static final String GRAY_CONSOLE_NAME = "gray-console";

    public static final String POLARIS_SERVICE_NAME = "polaris-service";
    public static final String POLARIS_GATEWAY_NAME = "polaris-gateway";
    public static final String POLARIS_ZUUL_NAME = "polaris-zuul";
    public static final String POLARIS_CONSOLE_NAME = "polaris-console";

    public static final String CODES_NAME = "polaris.codes";
    public static final String CODES_VALUE = "https://github.com/Nepxion/Polaris";

    public static final String DOCS_NAME = "polaris.docs";
    public static final String DOCS_VALUE = "http://www.nepxion.com";

    public static final String APPLICATION = "application";
    public static final String ZONE = "zone";
    public static final String COMMON = "common";

    public static final String SERVER_PROPERTIES_PATH_WINDOWS = "C:/opt/settings/server.properties";
    public static final String SERVER_PROPERTIES_PATH_LINUX = "/opt/settings/server.properties";
    public static final String LOG_PATH_WINDOWS = "C:/opt/logs/";
    public static final String LOG_PATH_LINUX = "/opt/logs/";

    public static final String META_INF_PATH = "classpath:/META-INF/";

    public static final String BIZ_TRACE_ID = "biz-trace-id";
}