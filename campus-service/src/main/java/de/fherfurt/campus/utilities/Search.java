package de.fherfurt.campus.utilities;
import de.fherfurt.campus.main.DataCollector;

import java.lang.*;
import java.util.*;

import static de.fherfurt.campus.constants.Constants.*;

public class Search {


    // ----------------------------- METHODS ---------------------------------------- //

    // Mother function, which gets the input from the user and calls the search function
    public static List<String> searchForResults(String _userInput, String _searchFilter) {

        List<String> searchList = new ArrayList<>();

        if (_userInput.length() != 0) {
            switch (_searchFilter) {
                case ROOM -> searchList = getRoomAssoc(_userInput);
                case BUILDING -> searchList = getBuildingAssoc(_userInput);
                case LOCATION -> searchList = getCampusAssoc(_userInput);
            }
        }
        else {
            searchList.add("Nothing found (no input)");
        }

        return searchList;
    }

    public static final String NO_SEARCH_PATTERN = "No search Pattern found!";
    // ________________________________________________________________________
    // THIS IS THE SEARCH FUNCTIONS AREA
    // ________________________________________________________________________

    // this function returns the values from the db, which are associated with Buildings
    public static List<String> getBuildingAssoc(String _searchQuery) {

        // will be out final output
        List<String> results = new ArrayList<>();

        // for each building in the Building Data Hashmap
        for (String building : DataCollector.getBuildingData().keySet()) {

            // If a building was found that matches the search string
            if(Objects.equals(building, _searchQuery)) {

                // Add all the information associated with the key to the string List
                for (String Key : DataCollector.getBuildingData().get(_searchQuery).keySet()){

                    if (DataCollector.getBuildingData().get(_searchQuery).get(Key) != null) {

                        results.addAll(DataCollector.getBuildingData().get(_searchQuery).get(Key));
                    }
                }
            }
        }

        if (results.size() == 0) {
            results.add(NO_SEARCH_PATTERN);
        }
        return results;
    }

    // this function returns the values from the db, which are associated with Locations
    public static List<String> getCampusAssoc(String _searchQuery) {

        // Dummy List
        List<String> results = new ArrayList<>();

        // for each Campus in the CampusData Hashmap
        for (String campus : DataCollector.getCampusData().keySet()) {

            // If a campus was found that matches the search string
            if(Objects.equals(campus, _searchQuery)) {

                // Add all the information associated with the key to the string List
                for (String Key : DataCollector.getCampusData().get(_searchQuery).keySet()) {

                    if (DataCollector.getCampusData().get(_searchQuery).get(Key) != null) {
                        results.addAll(DataCollector.getCampusData().get(_searchQuery).get(Key));
                    }
                }
            }
        }

        if (results.size() == 0) {
            results.add(NO_SEARCH_PATTERN);
        }
        return results;
    }

    // this function returns the values from the db, which are associated with Rooms
    public static List<String> getRoomAssoc(String _searchQuery) {

        // Dummy List
        List<String> results = new ArrayList<>();

        // for each building in the Building Data Hashmap
        for (String room : DataCollector.getRoomData().keySet()) {

            // If a building was found that matches the search string
            if(Objects.equals(room, _searchQuery)) {

                // Add all the information associated with the key to the string List
                for (String Key : DataCollector.getRoomData().get(_searchQuery).keySet()) {

                    if (DataCollector.getRoomData().get(_searchQuery).get(Key) != null) {
                        results.addAll(DataCollector.getRoomData().get(_searchQuery).get(Key));
                    }
                }
            }
        }

        if (results.size() == 0) {
            results.add(NO_SEARCH_PATTERN);
        }
        return results;
    }

    // ________________________________________________________________________

}
