package de.fherfurt.Campus.test;
import static de.fherfurt.Campus.Main.*;
import static org.junit.jupiter.api.Assertions.*;

import de.fherfurt.Campus.Building;
import de.fherfurt.Campus.DataCollector;

import de.fherfurt.Campus.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class LocationTest {

    DataCollector Collector = new DataCollector();

    String GeoLocation = "TestGeoLocation";
    String Title = "TestTitle";

    Location MyLocation = new Location(CAMPUS_1, "1234.123", Collector);
    Location MyLocation1 = new Location(CAMPUS_2, "4568.123", Collector);


    @Test
    @DisplayName("Setting GeoLocation for Campus Should Work")
    void testSetGeoLocationForCampus() {

        MyLocation.setGeographicalCoordinatesForCampus(GeoLocation, Collector);
        assertEquals(MyLocation.getCampusGeoLocation(), Collector.CampusData.get(MyLocation.getCampusGeoLocation()).get(GEOLOCATION));

    }

    @Test
    @DisplayName("Setting Title for Campus Should Work")
    void testSetTypeForCampus() {

        MyLocation.setTitleForCampus(Title, Collector);
        assertEquals(MyLocation.getCampusTitle(), Collector.CampusData.get(MyLocation.getCampusTitle()).get(TITLE));
    }

    @Test
    @DisplayName("Setting ID for Campus Should Work")
    void testSetIdForCampus() {
        Integer ID = 1;

        MyLocation.setIdForCampus(ID, Collector);
        assertEquals(MyLocation.getCampusID(), Collector.CampusData.get(MyLocation.getCampusID()).get(ID));
    }
}
