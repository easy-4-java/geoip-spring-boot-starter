package com.maxmind.db.spring.boot;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.IspResponse;
import org.junit.Test;

import java.io.File;
import java.net.InetAddress;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/** Exercises a lookup against MaxMind's pinned synthetic test database. */
public class GeoIP2ISP_Test {

    @Test
    public void testName() throws Exception {
        File database = new File("target/geoip-test-data/GeoIP2-ISP-Test.mmdb");
        try (DatabaseReader reader = new DatabaseReader.Builder(database).build()) {
            InetAddress ip = InetAddress.getByName("1.128.0.0");
            IspResponse response = reader.isp(ip);
            assertEquals("Telstra Internet", response.getIsp());
        }
    }
}
