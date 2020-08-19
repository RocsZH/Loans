package com.nepxion.polaris.component.zookeeper.discovery.context;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.context.PolarisEnvPostProcessor;

public class ZookeeperEnvProcessor extends PolarisEnvPostProcessor {
    @Override
    public String getName() {
        return PolarisConstant.ZOOKEEPER_DISCOVERY_NAME;
    }
}