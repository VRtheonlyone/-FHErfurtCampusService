package de.fherfurt.campus;

import static de.fherfurt.campus.constants.Constants.BUILDING;
import static org.junit.jupiter.api.Assertions.*;
import de.fherfurt.campus.main.DataCollector;
import org.junit.jupiter.api.*;
import de.fherfurt.campus.main.Campus;
import org.junit.jupiter.api.Test;

public class CampusTest {

    @Test
    @DisplayName("Getting only 3 Campus Instances with data should work")
    public void gettingPredefinedCampusInstances() {
        //GIVEN
        assertEquals(Campus.getCampusCounter(), 3);

        //WHEN
        Campus Campus4 = Campus.getInstance();
        Campus Campus5 = Campus.getInstance();

        //THEN
        assertEquals(Campus.Schlueter, Campus.getAllCampuses().get(0));
        assertEquals(Campus.Leipziger, Campus.getAllCampuses().get(1));
        assertEquals(Campus.Altonaer, Campus.getAllCampuses().get(2));

        assertEquals(Campus4, Campus.getDummyCampusList().get(0));
        assertEquals(Campus5, Campus.getDummyCampusList().get(0));

        assertEquals(Campus.Schlueter.getCampusTitle(), Campus.CampusNames.SCHLUETER.toString());
        assertEquals(Campus.Leipziger.getCampusGeoLocation(), "50.991562842099846, 11.054766412935898");
        assertEquals(Campus.Altonaer.getCampusID(), 3);
    }

    @Test
    @DisplayName("Campuses should be in Campus List")
    public void checkingIfCampusesAreInList() {
        // GIVEN
        assertEquals(Campus.getAllCampuses().size(),3);

        // WHEN
        Campus Campus4 = Campus.getInstance();
        Campus Campus5 = Campus.getInstance();

        // THEN
        assertEquals(Campus.getAllCampuses().size(),3);
        assertTrue(Campus.campusExistsInList(Campus.Schlueter));
        assertTrue(Campus.campusExistsInList(Campus.Leipziger));
        assertTrue(Campus.campusExistsInList(Campus.Altonaer));
        assertTrue(Campus.getAllCampuses().contains(Campus.Schlueter));
        assertTrue(Campus.getAllCampuses().contains(Campus.Leipziger));
        assertTrue(Campus.getAllCampuses().contains(Campus.Altonaer));
        assertEquals(Campus.getDummyCampusList().size(), 1);
    }

    @Test
    @DisplayName("CampusData should be same as in DataCollector Hashmap")
    public void checkingIfDataIsTransferredToHashmap() {

        // GIVEN
        assertNotNull(DataCollector.getCampusData().get(Campus.Schlueter.getCampusTitle()));
        assertNotNull(DataCollector.getCampusData().get(Campus.Leipziger.getCampusTitle()));
        assertNotNull(DataCollector.getCampusData().get(Campus.Altonaer.getCampusTitle()));

        // WHEN
        BuildingTest.addingBuildingsToBuildingLists();
        Campus.Schlueter.setBuildingsForCampus(BuildingTest.buildingList);
        Campus.Altonaer.setBuildingsForCampus(BuildingTest.buildingList1);
        Campus.Leipziger.setBuildingsForCampus(BuildingTest.buildingList2);

        // THEN
        assertEquals(Campus.Schlueter.getCampusBuildingsAsStrings(), DataCollector.getCampusData().get(Campus.Schlueter.getCampusTitle()).get(BUILDING));
        assertEquals(Campus.Leipziger.getCampusBuildingsAsStrings(), DataCollector.getCampusData().get(Campus.Leipziger.getCampusTitle()).get(BUILDING));
        assertEquals(Campus.Altonaer.getCampusBuildingsAsStrings(), DataCollector.getCampusData().get(Campus.Altonaer.getCampusTitle()).get(BUILDING));

    }

    @Test
    @DisplayName("Deleting and Adding of Buildings should work")
    public void checkingIfBuildingsAreDeletedAndAdded() {

        // GIVEN
        BuildingTest.addingBuildingsToBuildingLists();

        // WHEN
        Campus.Schlueter.setBuildingsForCampus(BuildingTest.buildingList2);
        Campus.Schlueter.deleteBuildingFromCampus(BuildingTest.Building1);
        Campus.Schlueter.addBuildingToCampus(BuildingTest.Building3);

        // THEN
        assertTrue(Campus.Schlueter.getCampusBuildings().contains(BuildingTest.Building2));
        assertTrue(Campus.Schlueter.getCampusBuildings().contains(BuildingTest.Building3));
        assertFalse(Campus.Schlueter.getCampusBuildings().contains(BuildingTest.Building1));
    }
}