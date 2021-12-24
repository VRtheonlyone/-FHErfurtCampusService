package de.fherfurt.Campus;
import java.lang.*;
import java.util.*;


public class Search {


    // getBuildingAssoc     +
    // getLocationAssoc     +
    // getRoomAssoc         +
    // ...
    //
    public static final String LOCATION = "Location";
    public static final String BUILDING = "Building";
    public static final String ROOM = "Room";


    // ----------------------------- METHODS ---------------------------------------- //



    // Mother function, which gets the input from the user and calls respectfully the search function
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
