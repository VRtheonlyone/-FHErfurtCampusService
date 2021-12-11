package de.fherfurt.Campus;

public class Building {
        public boolean accessibility;
        public String[] buildingType={"MENSA", "SPORTHALLE", "LEHRGEBÄUDE", "BIBLIOTHEK"};

    public Building(boolean _accessibility, String[] _buildingType) {

        this.accessibility=_accessibility;
        this.buildingType=_buildingType;
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

