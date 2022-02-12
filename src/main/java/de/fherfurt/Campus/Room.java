package de.fherfurt.Campus;
import java.util.*;
import java.lang.reflect.Array;
import java.util.List;
import de.fherfurt.Campus.Main;

import static de.fherfurt.Campus.Main.ID;

public class Room {

    /*
    // getBuildingTitle             +
    // setBuildingTitle             -
    // getRoomAccordingToPerson     +
    // setPersonAccordingToRoom     -
    // getFloor                     +
    // ...

    public String[] roomNumber;
    public int floor;

    public Room(String[] _roomNumber, int _floor) {

        this.roomNumber= _roomNumber;
        this.floor= _floor;
    }
    */



    //-------------------------------ATTRIBUTES----------------------------------//

    // intern room ID for easy handling
    private Integer id;

    // Number of the room
    private String title;

    // floor the room is located on
    private Integer floor;

    // List of persons for the room
    private final List<String> persons;

    // To which Building it belongs
    private String buildingAffiliation;

    //---------------------------------------------------------------------------------------------------//


    // ----------------------------------- CONSTRUCTOR ---------------------------------------------


    public Room(Integer _roomID,String _roomTitle, Integer _floorNumber, List<String> _roomPersons, DataCollector _collector) {

        DataCollector.RoomCounter +=1;
        this.id = DataCollector.RoomCounter;

        this.title = _roomTitle;
        this.floor = _floorNumber;
        this.persons = _roomPersons;

        setIdForRoom(_roomID);
        setTitleForRoom(_roomTitle);
        setFloorForRoom(_floorNumber);
        setPersonsForRoom(_roomPersons);
    }
    // ---------------------------------------------------------------------------------------------//

    // ----------------------------- SETTER ---------------------------------------- //


    public void setIDForRoom(Integer _id, DataCollector _collector)
    {
        this.id = _id;

        // Integer must be converted to String to be written into the Hashmap,because it is a String List
        String IDString = String.valueOf(_id);
        _collector.BuildingData.put(this.title, new HashMap(){{put(ID, IDString);}}); // --> Check Building Setter Methods
    }

    public void setIdForRoom(Integer _roomID)
    {

    }

    public void setFloorForRoom(Integer _floorNumber)
    {

    }

    public void setTitleForRoom(String _roomTitle)
    {

    }

    public void setPersonsForRoom(List<String> _roomPersons)
    {

    }

    // ---------------------------------------------------------------------------------------------//

    // ----------------------------- GETTER ---------------------------------------- //

    public void getIdForRoom(Integer _roomID)
    {

    }

    //
    public void getTitleForRoom(String _roomTitle)
    {

    }

    // This should get the floor the room is located on
    public void getFloorForRoom(Integer _floorNumber)
    {

    }

    // This should get a List of all Persons associated with a room
    public List<String> getPersonsForRoom()
    {

        return null;
    }

    // ---------------------------------------------------------------------------------------------//

    // ----------------------------- DELETES ---------------------------------------- //


    public void deleteRoom(String _room)
    {

    }

    // ---------------------------------------------------------------------------------------------//


    /*
    // ----------------------------- METHODS ---------------------------------------- //

    // THESE ARE THE OLD METHODS I COMMENTED OUT FOR MY PERSONAL CLARYITY

    public static String[] getBuildingTitle(String _roomNumber) {
        String[] buildingTitle;
        // searching in the Datamodel for the matching campus identites
        buildingTitle= new String[]{"a"}; // Test variable value initialisation

        return buildingTitle;
    }

    public static String getRoomAccordingToPerson (String _personName) {
        String roomTitle;
        // searching in the Datamodel for the matching campus identites

        roomTitle = "2"; // Test variable value initialisation

        return roomTitle;
    }

    public static String[] getFloor(String _roomNr) {
        String[] floors;
        // searching in the Datamodel for the matching campus identites
        floors = new String[]{"(AltStr)7.2.5", "(SchStr.)1.1.1"}; // Test variable value initialisation

        return floors;
    }
    */



}


