package de.fherfurt.Campus;
import java.lang.*;
import java.util.*;

import static de.fherfurt.Campus.Constants.*;

public class Search {


    // ----------------------------- METHODS ---------------------------------------- //

    // Mother function, which gets the input from the user and calls the search function
    public static List<String> searchForResults(String _userInput, String _searchFilter, DataCollector _collector) {

        List<String> searchList = new ArrayList<>();

        if (_userInput.length() != 0) {
            switch (_searchFilter) {
                case ROOM -> searchList = getRoomAssoc(_userInput, _collector);
                case BUILDING -> searchList = getBuildingAssoc(_userInput, _collector);
                case LOCATION -> searchList = getCampusAssoc(_userInput, _collector);
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

    // this function returns the values from the db, which are associated with Buildings
    public static List<String> getBuildingAssoc(String _searchQuery, DataCollector _collector) {

        // will be out final output
        List<String> results = new ArrayList<>();

        // for each building in the Building Data Hashmap
        for (String building : _collector.BuildingData.keySet()) {

            // If a building was found that matches the search string
            if(Objects.equals(building, _searchQuery)) {

                // Add all the information associated with the key to the string List
                for (String Key : _collector.BuildingData.get(_searchQuery).keySet()){

                    if (_collector.BuildingData.get(_searchQuery).get(Key) != null) {

                        results.addAll(_collector.BuildingData.get(_searchQuery).get(Key));
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
    public static List<String> getCampusAssoc(String _searchQuery, DataCollector _collector) {

        // Dummy List
        List<String> results = new ArrayList<>();

        // for each Campus in the CampusData Hashmap
        for (String campus : _collector.CampusData.keySet()) {

            // If a campus was found that matches the search string
            if(Objects.equals(campus, _searchQuery)) {

                // Add all the information associated with the key to the string List
                for (String Key : _collector.CampusData.get(_searchQuery).keySet()) {

                    if (_collector.CampusData.get(_searchQuery).get(Key) != null) {
                        results.addAll(_collector.CampusData.get(_searchQuery).get(Key));
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
    public static List<String> getRoomAssoc(String _searchQuery, DataCollector _collector) {

        // Dummy List
        List<String> results = new ArrayList<>();

        // for each building in the Building Data Hashmap
        for (String room : _collector.RoomData.keySet()) {

            // If a building was found that matches the search string
            if(Objects.equals(room, _searchQuery)) {

                // Add all the information associated with the key to the string List
                for (String Key : _collector.RoomData.get(_searchQuery).keySet()) {

                    if (_collector.RoomData.get(_searchQuery).get(Key) != null) {
                        results.addAll(_collector.RoomData.get(_searchQuery).get(Key));
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
