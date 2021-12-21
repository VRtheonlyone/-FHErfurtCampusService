package de.fherfurt.Campus;

public class Room {

    public String[] roomNumber;
    public int floor;

    public Room(String[] _roomNumber, int _floor) {

        this.roomNumber= _roomNumber;
        this.floor= _floor;
    }


    // ----------------------------- METHODS ---------------------------------------- //
    public static String[] returnBuildingTitle(String _roomNumber) {
        String[] buildingTitle;
        // searching in the Datamodel for the matching campus identites
        buildingTitle= new String[]{"a"}; // Test variable value initialisation

        return buildingTitle;
    }

    public static String returnRoomAccordingToPerson(String _personName) {
        String roomTitle;
        // searching in the Datamodel for the matching campus identites
        roomTitle = "2"; // Test variable value initialisation

        return roomTitle;
    }

    public static String[] returnFloor (String _roomNr) {
        String[] floors;
        // searching in the Datamodel for the matching campus identites
        floors = new String[]{"(AltStr)7.2.5", "(SchStr.)1.1.1"}; // Test variable value initialisation

        return floors;
    }


}


