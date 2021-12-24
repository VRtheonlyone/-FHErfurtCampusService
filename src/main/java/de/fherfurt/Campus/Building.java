package de.fherfurt.Campus;
import java.util.*;
import java.io.*;

public class Building {


    // setGeoLocationForBuilding    +
    // getGeoLocationForBuilding    +
    // getRoomsForBuilding          +
    // setRoomsForBuilding          +
    // deleteBuilding               -
    // deleteRoomFromBuilding       -
    //
    // ...

    //-------------------------------ATTRIBUTES----------------------------------//
    // Is building accessible for people with disability(-ies)
    private boolean buildingAccessibility;

    // Name of the building
    private String buildingTitle;

    // Id Number of Building
    private String buildingID;

    // List of Rooms for Building
    private final List<String> buildingRooms;

    // Geographical Coordinates of Building
    private String buildingGeolocation;

    // List of all Building Types
    public String[] buildingType;

    // ["h1" -> "92.000"]
    // Hashmap of Building Title as Keys and Coordinates as Values --> Iterate through it later for
    public Map <String, String> buildingsGeoLocations = new HashMap<>();

    // Hashmap of Building and all the Rooms that are in that building
    public Map <String, List<String>> buildingsRooms = new HashMap<>();

    // Hashmap of Building and Housenumber/ID Number associated with that building
    public Map <String, String> buildingsIdNumbers = new HashMap<>();
    //---------------------------------------------------------------------------------------------------//

         
    // ----------------------------------- CONSTRUCTOR ---------------------------------------------
    public Building(boolean _accessibility, String _buildingTitle, String _buildingID, List<String> _buildingRooms, String _buildingGeoLocation, String[] _buildingType ) {

        this.buildingAccessibility =_accessibility; // ["h1" -> true,...]
        this.buildingID = _buildingID; // ["h1" -> "1",...]
        this.buildingTitle = _buildingTitle; // ["h1" -> "1",...]
        this.buildingRooms = _buildingRooms; // ["h1" -> "1",...]
        this.buildingGeolocation = _buildingGeoLocation; // ["h1" -> "1",...]
        this.buildingType = _buildingType; // ["h1" -> "1",...]

        setRoomsForBuilding(_buildingTitle, _buildingRooms);
        setGeoLocationForBuilding(_buildingTitle, _buildingGeoLocation);
    }
    // ---------------------------------------------------------------------------------------------


    // ----------------------------- METHODS ---------------------------------------- //
    
    // Sets GeoLocation for a Building  
    public void setGeoLocationForBuilding (String _building, String _geoLocation )
    {
        /*setGeoLocationForBuilding("Haus 1", "50.985240084429115, 11.041292569004435");
          setGeoLocationForBuilding("Haus 2", "50.985584461800975, 11.041992821261253");
          setGeoLocationForBuilding("Haus 3", "50.98586156057369, 11.04266584842783");
          setGeoLocationForBuilding("Haus 4", "50.985560366177346, 11.04324318452807");
          setGeoLocationForBuilding("Haus 5", "50.9852772416624, 11.04343456663906");
          setGeoLocationForBuilding("Haus 6", "50.98465755404599, 11.042369903901514");
          setGeoLocationForBuilding("Haus 7.1", "50.98499967276536, 11.041328495234687");
          setGeoLocationForBuilding("Haus 7.2", "50.98467437668884, 11.04169212129085"); 
          setGeoLocationForBuilding("Haus 8", "50.98424436822474, 11.042615749030142");
          setGeoLocationForBuilding("Haus 9", "50.984326721703624, 11.043102928387238");
          setGeoLocationForBuilding("Haus 10", "50.98468169193163, 11.043808887383472");
          setGeoLocationForBuilding("Haus 11", "50.9853510377372, 11.043916608466834");
          setGeoLocationForBuilding("Haus 12", "50.98602812197842, 11.04319241201106");
         */

        for (String building : this.buildingsGeoLocations.keySet())
        {           
            // Checks if building is an already existing key
            if (_building == building)
            {
                //Replace old geolocation with new entry
                this.buildingsGeoLocations.replace(_building, _geoLocation);
                System.out.println (String.format("GeoLocation: %g  for Building %b has been added", _geoLocation, _building));
                return;
            }
        } 

        //Adds new building/geoLocation key/value pair
        this.buildingsGeoLocations.put(_building,_geoLocation);
        return;
    }

    // Returns Geographical Location of a building as a String
    public String getGeoLocationForBuilding (String _building)
    {   
        // converts the first letter of input into an uppercase character, so that it matches the key entry in the Hashmap --> "haus1" = "Haus1"
        _building = _building.substring(0,1).toUpperCase() + _building.substring(1).toLowerCase();

        // Define Dummy String that is empty
        String myGeoLocation = new String();

        // Search in Hashmap of Buildings/Coordinates, if there is a key associated with the input
        for(String building : this.buildingsGeoLocations.keySet())
        {   
            // if there is a match between the input and one of the keys in the Hashmap
            if (_building.equals(building))
            {
                // Set the current dummy string to the value of the key and return the result
                myGeoLocation = this.buildingsGeoLocations.get(building);
                return myGeoLocation;
            }
        }
        // Else, Set String to an error message if no matching key was found
        return myGeoLocation = "Sorry, but there is currently no Geographical location associated with that building";
    }

    // Gets List of all Rooms associated with a building
    public List<String> getRoomsForBuilding (String _building)
    {
        // Define an empty List of Strings
        List <String> roomList = new ArrayList<String>();

        // Iterate through the hashmap

        for(String building : this.buildingsRooms.keySet())
        {
            // Check whether input String matches key in the array
            if (Objects.equals(_building, building))
            {   
                // Add all values associated with key to the list
                roomList.addAll(this.buildingsRooms.get(building));
                
                // return List of all Rooms for the respective building
                return roomList;
            }
        }

        roomList.add("There are currently no rooms associated with this building");
        return roomList;
    }

    // Sets the rooms to the building
    public void setRoomsForBuilding (String _building, List<String> _Rooms)
    {
        // iterates through all the keys in the existing Hashmap
        for (String building : this.buildingsRooms.keySet())
        {           
            // Checks if building is an already existing key and updates the value
            if (Objects.equals(_building, building))
            {
                //for every Room in the list that was passed
                for (String newRoom : _Rooms)
                {
                    // CHECK CHECK CHECK!!! for every Room in the existing List for the Building
                    for(String existingRoom : this.buildingsRooms.get(_building))
                    {
                        // check, if the specific Room already exist
                        if(Objects.equals(newRoom, existingRoom))
                        {
                            // Remove the Room from the existing list, so that it can be added later together with all the other rooms
                            this.buildingRooms.remove(existingRoom);
                            System.out.println (String.format("Room: %g for Building %b does already exist and has therefore been deleted from the existing list", existingRoom, _building));
                        }
                    }

                    // Add the new room to the existing list
                    this.buildingRooms.add(newRoom);
                    System.out.println (String.format("Room: %g for Building %b been added", newRoom, _building));
                }
                // If match between input and existing building has been found, list entry will be edited --> No need to add another entry
                return;
            } 
        }
        // Adds new building/geoLocation key/value pair
        this.buildingsRooms.put(_building, _Rooms);
    }

}

