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
}
