package com.cvent.locationservice;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.cvent.locationservice.model.Entity;
import com.cvent.locationservice.client.LocationServiceClient;
import retrofit2.Response;

/**
 * Integration test for the LocationServiceService
 */
public class LocationServiceEndpointTestIT extends BaseClientTestIT {

    private LocationServiceClient client;

    public LocationServiceEndpointTestIT() {

    }

    @Before
    public void initialize() {
        client = createClient(LocationServiceClient.class);
    }

    @Test
    public void getEntity() throws Exception {
        Response<Entity> call = client.getEntity().execute();
        assertNotNull(call.body());
    }
}
