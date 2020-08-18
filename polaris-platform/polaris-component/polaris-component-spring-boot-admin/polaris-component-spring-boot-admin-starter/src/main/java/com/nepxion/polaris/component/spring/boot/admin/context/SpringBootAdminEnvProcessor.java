package com.nepxion.polaris.component.spring.boot.admin.context;

import com.nepxion.polaris.component.common.constant.PolarisConstant;
import com.nepxion.polaris.component.env.context.PolarisEnvPostProcessor;

public class SpringBootAdminEnvProcessor extends PolarisEnvPostProcessor {
    @Override
    public String getName() {
        return PolarisConstant.SPRING_BOOT_ADMIN_NAME;
    }
}