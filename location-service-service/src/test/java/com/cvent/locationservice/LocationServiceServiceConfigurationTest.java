package com.cvent.locationservice;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Unit tests for the LocationServiceServiceConfiguration
 */
public class LocationServiceServiceConfigurationTest {

    @Test
    public void constructor() {
        LocationServiceServiceConfiguration configs = new LocationServiceServiceConfiguration();
        assertNotNull(configs);
    }
}