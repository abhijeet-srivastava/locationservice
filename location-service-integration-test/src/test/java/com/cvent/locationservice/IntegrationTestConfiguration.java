package com.cvent.locationservice;

import com.cvent.test.integration.ITConfiguration;
import javax.validation.constraints.NotNull;
import com.cvent.test.integration.OverrideWithLocalService;

/**
 * Configuration for the LocationServiceService Integration Tests
 */
public class IntegrationTestConfiguration extends ITConfiguration {
    @NotNull
    private String apiKey;

    @OverrideWithLocalService
    @NotNull
    private String serviceEndpoint;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getServiceEndpoint() {
        return serviceEndpoint;
    }

    public void setServiceEndpoint(String serviceEndpoint) {
        this.serviceEndpoint = serviceEndpoint;
    }

}
