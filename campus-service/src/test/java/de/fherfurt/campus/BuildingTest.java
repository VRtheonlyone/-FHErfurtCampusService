/**
package de.fherfurt.campus;

import de.fherfurt.campus.main.Campus;
import de.fherfurt.campus.main.Building;
import de.fherfurt.campus.main.DataCollector;
import static de.fherfurt.campus.constants.Constants.*;

import static org.junit.jupiter.api.Assertions.*;

import de.fherfurt.campus.main.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

 class BuildingTest {

        private final List<String> Rooms = new ArrayList<>();
        private final List<String> Events = new ArrayList<>();
        private final List<Building.BuildingTypes> Types = new ArrayList<>();

        Room myRoom = new Room();

        Building MyBuilding = new Building(true, "Haus 1", Rooms,"123.12312", Types , Campus.CampusNames.LEIPZIGER);
        Building MyBuilding1 = new Building(false, "Haus 2", Rooms,"123.1123, 125.3212", Types , Campus.CampusNames.SCHLUETER);

        @Test
        @DisplayName("Setting Rooms for Building Should Work")
        void testSetRoomsForBuilding() {
                Rooms.add("R222");
                Rooms.add("R333");

                MyBuilding.setRoomsForBuilding(Rooms);
                assertEquals(MyBuilding.getRooms(), DataCollector.getBuildingData().get(MyBuilding.getTitle()).get(ROOM));
        }

        @Test
        @DisplayName("Setting Campus Should Work")
        void testSetCampusForBuilding() {

                String geoCampus = "123.123.123, 123.123.123";
                MyBuilding.setGeoCampusForBuilding(geoCampus);

                assertEquals(MyBuilding.getGeoCampus(), DataCollector.getBuildingData().get(MyBuilding.getTitle()).get(GEOLOCATION).get(0));
        }

        @Test
        @DisplayName("Setting Type should work")
        void testSetTypeForBuilding() {
            Types.add(Building.BuildingTypes.CAFETERIA);
            Types.add(Building.BuildingTypes.EDUCATION);

            MyBuilding.setTypeForBuilding(Types);
            assertEquals(MyBuilding.getType(), DataCollector.getBuildingData().get(MyBuilding.getTitle()).get(TYPES));
        }

        @Test
        @DisplayName("Setting Event should work")
        void testSetEventForBuilding() {
            Events.add("Birthday Party");
            Events.add("Christmas");

            MyBuilding.setEventForBuilding(Events);
            assertEquals(MyBuilding.getEvents(), DataCollector.getBuildingData().get(MyBuilding.getTitle()).get(EVENTS));
         }

         @Test
         @DisplayName("Setting ID should work")
         void testSetIDForBuilding() {
            Integer id = 1;

            MyBuilding.setIDForBuilding(id);
            assertEquals(MyBuilding.getID().toString(), DataCollector.getBuildingData().get(MyBuilding.getTitle()).get(ID).get(0));
         }

         @Test
         @DisplayName("Setting Accessibility should work")
         void testSetAccessibilityForBuilding() {

            boolean accessibility = false;

            MyBuilding.setAccessibilityForBuilding(accessibility);
            assertEquals(String.valueOf(MyBuilding.getAccessibility()),DataCollector.getBuildingData().get(MyBuilding.getTitle()).get(ACCESSIBILITY).get(0));

         }

        @Test
        @DisplayName("Setting Affiliation should work")
        void testSetAffiliationForBuilding()
        {
            MyBuilding.setAffiliationForBuilding(Affiliation);
            assertEquals(MyBuilding.getAffiliation(), DataCollector.getBuildingData().get(MyBuilding.getTitle()).get(CAMPUS_AFFILIATION).get(0));
        }

        @Test
        @DisplayName("Setting Title should work")
        void testSetTitleForBuilding()
        {
            String MyTitle = "House3";
            MyBuilding.setTitleForBuilding(MyTitle);

            assertEquals(MyBuilding.getTitle(), DataCollector.getBuildingData().get(MyBuilding.getTitle()).get(TITLE).get(0));
        }

        @Test
        @DisplayName("Deleting Building should work")
        void testDeleteBuilding()
        {
            assertTrue(DataCollector.getBuildingData().containsKey(MyBuilding1.getTitle()));
            MyBuilding1.deleteBuildin);

            boolean BuildingExistence;

            BuildingExistence = MyBuilding1.getTitle() != null;
            assertFalse(DataCollector.getBuildingData().containsKey(MyBuilding1.getTitle()));
            assertFalse(BuildingExistence);

        }

        @Test
        @DisplayName("Adding Room should work")
        void testAddRoom()
        {
            String MyRoom = "R 100";
            MyBuilding1.addRoom(MyRoom);
            assertTrue(MyBuilding1.getRooms().contains(MyRoom));
        }

     @Test
     @DisplayName("Adding Room should work")
     void testDeleteRoom()
     {
         String MyRoom = "R 101";
         MyBuilding1.addRoom(MyRoom);
         assertTrue(MyBuilding1.getRooms().contains(MyRoom));
         MyBuilding1.deleteRoom(MyRoom);
         assertFalse(MyBuilding1.getRooms().contains(MyRoom));
     }
}
*/