package de.fherfurt.Campus;
import java.util.*;

import static de.fherfurt.Campus.Constants.*;


public class Location implements EventsSetter {

    public enum Campuses {
        SCHLUETER {
            public String toString() {
                return "Schlüterstrasse";
            }
        },

        LEIPZIGER {
            public String toString() {
                return "Leipziger Strasse";
            }
        },

        ALTONAER {
            public String toString() {
                return "Altonaer Strasse";
            }
        }
    }

    public static Map<String, Map<String, List<String>>> getAllCampuses(DataCollector _collector)
    {
        return _collector.CampusData;
    }
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
    private String campusGeoLocation;
    private String campusTitle;
    private List<String> campusBuildings;
    private Map<String, List<String>> allData = new HashMap<>();

    public List<Object> locationEvents;


// ----------------------------- CONSTRUCTOR ---------------------------------------- //

    public Location(String campusTitle, String campusGeoLocation, List<String> campusBuildings, DataCollector _collector) {

        DataCollector.CampusCounter += 1;
        this.campusID = DataCollector.CampusCounter;

        setTitleForCampus(String.valueOf(campusTitle), _collector);
        setGeographicalCoordinatesForCampus(campusGeoLocation, _collector);
        setBuildingsForCampus(campusBuildings, _collector);

        setEvents();
    }


// ----------------------------- SETTER ----------------------------------------//

    public void setIdForCampus (Integer _campusID, DataCollector _collector) {

        this.campusID = _campusID;
        List<String> IDs = new ArrayList<>();
        IDs.add(String.valueOf(_campusID));

        this.allData.put(ID, IDs);
        _collector.CampusData.put(this.campusTitle, this.allData);
    }

    public void setGeographicalCoordinatesForCampus (String _campusGeoLocation, DataCollector _collector) {

        this.campusGeoLocation = _campusGeoLocation;
        List<String> GeoLocation = new ArrayList<>();
        GeoLocation.add(_campusGeoLocation);

        this.allData.put(GEOLOCATION, GeoLocation);
        _collector.CampusData.put(_campusGeoLocation, this.allData);
    }

    public void setTitleForCampus (String _campusTitle, DataCollector _collector) {

        this.campusTitle = _campusTitle;
        List<String> Titles = new ArrayList<>();
        Titles.add(_campusTitle);

        this.allData.put(TITLE, Titles);
        _collector.CampusData.put(this.campusTitle, this.allData);
    }

    public void setBuildingsForCampus (List<String> _campusBuildings, DataCollector _collector) {

        this.campusBuildings = _campusBuildings;

        this.allData.put(BUILDING, this.campusBuildings);
        _collector.CampusData.put(this.campusTitle, this.allData);
    }

    // ----------------------------- GETTER ---------------------------------------- //

    public Integer getCampusID() {return this.campusID;}

    public String getCampusGeoLocation() {return this.campusGeoLocation;}

    public String getCampusTitle () {return this.campusTitle;}

    public List<String> getCampusBuildings () {return this.campusBuildings;}


    // ------------------------------- DELETES ------------------------------------------ //

    public void deleteCampus(String title, DataCollector _collector)
    {
        for (String campus : _collector.CampusData.keySet()) {

            if (this.campusTitle.equals(campus)) {
                _collector.CampusData.remove(campus);
            }
        }

        this.campusID = null;
        this.campusTitle = null;
        this.campusGeoLocation = null;
        this.campusBuildings = null;
    }

    // ----------------------------- DELETES ---------------------------------------- //

    public void deleteBuildingOfCampus(String _building, DataCollector _collector) {

        this.campusBuildings.remove(_building);

        this.allData.put(BUILDING, this.campusBuildings);
        _collector.CampusData.put(this.campusTitle, this.allData);
    }



        // ----------------------------- ADD ---------------------------------------- //

    public void addBuildingToCampus(String _building, DataCollector _collector) {

        this.campusBuildings.add(_building);

        this.allData.put(BUILDING, this.campusBuildings);
        _collector.CampusData.put(this.campusTitle, this.allData);
    }


    @Override
    public void setEvents() {
        CampusUtilities.setClassEvents(LOCATION, this.getCampusTitle(), this.locationEvents);
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
}*/