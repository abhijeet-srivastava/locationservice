package com.cvent.locationservice.resources;

import static org.junit.Assert.assertNotNull;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.junit.Before;
import org.junit.Test;

import com.cvent.locationservice.model.Entity;
import com.cvent.auth.GrantedAPIKey;
import com.sun.jersey.api.core.HttpContext;

/**
 * Unit tests for the LocationServiceService
 */
public class LocationServiceResourceTest {

    private LocationServiceResource resource;

    @Before
    public void initialize() throws Exception {
        resource = new LocationServiceResource();
    }

    @Test
    public void getEntity() {
        GrantedAPIKey grantedAPIKey = null;
        UriInfo uriInfo = null;
        Response response = resource.getEntity(grantedAPIKey, uriInfo);
        assertNotNull(response);
    }

    @Test
    public void createEntity() {
        GrantedAPIKey grantedAPIKey = null;
        UriInfo uriInfo = null;
        HttpContext context = null;
        Entity incomingEntity = null;
        Response response = resource.createEntity(grantedAPIKey, uriInfo, context, incomingEntity);
        assertNotNull(response);
    }

}
