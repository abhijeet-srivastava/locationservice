package com.cvent.locationservice.resources;

import static com.cvent.locationservice.LocationServiceConstants.SERVICE_ROOT;
import static com.cvent.locationservice.LocationServiceConstants.VERSION_URI;
import static com.cvent.locationservice.LocationServiceConstants.LOCATIONSERVICE_RESOURCE;

import com.codahale.metrics.annotation.Timed;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.cvent.auth.AuthenticatorMethod;
import com.cvent.auth.Authority;
import com.cvent.auth.GrantedAPIKey;
import com.cvent.locationservice.model.Entity;
import com.cvent.locationservice.model.ImmutableComplexEntity;
import com.cvent.locationservice.model.ImmutableEntity;
import com.sun.jersey.api.core.HttpContext;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A resource containing specific endpoints to access the service.
 */
@Path(SERVICE_ROOT + VERSION_URI + LOCATIONSERVICE_RESOURCE)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LocationServiceResource {

    private static final Logger LOG = LoggerFactory.getLogger(LocationServiceResource.class);

    /**
     * Get Operation
     *
     * @param grantedAPIKey
     * @param uriInfo
     * @return String
     */
    @GET
    @Timed
    @ExceptionMetered
    public Response getEntity(
            @Authority(methods = {
                AuthenticatorMethod.BEARER, AuthenticatorMethod.API_KEY
            }) GrantedAPIKey grantedAPIKey,
            @Context UriInfo uriInfo) {

        LOG.info("getEntity() request.");

        return Response.ok(ImmutableEntity.builder()
                .field("foo")
                .anotherField("another")
                .complexEntity(ImmutableComplexEntity.of(1))
                .build()
        ).build();
    }

    /**
     * Post Operation
     *
     * @param grantedAPIKey
     * @param uriInfo
     * @param context
     * @param incomingEntity
     * @return Response
     */
    @POST
    @Timed
    @ExceptionMetered
    public Response createEntity(
            @Authority(methods = {
                AuthenticatorMethod.BEARER, AuthenticatorMethod.API_KEY
            }) GrantedAPIKey grantedAPIKey,
            @Context UriInfo uriInfo,
            @Context HttpContext context,
            @Valid @NotNull Entity incomingEntity) {

        LOG.info("createEntity() request.");

        return Response.status(HttpStatus.CREATED_201).build();
    }
}
