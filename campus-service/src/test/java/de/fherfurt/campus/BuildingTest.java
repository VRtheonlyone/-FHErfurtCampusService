package de.fherfurt.campus;

import de.fherfurt.appointments.client.Event;
import de.fherfurt.campus.main.Campus;
import de.fherfurt.campus.main.Building;
import de.fherfurt.campus.main.DataCollector;
import static de.fherfurt.campus.constants.Constants.*;

import static org.junit.jupiter.api.Assertions.*;

import de.fherfurt.campus.main.Room;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

 class BuildingTest {
     private static final List<Building.BuildingTypes> Building1Types = new ArrayList<>();
     private static final Building.BuildingTypes BuildingType1 = Building.BuildingTypes.EDUCATION;

     public void addingBuildingTypesToBuilding() {
         BuildingTest.Building1Types.add(BuildingTest.BuildingType1);
     }
     static List<Building> buildingList = new ArrayList<>();
     static List<Building> buildingList1 = new ArrayList<>();
     static List<Building> buildingList2 = new ArrayList<>();

     static Building Building1 = new Building("Haus 1");
     static Building Building2 = new Building("Haus 2");
     static Building Building3 = new Building("Haus 3");

     static List<Room> roomList = new ArrayList<>();
     static List<Room> roomList1 = new ArrayList<>();
     static List<Room> roomList2 = new ArrayList<>();

     static Room myRoom = new Room("Room 1");
     static Room myRoom1 = new Room("Room 2");
     static Room myRoom2 = new Room("Room 3");

     public static void addingBuildingsToBuildingLists(){

         BuildingTest.buildingList.add(BuildingTest.Building1);
         BuildingTest.buildingList1.add(BuildingTest.Building2);
         BuildingTest.buildingList2.add(BuildingTest.Building1);
         BuildingTest.buildingList2.add(BuildingTest.Building2);
     };
     public static void addingRoomsToRoomsList(){
       roomList.add(myRoom);
       roomList1.add(myRoom1);
       roomList2.add(myRoom2);
     };

     private final List<String> Rooms = new ArrayList<>();
     private final List<String> Events = new ArrayList<>();
     private final List<Building.BuildingTypes> Types = new ArrayList<>();



     Event myEvent = new Event("12.12.22","15.12.22","Birthday Party", Campus.CampusNames.SCHLUETER.toString(), Building1.getTitle(), myRoom.getRoomTitle());


     @Test
     @DisplayName("Setting Rooms for Building Should Work")
     void addingBuildingTypesToList() {

     }

     @Test
     @DisplayName("Setting Rooms for Building Should Work")
     void testSetRoomsForBuilding() {

         MyBuilding.setRoomsForBuilding(Rooms);
         assertEquals(MyBuilding.getRooms(), DataCollector.getBuildingData().get(MyBuilding.getTitle()).get(ROOM));
     }
 }
/*
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