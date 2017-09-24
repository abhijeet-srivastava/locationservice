package com.cvent.locationservice.health;

import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheck.Result;

/**
 * Simple service check, triggered by GET request to http://{host}:{adminPort}/healthcheck.
 */
public class  LocationServiceHealthCheck extends HealthCheck {

    /**
     * Create an instance of this healthcheck
     */
    public  LocationServiceHealthCheck() {
        super();
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
