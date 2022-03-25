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

public class RoomTest {

    private final List<DevPersonsService> Persons = new ArrayList<>();
    DevPersonsService Wolfgang = new DevPersonsService("Wolfgang", "Schmidt");

    void addPersonToPersonsList() {
        this.Persons.add(Wolfgang);
    }

    static List<Room> roomList = new ArrayList<>();
    static List<Room> roomList1 = new ArrayList<>();
    static List<Room> roomList2 = new ArrayList<>();

    String newTitle = "Room XYZ";

    Room MyRoom = new Room("Room1", 1, Persons, BuildingTest.Building1);

    // ----------------- Set / Get Tests -------------------//

    @Test
    @DisplayName("Function to set and get title should work")
    void testSetTitleForRoom() {
        //GIVEN
        assertNotEquals(MyRoom.getRoomTitle(), newTitle);

        //WHEN
        MyRoom.setTitleForRoom(newTitle);

        //THEN
        assertEquals(myRoom.getTitle(),newTitle)
        assertEquals(MyRoom.getRoomTitle(), DataCollector.getRoomData().get(MyRoom.getRoomTitle()).get(TITLE).get(0));
    }

}
    @Test
    @DisplayName("Function to set floor works fine.")
    void testSetFloorForRoom(){
        Integer NewFloor = 2;
        MyRoom.setFloorForRoom(NewFloor, Collector);

        assertEquals(MyRoom.getFloorNumber().toString(), Collector.RoomData.get(MyRoom.getRoomTitle()).get(FLOOR).get(0));
    }

    @Test
    @DisplayName("Function to set affiliation works fine.")
    void testSetAffiliationForRoom(){
        String NewAffiliation = "Haus 2";
        MyRoom.setAffiliationForRoom(NewAffiliation, Collector);

        assertEquals(MyRoom.getBuildingAffiliation(), Collector.RoomData.get(MyRoom.getRoomTitle()).get(BUILDING_AFFILIATION).get(0));
    }

    @Test
    @DisplayName("Setting ID works fine")
    void testSetIdForRoom() {
        Integer id = 1;

        MyRoom.setIdForRoom(id, Collector);
        assertEquals(MyRoom.getRoomID().toString(), Collector.RoomData.get(MyRoom.getRoomTitle()).get(ID).get(0));
    }

    // ----------------- Add Test -------------------//

    @Test
    @DisplayName("Adding a person to the person list works fine")
    void testAddPersonToRoom() {
        String NewPerson = "Horst Günther";
        MyRoom.addPerson(NewPerson, Collector);
        assertTrue(MyRoom.getRoomPersons().contains(NewPerson));
    }

    // ----------------- Delete Tests -------------------//

    // At first the person Holger Rainer is added with the already tested code and then deleted
    @Test
    @DisplayName("Deleting a person of the person list works fine")
    void testDeletePerson()
    {
        String NewPerson = "Holger Rainer";
        MyRoom.addPerson(NewPerson, Collector);
        assertTrue(MyRoom.getRoomPersons().contains(NewPerson));

        MyRoom.deletePerson(NewPerson, Collector);
        assertFalse(MyRoom.getRoomPersons().contains(NewPerson));
    }

    @Test
    @DisplayName("Deleting a room works fine")
    void testDeleteRoom() {
        assertTrue(Collector.RoomData.containsKey(MyRoom.getRoomTitle()));
        MyRoom.deleteRoom(Collector);

        boolean RoomExists;

        RoomExists = MyRoom.getRoomTitle() != null;
        assertFalse(Collector.RoomData.containsKey(MyRoom.getRoomTitle()));
        assertFalse(RoomExists);
    }
}
*/