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

     static List<Building> buildingList = new ArrayList<>();
     static List<Building> buildingList1 = new ArrayList<>();
     static List<Building> buildingList2 = new ArrayList<>();

     static Building Building1 = new Building("Haus 1");
     static Building Building2 = new Building("Haus 2");
     static Building Building3 = new Building("Haus 3");

     static Room myRoom = new Room("Room 1");
     static Room myRoom1 = new Room("Room 2");
     static Room myRoom2 = new Room("Room 3");
     static Room myRoom3 = new Room("Room 4");

     private static List<Room> Rooms = new ArrayList<>();
     private static List<Event> Events = new ArrayList<>();
     private static List<Building.BuildingTypes> Types = new ArrayList<>();

     public static void addingBuildingsToBuildingLists() {

         BuildingTest.buildingList.add(BuildingTest.Building1);
         BuildingTest.buildingList1.add(BuildingTest.Building2);
         BuildingTest.buildingList2.add(BuildingTest.Building1);
         BuildingTest.buildingList2.add(BuildingTest.Building2);
     }
     public static void addingRoomsToRoomsList() {
         Rooms.add(myRoom);
         Rooms.add(myRoom1);
         Rooms.add(myRoom2);
     }
     public static void addingTypeToBuildingTypesList() {
         Types.add(Building.BuildingTypes.EDUCATION);
     }

     public static Event myEvent = new Event("12.12.22", "15.12.22", "Birthday Party", Campus.CampusNames.SCHLUETER.toString(), Building1.getTitle(), myRoom.getRoomTitle());


     @Test
     @DisplayName("Setting and Getting BuildingTypes for Building should work")
     void addingBuildingTypeToList() {

         //GIVEN
         addingTypeToBuildingTypesList();

         //WHEN
         Building1.addBuildingType(Building.BuildingTypes.EDUCATION);

         //THEN
         assertEquals(Types, Building1.getType());
         assertEquals(Building1.getType().get(0).toString(), DataCollector.getBuildingData().get(Building1.getTitle()).get(TYPES).get(0));
     }

     @Test
     @DisplayName("Setting and Getting Rooms for Building should work")
     void testSetRoomsForBuilding() {

         //GIVEN
         addingRoomsToRoomsList();

         //WHEN
         Building1.setRoomsForBuilding(Rooms);

         //THEN
         assertEquals(Building1.getRooms(), Rooms);
         assertEquals(Building1.getRoomsAsStrings(), DataCollector.getBuildingData().get(Building1.getTitle()).get(ROOM));
     }

     @Test
     @DisplayName("Setting and Getting Campus Affiliation for Building should work")
     void testSetCampusForBuilding() {

         //GIVEN
         assertNotEquals(Building1.getAffiliation(),Campus.Schlueter);

         //WHEN
         Building1.setAffiliationForBuilding(Campus.Schlueter);

         //THEN
         assertEquals(Building1.getAffiliation(), Campus.Schlueter);
         assertEquals(Building1.getAffiliation().toString(), DataCollector.getBuildingData().get(Building1.getTitle()).get(CAMPUS_AFFILIATION).get(0));
     }

     @Test
     @DisplayName("Setting and Getting ID should work")
     void testSetIDForBuilding() {

         //GIVEN
         Integer id = 3;
         assertNotEquals(Building1.getID(), id);

         //WHEN
         Building1.setIDForBuilding(id);

         //THEN
         assertEquals(Building1.getID(),id);
         assertEquals(Building1.getID().toString(), DataCollector.getBuildingData().get(Building1.getTitle()).get(ID).get(0));
     }

     @Test
     @DisplayName("Setting and Getting Accessibility should work")
     void testSetAccessibilityForBuilding() {
        //GIVEN
        assertFalse(Building1.getAccessibility());

        //WHEN
        Building1.setAccessibilityForBuilding(true);

        //THEN
        assertEquals(String.valueOf(Building1.getAccessibility()),DataCollector.getBuildingData().get(Building1.getTitle()).get(ACCESSIBILITY).get(0));

     }

     @Test
     @DisplayName("Setting and Getting Title should work")
     void testSetTitleForBuilding() {

         //GIVEN
         assertNotEquals(Building1.getTitle(),"House 3");

         //WHEN
         Building1.setTitleForBuilding("House 3");

         //THEN
         assertEquals(Building1.getTitle(),"House 3");
         assertEquals(Building1.getTitle(), DataCollector.getBuildingData().get(Building1.getTitle()).get(TITLE).get(0));
     }

     @Test
     @DisplayName("Deleting Building from Hashmaps should work")
     void testDeleteBuildingFromHashmaps() {
         //GIVEN
         addingRoomsToRoomsList();
         Building1.setRoomsForBuilding(Rooms);
         Building1.setAffiliationForBuilding(Campus.Schlueter);
         int counter1 = 0;
         for (Room ignored : Rooms) {
             assertSame(Rooms.get(counter1).getBuildingAffiliation(), Building1);
             counter1 += 1;
         }

         //WHEN
         Building1.deleteBuildingFromHashmaps();

         //THEN
         int counter2 = 0;
         for (Room ignored1 : Rooms) {
             assertNotSame(Rooms.get(counter2).getBuildingAffiliation(), Building1);
             counter2 += 1;
         }
         assertFalse(Campus.Schlueter.getCampusBuildings().contains(Building1));
         }

     @Test
     @DisplayName("Adding and Deleting Rooms from Building should work")
     void testAddingAndDeletingRoom() {

         //GIVEN
         addingRoomsToRoomsList();
         Building1.setRoomsForBuilding(Rooms);
         assertEquals(Building1.getRooms(), Rooms);
         assertFalse(Building1.getRooms().contains(myRoom3));

         //WHEN
         Building1.deleteRoomFromRoomList(myRoom1);
         Building1.addingRoomToRoomList(myRoom3);

         //THEN
         assertTrue(Building1.getRooms().contains(myRoom3));
         assertFalse(Building1.getRooms().contains(myRoom1));

     }
}