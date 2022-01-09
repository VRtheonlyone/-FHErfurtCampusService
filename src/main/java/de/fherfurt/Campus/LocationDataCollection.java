package de.fherfurt.Campus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationDataCollection extends GeneralDataCollection{

    //Hashmap of Campuses and their respective geographical coordinates for search with Google Maps
    private Map<String, String> campusCoordinates = new HashMap<String, String>();

    //Hashmap odf Campuses and their respective geographical coordinates for search with Google Maps
    private Map <String, List<String>> campusBuildings = new HashMap();

}
