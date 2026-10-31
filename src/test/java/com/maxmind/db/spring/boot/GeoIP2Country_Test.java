package com.maxmind.db.spring.boot;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CountryResponse;
import org.junit.Test;

import java.io.File;
import java.net.InetAddress;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/** Exercises a lookup against MaxMind's pinned synthetic test database. */
public class GeoIP2Country_Test {

    @Test
    public void testName() throws Exception {
        File database = new File("target/geoip-test-data/GeoIP2-Country-Test.mmdb");
        try (DatabaseReader reader = new DatabaseReader.Builder(database).build()) {
            InetAddress ip = InetAddress.getByName("74.209.24.0");
            CountryResponse response = reader.country(ip);
            assertEquals("US", response.getCountry().getIsoCode());
        }
    }
}
