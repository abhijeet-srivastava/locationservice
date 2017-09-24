package com.cvent.locationservice;

import static com.cvent.test.retrofit.Retrofit2TestHelper.createRetrofitClient;
import com.cvent.test.integration.BaseIT;

/**
 * Base Integration test for the LocationServiceService
 */
public class BaseClientTestIT extends BaseIT<IntegrationTestConfiguration> {

    protected <T> T createClient(Class<T> clazz) {
        return createRetrofitClient(clazz, this.getConfiguration().getServiceEndpoint());
    }

    protected <T> T createClient(Class<T> clazz, String apiKey) {
        return createRetrofitClient(clazz, this.getConfiguration().getServiceEndpoint(),
                this.getConfiguration().getApiKey());
    }

    public BaseClientTestIT() {
        super(IntegrationTestConfiguration.class);
    }

}
