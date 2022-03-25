package de.fherfurt.campus;

import static de.fherfurt.campus.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

import de.fherfurt.campus.main.DataCollector;
import de.fherfurt.campus.main.Room;
import de.fherfurt.persons.client.DevPersonsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;


/**
 * @author Jann Lucas Pischke, jann.pischke@fh-erfurt.de
 * @coauthor restructured to fit the form by Vadim Rodt
 * The RoomTest class tests the functions locatd in the Room class
 */


public class RoomTest {

    private final List<DevPersonsService> Persons = new ArrayList<>();
    DevPersonsService Wolfgang = new DevPersonsService("Wolfgang", "Schmidt");

    String newTitle = "Room XYZ";

    Room MyRoom = new Room("Room1", 1, Persons, BuildingTest.Building1);
    Room MyRoom1 = new Room("Room2", BuildingTest.Building1);


    /**
     * Function to test setTitleForRoom and getRoomTitle
     */
    @Test
    @DisplayName("Function to set and get title works")
    void testSettingAndGettingTitleForRoom() {

        //GIVEN
        assertNotEquals(MyRoom.getRoomTitle(), newTitle);

        //WHEN
        MyRoom.setTitleForRoom(newTitle);

        //THEN
        assertEquals(MyRoom.getRoomTitle(), newTitle);
        assertEquals(MyRoom.getRoomTitle(), DataCollector.getRoomData().get(MyRoom.getRoomTitle()).get(TITLE).get(0));
    }


    /**
     * Function to test setFloorForRoom, getFloorNumber and getRoomTitle
     */
    @Test
    @DisplayName("Function to set and get floor should work.")
    void testSettingAndGettingFloorForRoom() {
        //GIVEN
        assertNotEquals(MyRoom.getFloorNumber(), 2);

        //WHEN
        MyRoom.setFloorForRoom(2);

        //THEN
        assertEquals(MyRoom.getFloorNumber(), 2);
        assertEquals(MyRoom.getFloorNumber().toString(), DataCollector.getRoomData().get(MyRoom.getRoomTitle()).get(FLOOR).get(0));
    }


    /**
     * Function to test setAffiliationForBuilding, getBuildingAffiliation and getRoomTitle
     */
    @Test
    @DisplayName("Function to set and get affiliation should work.")
    void testSettingAndGettingAffiliationForRoom(){

        //GIVEN
        assertNotEquals(MyRoom.getBuildingAffiliation(),BuildingTest.Building2);

        //WHEN
        MyRoom.setAffiliationForRoom(BuildingTest.Building2);

        //THEN
        assertEquals(MyRoom.getBuildingAffiliation(), BuildingTest.Building2);
        assertEquals(MyRoom.getBuildingAffiliation().getTitle(), DataCollector.getRoomData().get(MyRoom.getRoomTitle()).get(BUILDING_AFFILIATION).get(0));
    }


    /**
     * Function to test setIdForRoom, getRoomID and getRoomTitle
     */
    @Test
    @DisplayName("Setting and Getting ID should work.")
    void testSettingAndGettingIdForRoom() {

        //GIVEN
        assertNotEquals(MyRoom.getRoomID(),2);

        //WHEN
        MyRoom.setIdForRoom(2);

        //THEN
        assertEquals(MyRoom.getRoomID(), 2);
        assertEquals(MyRoom.getRoomID().toString(), DataCollector.getRoomData().get(MyRoom.getRoomTitle()).get(ID).get(0));
    }

    /**
     * Function to Test if Room receives an ID of a Room that already has this ID
     */
    @Test
    @DisplayName("Setting existing ID should not happen")
    void testSettingExistingID() {

        //GIVEN
        for(Room room : Room.getAllRoomsList())
        {
            if(room.getRoomID() == 2 && MyRoom.getRoomID() != 2) {

                //WHEN
                MyRoom.setIdForRoom(2);

                //THEN
                assertNotEquals(MyRoom.getRoomID(),2);
                break;
            }
        }

    }

    /**
     * Function to test setPersonsForRoom, getAllPersonsForThisRoom and getRoomTitle
     */
    @Test
    @DisplayName("Setting and Getting Persons should work.")
    void testSettingAndGettingIdPersons() {

        //GIVEN
        assertFalse(MyRoom1.getAllPersonsForThisRoom().contains(Wolfgang));
        Persons.add(Wolfgang);

        //WHEN
        MyRoom1.setPersonsForRoom(Persons);

        //THEN
        assertEquals(MyRoom1.getAllPersonsForThisRoom(),Persons);

        List<String> personsAsStrings = new ArrayList<>();
        for(DevPersonsService person : Persons)
        {personsAsStrings.add(person.getFullName());}

        assertEquals(DataCollector.getRoomData().get(MyRoom1.getRoomTitle()).get(PERSONS), personsAsStrings);
    }


    /**
     * Function to test addPersonToThisRoom, getAllPersonsForThisRoom and getRoomTitle
     */
    @Test
    @DisplayName("Adding a person to the room should work")
    void testAddingPersonToRoom() {

        //GIVEN
        assertFalse(MyRoom.getAllPersonsForThisRoom().contains(Wolfgang));

        //WHEN
        MyRoom.addPersonToThisRoom(Wolfgang);

        //THEN
        assertTrue(MyRoom.getAllPersonsForThisRoom().contains(Wolfgang));
        assertTrue(DataCollector.getRoomData().get(MyRoom.getRoomTitle()).get(PERSONS).contains(Wolfgang.getFullName()));
    }

    /**
     * Function to test addPersonToThisRoom, getAllPersonsForThisRoom, deletePersonFromThisRoom and getRoomTitle
     */
    @Test
    @DisplayName("Deleting a person from the person list should work fine")
    void testDeletingPersonFromRoom() {

        //GIVEN
        assertFalse(MyRoom.getAllPersonsForThisRoom().contains(Wolfgang));
        MyRoom.addPersonToThisRoom(Wolfgang);
        assertTrue(MyRoom.getAllPersonsForThisRoom().contains(Wolfgang));
        assertTrue(DataCollector.getRoomData().get(MyRoom.getRoomTitle()).get(PERSONS).contains(Wolfgang.getFullName()));


        //WHEN
        MyRoom.deletePersonFromThisRoom(Wolfgang);

        //THEN
        assertFalse(MyRoom.getAllPersonsForThisRoom().contains(Wolfgang));
        assertFalse(DataCollector.getRoomData().get(MyRoom.getRoomTitle()).get(PERSONS).contains(Wolfgang.getFullName()));

    }

    /**
     * Function to test getAllRoomsList, deleteRoomFromAllMapsAndLists and getRoomTitle
     */
    @Test
    @DisplayName("Deleting a room from Hashmaps should work.")
    void testDeletingRoomFromListsAndHashmaps() {

        //GIVEN
        assertTrue(DataCollector.getRoomData().containsKey(MyRoom.getRoomTitle()));
        assertTrue(Room.getRoomsWithPersons().containsKey(MyRoom));
        assertTrue(Room.getAllRoomsList().contains(MyRoom));

        //WHEN
        MyRoom.deleteRoomFromAllMapsAndLists();

        //THEN
        assertFalse(DataCollector.getRoomData().containsKey(MyRoom.getRoomTitle()));
        assertFalse(Room.getRoomsWithPersons().containsKey(MyRoom));
        assertFalse(Room.getAllRoomsList().contains(MyRoom));
    }

    /**
     * Function to Test function checkRoomExists
     */
    @Test
    @DisplayName("Checking if a room exists should work")
    void testCheckingIfRoomExists() {

        //GIVEN
        String searchedRoom = "Room3";
        assertFalse(MyRoom.checkRoomExists(searchedRoom));

        //WHEN
        String searchedRoom1 = "Room1";

        //THEN
        assertTrue(MyRoom.checkRoomExists(searchedRoom1));

    }
}
