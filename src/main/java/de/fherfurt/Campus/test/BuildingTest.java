 package de.fherfurt.Campus.test;

import static de.fherfurt.Campus.Main.*;
import static org.junit.jupiter.api.Assertions.*;

import de.fherfurt.Campus.Building;
import de.fherfurt.Campus.DataCollector;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

 class BuildingTest {

        DataCollector Collector = new DataCollector();

        private final List<String> Rooms = new ArrayList<>();
        private final List<String> Events = new ArrayList<>();
        private final List<String> Types = new ArrayList<>();
        String Affiliation = CAMPUS_1;

        Building MyBuilding = new Building(true, "Haus 1", Rooms,"123.12312", Types , CAMPUS_1 , Collector);
        Building MyBuilding1 = new Building(false, "Haus 2", Rooms,"123.1123, 125.3212", Types , CAMPUS_2 , Collector);

        @Test
        @DisplayName("Setting Rooms for Building Should Work")
        void testSetRoomsForBuilding() {
                Rooms.add("R222");
                Rooms.add("R333");

                MyBuilding.setRoomsForBuilding(Rooms, Collector);
                assertEquals(MyBuilding.getRooms(), Collector.BuildingData.get(MyBuilding.getTitle()).get(ROOMS));
        }

        @Test
        @DisplayName("Setting Location Should Work")
        void testSetLocationForBuilding() {

                String geoLocation = "123.123.123, 123.123.123";
                MyBuilding.setGeoLocationForBuilding(geoLocation,Collector);

                assertEquals(MyBuilding.getGeoLocation(), Collector.BuildingData.get(MyBuilding.getTitle()).get(GEOLOCATION).get(0));
        }

        @Test
        @DisplayName("Setting Type should work")
        void testSetTypeForBuilding() {
            Types.add("Gymnasium");
            Types.add("Education");

            MyBuilding.setTypeForBuilding(Types, Collector);
            assertEquals(MyBuilding.getType(), Collector.BuildingData.get(MyBuilding.getTitle()).get(TYPES));
        }

         @Test
         @DisplayName("Setting Event should work")
         void testSetEventForBuilding() {
            Events.add("Birthday Party");
            Events.add("Christmas");

            MyBuilding.setEventForBuilding(Events, Collector);
            assertEquals(MyBuilding.getEvent(), Collector.BuildingData.get(MyBuilding.getTitle()).get(EVENTS));
         }

         @Test
         @DisplayName("Setting ID should work")
         void testSetIDForBuilding() {
            Integer id = 1;

            MyBuilding.setIDForBuilding(id, Collector);
            assertEquals(MyBuilding.getID().toString(), Collector.BuildingData.get(MyBuilding.getTitle()).get(ID).get(0));
         }

         @Test
         @DisplayName("Setting Accessibility should work")
         void testSetAccessibilityForBuilding() {

            boolean accessibility = false;

            MyBuilding.setAccessibilityForBuilding(accessibility, Collector);
            assertEquals(String.valueOf(MyBuilding.getAccessibility()),Collector.BuildingData.get(MyBuilding.getTitle()).get(ACCESSIBILITY).get(0));

         }

        @Test
        @DisplayName("Setting Affiliation should work")
        void testSetAffiliationForBuilding()
        {
            MyBuilding.setAffiliationForBuilding(Affiliation, Collector);
            assertEquals(MyBuilding.getAffiliation(), Collector.BuildingData.get(MyBuilding.getTitle()).get(CAMPUS_AFFILIATION).get(0));
        }

        @Test
        @DisplayName("Setting Title should work")
        void testSetTitleForBuilding()
        {
            String MyTitle = "House3";
            MyBuilding.setTitleForBuilding(MyTitle, Collector);

            assertEquals(MyBuilding.getTitle(), Collector.BuildingData.get(MyBuilding.getTitle()).get(TITLE).get(0));
        }

        @Test
        @DisplayName("Deleting Building should work")
        void testDeleteBuilding()
        {
            assertTrue(Collector.BuildingData.containsKey(MyBuilding1.getTitle()));
            MyBuilding1.deleteBuilding(Collector);

            boolean BuildingExistence;

            BuildingExistence = MyBuilding1.getTitle() != null;
            assertFalse(Collector.BuildingData.containsKey(MyBuilding1.getTitle()));
            assertFalse(BuildingExistence);

        }

        @Test
        @DisplayName("Deleting and Adding Room should work")
        void testDeleteAndAddRoom()
        {
            String MyRoom = "R 100";
            MyBuilding1.addRoom(MyRoom, Collector);
            assertTrue(MyBuilding1.getRooms().contains(MyRoom));
            MyBuilding1.deleteRoom(MyRoom, Collector);
            assertFalse(MyBuilding1.getRooms().contains(MyRoom));
        }

}
