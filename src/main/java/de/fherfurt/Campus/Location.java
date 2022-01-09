package de.fherfurt.Campus;
import java.util.List;
import java.util.*;

public class Location {

    // getCampus            -
    // setCampus            -
    // getCampusBuildings   -
    // setCampusBuildings   -
    // getFaculties         -
    // getMensaLocation     -       AUSLASSEN
    // getEventLocation     -       AUSLASSEN
    // ...

// ----------------------------- ATTRIBUTES ---------------------------------------- //

    private Integer campusID;

    private final String[] Campus = {"SCHLÜTERSTRASSE", "LEIPZIGERSTRASSE", "ALTONAERSTRASSE"};

    // Geographical Coordinates of the campus
    private String campusGeoLocation;

    //
    private String campusTitle;

    // List of Rooms for Building
    private List<String> campusBuildings;

// ----------------------------- CONSTRUCTOR ---------------------------------------- //

    public Location(Integer _campusID,String _campusTitle, String _campusGeoLocation, List<String> _campusBuildings) {

        this.campusID = _campusID;
        this.campusTitle = _campusTitle;
        this.campusGeoLocation = _campusGeoLocation;
        this.campusBuildings = _campusBuildings;

        // setIdForCampus(_campusTitle, _campusID);
        // setGeoLocationForCampus(_campusTitle, _campusGeoLocation);
        // setIdForCampus(_campusTitle);
    }


}


    // ----------------------------- METHODS ---------------------------------------- //



    /*
    public static String getCampus(String[] _geoLocation) {
        String campusName;
        // searching in Google Maps for the location and returning the campus name
        campusName = "Altonaer Straße"; // Test variable value initialisation

        return campusName;
    }

    public static String[] getCampusBuildings(String _campusName) {
        String[] buildings;
        // searching in the Datamodel for the matching campus identites
        buildings = new String[]{"1", "2", "3", "4"}; // Test variable value initialisation

        return buildings;
    }

    public static String[] getFaculties(String _campusName) {
        String[] faculties;
        // searching in the Datamodel for the matching campus identites
        faculties= new String[]{"AI", "GB", "EW", "BA"}; // Test variable value initialisation

        return faculties;
    }

    


    public static String getMensaLocation() {
        String mensaLocation;
        // searching in the Datamodel for the matching campus identites
        mensaLocation = "55.55.55"; // Test variable value initialisation

        return mensaLocation;
    }

    public static String getEventLocation(String _event) {
        String eventLocation;
        // searching in the Datamodel for the matching campus identites
        eventLocation = "55.55.55"; // Test variable value initialisation

        return eventLocation;
    }

*/