package de.fherfurt.Campus;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Building {

        //Check if building is accessible for handicapped people
        public boolean accessibility;

        //List of all Building Types
        public String[] buildingType={"Mensa", "Sporthalle", "Lehrgebäude", "Bibliothek","Theater","Laborhalle", "Audimax", "Information Desk"};

        //Hashmap of Building Title as Keys and Coordinates as Values
        public Map <String, String> buildingGeoLocation = new HashMap <String, String>();

        //Hashmap of Building and all the Rooms that are in that building
        public Map <String, List<String>> roomsInBuilding = new HashMap<>();

    
         

    public Building(boolean _accessibility, String[] _buildingType, Map <String,String> _buildingGeoLocation, Map <String, List<String>> _roomsInBuilding) {

        this.accessibility =_accessibility;
        this.buildingType =_buildingType;
        this.buildingGeoLocation = _buildingGeoLocation;
        this.roomsInBuilding = _roomsInBuilding;

    }


    // ----------------------------- METHODS ---------------------------------------- //
    
    //Sets GeoLocation for a Building  
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

        for (String building : this.buildingGeoLocation.keySet())
        {           
            // Checks if building is an already existing key and updates the value
            if (_building == building)
            {
                this.buildingGeoLocation.replace(building, _geoLocation);
                return;
            }
        } 

        //Adds new building/geoLocation key/value pair
        this.buildingGeoLocation.put(_building,_geoLocation);
        return;
    }

    //Gets List of all Rooms associated with a building
    public List<String> getRoomsForBuilding (String _building)
    {
        //Define a List of Strings to fill 
        List <String> roomList = new ArrayList<String>();

        //Iterate through array 
        for(String building : this.roomsInBuilding.keySet())
        {
            //Check whether input String matches key in the array
            if (_building == building)
            {   
                //Add all values associated with key to the list
                roomList.addAll(this.roomsInBuilding.get(building));
                
                //return List of Rooms
                return roomList;
            }
        }
        
        return roomList;
    }
    {

    }

    public static String getHouseNumber(String[] _geoLocation) {
        String houseNr;
        // searching in the Database for the location and returning the house number
        houseNr = "2"; // Test variable value initialisation

        return houseNr;
    }

    public static String getGeoLocation(String[] _houseNumber) {
        String geoLocation;
        // searching in the Database for the location and returning the house number
        geoLocation = "222.333"; // Test variable value initialisation

        return geoLocation;
    }
}

