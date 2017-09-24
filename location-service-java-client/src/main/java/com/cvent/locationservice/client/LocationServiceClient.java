package com.cvent.locationservice.client;

import static com.cvent.locationservice.LocationServiceConstants.LOCATIONSERVICE_RESOURCE;
import static com.cvent.locationservice.LocationServiceConstants.CLIENT_ROOT;
import static com.cvent.locationservice.LocationServiceConstants.VERSION_URI;

import retrofit2.Call;
import retrofit2.http.GET;
import okhttp3.ResponseBody;

import com.cvent.locationservice.model.Entity;

/**
 * A retrofit client used to interface with this service
 */
public interface LocationServiceClient {

    /**
     * GET a resource
     */
    @GET(CLIENT_ROOT + VERSION_URI + LOCATIONSERVICE_RESOURCE)
    Call<Entity> getEntity();

    /**
     * GET a resource with full response body
     */
    @GET(CLIENT_ROOT + VERSION_URI + LOCATIONSERVICE_RESOURCE)
    Call<ResponseBody> getEntityResponse();
}
