package com.cvent.locationservice;

import com.cvent.locationservice.dao.PersonDAO;
import com.cvent.locationservice.health.LocationServiceHealthCheck;
import com.cvent.locationservice.resources.LocationServiceResource;


import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import io.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class to setup and initialize the service.
 */
public class LocationServiceServiceApplication
    extends Application<LocationServiceServiceConfiguration> {

    public static final String APPLICATION_NAME = "locationservice-service";

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationServiceServiceApplication.class);

    

    @Override
    public String getName() {
        return APPLICATION_NAME;
    }

    @Override
    public void initialize(Bootstrap<LocationServiceServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/api", "/raml", "index.html", "docs"));
    }

    @Override
    public void run(LocationServiceServiceConfiguration config, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "h2");
        final PersonDAO personDAO = jdbi.onDemand(PersonDAO.class);
        

        //setup resources
        environment.jersey().register(new LocationServiceResource(personDAO));

        //setup healthchecks
        environment.healthChecks().register(this.getName(), new LocationServiceHealthCheck());

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
