package com.nepxion.polaris.component.apollo.config.provider;

import com.ctrip.framework.foundation.Foundation;
import com.nepxion.polaris.component.env.provider.PolarisAppIdProvider;

public class ApolloAppIdProvider implements PolarisAppIdProvider {
    @Override
    public String getAppId() {
        return Foundation.app().getAppId();
    }
}