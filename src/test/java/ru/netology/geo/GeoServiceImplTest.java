package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplTest {

    @Test

    public void byIpTest() {

        GeoService geoServiceImpl = new GeoServiceImpl();

        Location actual = geoServiceImpl.byIp("172.0.32.11");

        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        Assertions.assertEquals(actual.getCity(), expected.getCity());
        Assertions.assertEquals(actual.getCountry(), expected.getCountry());
        Assertions.assertEquals(actual.getStreet(), expected.getStreet());
        Assertions.assertEquals(actual.getBuiling(), expected.getBuiling());

    }

    @Test

    public void byCoordinates() {

        GeoService geoServiceImpl = new GeoServiceImpl();

        Assertions.assertThrows(RuntimeException.class, () -> geoServiceImpl.byCoordinates(55.45, 34.37));


    }


    }
