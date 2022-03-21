package de.fherfurt.campus;
import static de.fherfurt.campus.constants.Constants.*;

import de.fherfurt.campus.main.Campus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.*;

public class CampusTest {
/*
    String GeoLocation = "TestGeoLocation";
    String Title = "TestTitle";
    List<String> Buildings = new ArrayList<>();
    Buildings.add("Building 1");

    Location MyLocation = new Location(Location.Campuses.ALTONAER.toString(), "123.456", Buildings);
    Location MyLocation1 = new Location(Location.Campuses.LEIPZIGER.toString(), "654.321", Buildings);
*/

    @Test
    @DisplayName("Getting only 3 Campus Instances should work")
    void gettingCampusInstances() {
        Campus Campus1 = Campus.getInstance();
        Campus Campus2 = Campus.getInstance();
        Campus Campus3 = Campus.getInstance();
        Campus Campus4 = Campus.getInstance();
        System.out.println(Campus1.getCampusGeoLocation());
        System.out.println(Campus2.getCampusGeoLocation());
        System.out.println(Campus3.getCampusGeoLocation());
        System.out.println(Campus4.getCampusGeoLocation());
        System.out.println(Campus1.getCampusTitle());
        System.out.println(Campus2.getCampusTitle());
        System.out.println(Campus3.getCampusTitle());
        System.out.println(Campus4.getCampusTitle());
        System.out.println(Campus1.getCampusBuildings());
        System.out.println(Campus2.getCampusBuildings());
        System.out.println(Campus3.getCampusBuildings());
        System.out.println(Campus4.getCampusBuildings());
        System.out.println(Campus1.getCampusID());
        System.out.println(Campus2.getCampusID());
        System.out.println(Campus3.getCampusID());
        System.out.println(Campus4.getCampusID());
    }

/*
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
    @DisplayName("Setting Building for Campus Should Work")
    void testSetBuildingsForCampus() {

        MyLocation.setBuildingsForCampus(Buildings, Collector);
        assertEquals(MyLocation.getCampusBuildings(), Collector.CampusData.get(BUILDING));
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


    }*/
}
