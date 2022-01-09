package de.fherfurt.Campus;

import java.lang.reflect.Array;
import java.util.List;

import static de.fherfurt.Campus.Main.BuildingDataCollector;

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
    private Integer roomID;

    // Number of the room
    private String roomTitle;

    // floor the room is located on
    private Integer floorNumber;

    // List of persons for the room
    private final List<String> roomPersons;

    //---------------------------------------------------------------------------------------------------//


    // ----------------------------------- CONSTRUCTOR ---------------------------------------------


    public Room(Integer _roomID,String _roomTitle, Integer _floorNumber, List<String> _roomPersons) {

        this.roomID = _roomID;
        this.roomTitle = _roomTitle;
        this.floorNumber = _floorNumber;
        this.roomPersons = _roomPersons;

        setIdForRoom(_roomID);
        setNumberForRoom(_roomTitle);
        setFloorForRoom(_floorNumber);
        setPersonsForRoom(_roomPersons);
    }
    // ---------------------------------------------------------------------------------------------//

    // ----------------------------- SETTER ---------------------------------------- //


    public void setNumberForRoom(String _roomTitle)
    {
        Integer roomCounter = 0;

        for (String room : RoomDataCollector.roomTitle.keyset())
        {
            if (Objects.equals(_roomTitle))
            roomCounter += 1;
        }


        //Set ID in Hashmap
        RoomDataCollector.roomTitle.put(_roomTitle, roomCounter);

        this.roomTitle = _roomTitle;
        this.roomID = roomCounter;


    }

    public void setIdForRoom(Integer _roomID)
    {

    }

    public void setFloorForRoom(Integer _floorNumber)
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
    public void getNumberForRoom(String _roomTitle)
    {

    }

    // This should get the floor the room is located on
    public void getFloorForRoom(Integer _floorNumber)
    {

    }

    // This should get a List of all Persons associated with a room
    public List<String> getPersonsForRoom()
    {

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

    public static String getRoomAccordingToPerson(String _roomNumber) {
        String personName;

//        // searching in the Datamodel for the matching campus identites
//        roomTitle = "Krusi Boy"; // Test variable value initialisation


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


