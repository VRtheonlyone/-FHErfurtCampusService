package de.fherfurt.Campus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildingDataCollection extends GeneralDataCollection {

    // Hashmap of Building Title as Keys and Coordinates as Values
    public Map<String, String> buildingsGeoLocations = new HashMap<>();

    // Hashmap of Building and all the Rooms that are in that building
    public Map <String, List<String>> buildingsRooms = new HashMap<>();

    // Hashmap of Building and ID Number associated with that building
    public Map <String, Integer> buildingsIdNumbers = new HashMap<>();
}
