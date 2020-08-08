package com.nepxion.polaris.component.skywalking.gray.adapter;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.nepxion.discovery.plugin.strategy.adapter.DefaultStrategyTracerAdapter;
import com.nepxion.polaris.component.common.constant.PolarisConstant;

public class SkywalkingStrategyTracerAdapter extends DefaultStrategyTracerAdapter {
    @Override
    public Map<String, String> getCustomizationMap() {
        Map<String, String> customizationMap = new HashMap<String, String>();
        customizationMap.put(PolarisConstant.BIZ_TRACE_ID, StringUtils.isNotEmpty(strategyContextHolder.getHeader(PolarisConstant.BIZ_TRACE_ID)) ? strategyContextHolder.getHeader(PolarisConstant.BIZ_TRACE_ID) : StringUtils.EMPTY);

        return customizationMap;
    }
}