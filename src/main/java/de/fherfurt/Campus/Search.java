package de.fherfurt.Campus;
import java.lang.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map.Entry;

import static de.fherfurt.Campus.Main.BuildingDataCollector;
import static de.fherfurt.Campus.Main.RoomDataCollector;
import static de.fherfurt.Campus.Main.LocationDataCollector;





public class Search {


    // getBuildingAssoc     +
    // getLocationAssoc     +
    // getRoomAssoc         +
    // ...
    //
    public static final String LOCATION = "Location";
    public static final String BUILDING = "Building";
    public static final String ROOM = "Room";

    // Hier werden die lokalen variablen aus der Main zugewiesen
    public Object BuildingCollection = Main.BuildingDataCollector;
    public Object RoomCollection = Main.RoomDataCollector;
    public Object LocationCollection = Main.LocationDataCollector;

    // ----------------------------- METHODS ---------------------------------------- //



    // Mother function, which gets the input from the user and calls the search function
    public static List<String> searchForResults(String _userInput, String searchFilter) {

        List<String> searchList = new ArrayList<>();

        if (_userInput.length() != 0) {
            switch (searchFilter) {
                case ROOM -> searchList = getRoomAssoc(_userInput);
                case BUILDING -> searchList = getBuildingAssoc(_userInput);
                case LOCATION -> searchList = getLocationAssoc(_userInput);
            }
        }
        else {
            searchList.add("Nothing found (no input)");
        }

        return searchList;
    }


    // ________________________________________________________________________
    // THIS IS THE SEARCH FUNCTIONS AREA
    // ________________________________________________________________________

    // this function returns the values from the db, which are associated with Buiildings
    public static List<String> getBuildingAssoc(String _searchQuery) {

        List<String> results = new ArrayList<>(); // will be out final output


//        Raum 1
//                Key    value
//            - Haus 1: Raum 1
//            - Haus 2: Raum 1

        for(Entry<String, String> entry: BuildingDataCollector.buildingsGeoLocations.entrySet()) {

            if(Objects.equals(entry.getValue(), _searchQuery)) {
                results.add(_searchQuery + " found in " + entry.getKey());
            }
        }
        for(Entry<String, List<String>> entry: BuildingDataCollector.buildingsRooms.entrySet()) {

            if(Objects.equals(entry.getValue(), _searchQuery)) {
                results.add(_searchQuery + " found in " + entry.getKey());
            }
        }
        for(Entry<String, Integer> entry: BuildingDataCollector.buildingsIdNumbers.entrySet()) {

            if(Objects.equals(entry.getValue(), _searchQuery)) {
                results.add(_searchQuery + " found in " + entry.getKey());
            }
        }
        if (results.size() == 0) {
            results.add("No search pattern found!");
        }
        return results;
    }

    // this function returns the values from the db, which are associated with Locations
    public static List<String> getLocationAssoc(String _searchQuery) {

        List<String> results = new ArrayList<>();

        // -------------------------------------------------------------------------------------------
        // this variable is a TEST one and will be removed in the later stages of project development
        List<String> database = new ArrayList<>();
        Collections.addAll(database, "a1", "a2", "a3");
        // -------------------------------------------------------------------------------------------

        for(Entry<String, List<String>> entry: LocationDataCollector.campusBuildings.entrySet()) {

            if(Objects.equals(entry.getValue(), _searchQuery)) {
                results.add(_searchQuery + " found in " + entry.getKey());
            }
        }
        for(Entry<String, String> entry: LocationDataCollector.campusCoordinates.entrySet()) {

            if(Objects.equals(entry.getValue(), _searchQuery)) {
                results.add(_searchQuery + " found in " + entry.getKey());
            }
        }
        for(Entry<String, List<String>> entry: RoomDataCollector.roomPersons.entrySet()) {

            if(Objects.equals(entry.getValue(), _searchQuery)) {
                results.add(_searchQuery + " found in " + entry.getKey());
            }
        }
        if (results.size() == 0) {
            results.add("No search pattern found!");
        }
        return results;
    }

    // this function returns the values from the db, which are associated with Rooms
    public static List<String> getRoomAssoc(String _searchQuery) {

        List<String> results = new ArrayList<>();

        // -------------------------------------------------------------------------------------------
        // this variable is a TEST one and will be removed in the later stages of project development
        List<String> database = new ArrayList<>();
        Collections.addAll(database, "a1", "a2", "a3");
        // -------------------------------------------------------------------------------------------

        for(Entry<String, Integer> entry: RoomDataCollector.roomID.entrySet()) {

            if(Objects.equals(entry.getValue(), _searchQuery)) {
                results.add(_searchQuery + " found in " + entry.getKey());
            }
        }
        for(Entry<String, List<String>> entry: RoomDataCollector.roomPersons.entrySet()) {

            if(Objects.equals(entry.getValue(), _searchQuery)) {
                results.add(_searchQuery + " found in " + entry.getKey());
            }
        }
        for(Entry<String, Integer> entry: RoomDataCollector.roomTitle.entrySet()) {

            if(Objects.equals(entry.getValue(), _searchQuery)) {
                results.add(_searchQuery + " found in " + entry.getKey());
            }
        }
        if (results.size() == 0) {
            results.add("No search pattern found!");
        }
        return results;
    }

    // ________________________________________________________________________

}
