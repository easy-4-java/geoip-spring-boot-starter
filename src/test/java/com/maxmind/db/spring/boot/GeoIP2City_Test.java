package com.maxmind.db.spring.boot;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import org.junit.Test;

import java.io.File;
import java.net.InetAddress;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/** Exercises a lookup against MaxMind's pinned synthetic test database. */
public class GeoIP2City_Test {

    @Test
    public void testName() throws Exception {
        File database = new File("target/geoip-test-data/GeoIP2-City-Test.mmdb");
        try (DatabaseReader reader = new DatabaseReader.Builder(database).build()) {
            InetAddress ip = InetAddress.getByName("81.2.69.160");
            CityResponse response = reader.city(ip);
            assertEquals("London", response.getCity().getName());
        }
    }
}
