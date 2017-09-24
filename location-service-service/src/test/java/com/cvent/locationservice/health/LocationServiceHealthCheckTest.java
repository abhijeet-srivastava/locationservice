package com.cvent.locationservice.health;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.codahale.metrics.health.HealthCheck.Result;

/**
 * Unit tests for the LocationServiceService Health Check
 */
public class LocationServiceHealthCheckTest {
    @Test
    public void check() throws Exception {
        LocationServiceHealthCheck check = new LocationServiceHealthCheck();
        Result result = check.check();
        assertTrue(result.isHealthy());
    }
}