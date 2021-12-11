package de.fherfurt.Campus;

public class Location {

    private String[] Campus= {"SCHLÜTERSTRAßE", "LEIPZIGERSTR", "ALTONAERSTRAßE"};


    private float[] Coordinates;


    public Location(String[] _Campus, float[] _Coordinates) {

        this.Campus=_Campus;
        this.Coordinates=_Coordinates;
    }


    // ----------------------------- METHODS ---------------------------------------- //
    public static String returnCampusName(String[] _geoLocation) {
        String campusName;
        // searching in Google Maps for the location and returning the campus name
        campusName = "Altonaer Straße"; // Test variable value initialisation

        return campusName;
    }

    public static String[] getCampusBuildingArray(String _campusName) {
        String[] buildings;
        // searching in the Datamodel for the matching campus identites
        buildings = new String[]{"1", "2", "3", "4"}; // Test variable value initialisation

        return buildings;
    }

    public static String[] returnFaculties(String _campusName) {
        String[] faculties;
        // searching in the Datamodel for the matching campus identites
        faculties= new String[]{"AI", "GB", "EW", "BA"}; // Test variable value initialisation

        return faculties;
    }

    public static String returnMensaLocation() {
        String mensaLocation;
        // searching in the Datamodel for the matching campus identites
        mensaLocation = "55.55.55"; // Test variable value initialisation

        return mensaLocation;
    }

    public static String returnEventLocation(String _event) {
        String eventLocation;
        // searching in the Datamodel for the matching campus identites
        eventLocation = "55.55.55"; // Test variable value initialisation

        return eventLocation;
    }
}
