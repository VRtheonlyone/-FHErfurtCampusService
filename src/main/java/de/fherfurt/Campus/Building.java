package de.fherfurt.Campus;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Building {

        //Check if building is accessible for handicapped people
        public boolean accessibility;

        //List of all Building Types
        public String[] buildingType={"Mensa", "Sporthalle", "Lehrgebäude", "Bibliothek","Theater","Laborhalle", "Audimax", "Information Desk"};

        //Hashmap of Building numbers and their respective GeoLocations
        public Map <String, String> buildingGeoLocation = new HashMap <String, String>();

        
        //To store values in map:
        //public buildingGeoLocation.put("Haus1", "234.243.23");
         


    public Building(boolean _accessibility, String[] _buildingType, Map <String,String> _buildingGeoLocation) {

        this.accessibility =_accessibility;
        this.buildingType =_buildingType;
        this.buildingGeoLocation = _buildingGeoLocation;

        
    }


    // ----------------------------- METHODS ---------------------------------------- //
    public static String returnHouseNumber(String[] _geoLocation) {
        String houseNr;
        // searching in the Database for the location and returning the house number
        houseNr = "2"; // Test variable value initialisation

        return houseNr;
    }

    public static String returnGeoLocation(String[] _houseNumber) {
        String geoLocation;
        // searching in the Database for the location and returning the house number
        geoLocation = "222.333"; // Test variable value initialisation

        return geoLocation;
    }
}

