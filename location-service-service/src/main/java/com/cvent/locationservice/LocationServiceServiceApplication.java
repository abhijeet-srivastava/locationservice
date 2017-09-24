package com.cvent.locationservice;

import com.cvent.auth.CventAuthenticatedApplication;
import com.cvent.locationservice.health.LocationServiceHealthCheck;
import com.cvent.locationservice.resources.LocationServiceResource;
import com.cvent.healthcheck.ServiceDiscoveryClientHealthCheckGenerator;


import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class to setup and initialize the service.
 */
public class LocationServiceServiceApplication
    extends CventAuthenticatedApplication<LocationServiceServiceConfiguration> {

    public static final String APPLICATION_NAME = "locationservice-service";

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationServiceServiceApplication.class);

    

    @Override
    public String getName() {
        return APPLICATION_NAME;
    }

    @Override
    public void initialize(Bootstrap<LocationServiceServiceConfiguration> bootstrap) {
        super.initialize(bootstrap);
        bootstrap.addBundle(new AssetsBundle("/api", "/raml", "index.html", "docs"));
    }

    @Override
    public void run(LocationServiceServiceConfiguration config, Environment environment) throws Exception {
        super.run(config, environment);

        

        //setup resources
        environment.jersey().register(new LocationServiceResource());

        //setup healthchecks
        environment.healthChecks().register(this.getName(), new LocationServiceHealthCheck());
        ServiceDiscoveryClientHealthCheckGenerator.registerClientHealthChecks(config, environment);

        LOGGER.info("All resources added for {}", getName());
    }

    /**
     * Launch LocationServiceServiceApplication
     *
     * @param args args passed to this service
     * @throws Exception thrown if there are errors launching service
     */
    public static void main(String[] args) throws Exception {
        new LocationServiceServiceApplication().run(args);
    }
}
