 package de.fherfurt.Campus.test;

import static de.fherfurt.Campus.Main.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

        Building MyBuilding = new Building(true, "Haus 1", Rooms,"123.12312", Types , "Schlüterstrasse" , Collector);

        @Test
        @DisplayName("Setting Rooms for Building Should Work")
        void testSetRoomsForBuilding() {
                Rooms.add("R222");
                Rooms.add("R333");

                MyBuilding.setRoomsForBuilding(Rooms, Collector);
                assertEquals(Rooms, Collector.BuildingData.get(MyBuilding.getTitle()).get(ROOMS));
        }

        @Test
        @DisplayName("Setting Location Should Work")
        void testSetLocationForBuilding() {

                String geoLocation = "123.123.123, 123.123.123";
                MyBuilding.setGeoLocationForBuilding(geoLocation,Collector);

                assertEquals(geoLocation, Collector.BuildingData.get(MyBuilding.getTitle()).get(GEOLOCATION).get(0));
        }

        @Test
        @DisplayName("Setting Event should work")
        void testSetTypeForBuilding() {
        }

         @Test
         @DisplayName("Setting Event should work")
         void testSetEventForBuilding() {
         }

         @Test
         @DisplayName("Setting Event should work")
         void testSetIDForBuilding() {
         }

         @Test
         @DisplayName("Setting Event should work")
         void testSetAccessibilityForBuilding() {
         }


}
