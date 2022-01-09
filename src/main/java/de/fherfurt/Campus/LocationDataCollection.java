package de.fherfurt.Campus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationDataCollection extends GeneralDataCollection{

    //Hashmap of Campuses and their respective geographical coordinates for search with Google Maps
    public Map<String, String> campusCoordinates = new HashMap<String, String>();

    //Hashmap of Campuses and their Buildings
    public Map <String, List<String>> campusBuildings = new HashMap();

    //Hashmap of Campuses and their faculties
    public Map <String, List<String>> campusFaculties = new HashMap();

}
