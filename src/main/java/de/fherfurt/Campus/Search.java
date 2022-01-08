package de.fherfurt.Campus;
import java.lang.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map.Entry;


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

        // ----------------------- 4 the most important variables in this method -------------- //

        // ----------------------- our data -------------- //
        HashMap buildingGeoLocations = (HashMap) Main.BuildingDataCollector.buildingsGeoLocations; // our Data
        HashMap buildingRooms = (HashMap) Main.BuildingDataCollector.buildingsRooms;
        HashMap buildingIdNumbers = (HashMap) Main.BuildingDataCollector.buildingsIdNumbers;
        // -------------------------------------------------------------------------------------------

        List<String> results = new ArrayList<>(); // will be out final output
        // -------------------------------------------------------------------------------------------

//        for (String dbResult : buildingDataCollection) {
//            if (dbResult.contains(_searchQuery)) {
//                results.add(dbResult);
//            }
//        }


        for(Entry<String, String> entry: buildingGeoLocations.entrySet()) {

            // if give value is equal to value from entry
            // print the corresponding key
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

        for (String dbResult : database) {
            if (dbResult.contains(_searchQuery)) {
                results.add(dbResult);
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

        for (String dbResult : database) {
            if (dbResult.contains(_searchQuery)) {
                results.add(dbResult);
            }
        }
        if (results.size() == 0) {
            results.add("No search pattern found!");
        }
        return results;
    }

    // ________________________________________________________________________

}
