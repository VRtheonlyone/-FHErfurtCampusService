package de.fherfurt.Campus.test;
import static de.fherfurt.Campus.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

import de.fherfurt.Campus.DataCollector;
import de.fherfurt.Campus.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class LocationTest {

    DataCollector Collector = new DataCollector();

    String GeoLocation = "TestGeoLocation";
    String Title = "TestTitle";
    List<String> Buildings = new ArrayList<>();
    //Buildings.add("Building 1");

    Location MyLocation = new Location(Location.Campuses.ALTONAER.toString(), "123.456", Buildings, Collector);
    Location MyLocation1 = new Location(Location.Campuses.LEIPZIGER.toString(), "654.321", Buildings, Collector);


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

    @Test
    @DisplayName("Setting ID for Campus Should Work")
    void testSetBuildingsForCampus() {

        MyLocation.setBuildingsForCampus(Buildings, Collector);
        assertEquals(MyLocation.getCampusBuildings(), Collector.CampusData.get(MyLocation.getCampusBuildings()).get(BUILDING));
    }
    //---- ADD TEST ----//

    @Test
    @DisplayName("Add a new Building to a Campus")
    void TestAddBuildingToCampus() { //assert true - assert false

        String newBuilding = "";
        MyLocation1.addBuildingToCampus(newBuilding, Collector);
    }

    //---- DELETE TEST ----//

    @Test
    @DisplayName("Delete a Campus Title")
    void TestDeleteTitleOfCampus() {


    }
}
