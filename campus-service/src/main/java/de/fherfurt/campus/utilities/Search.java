package de.fherfurt.campus.utilities;
import de.fherfurt.campus.main.DataCollector;

import java.lang.*;
import java.util.*;

import static de.fherfurt.campus.constants.Constants.*;
/**
 * class responsible for user search for results, associated with main classes of the project: location, building, room
 */
public class Search {
    // ----------------------------- METHODS ---------------------------------------- //


    /**
     * Mother function, which gets the input from the user and calls the search function
     *
     * @param userInput     the search input of the user
     * @param searchFilter  filter of the search, which shall be implemented
     * @return              the results, based on filters
     */
    public static List<String> searchForResults(String userInput, String searchFilter) {

        List<String> searchList = new ArrayList<>();

        if (userInput.length() != 0) {
            switch (searchFilter) {
                case ROOM -> searchList = getRoomAssoc(userInput);
                case BUILDING -> searchList = getBuildingAssoc(userInput);
                case LOCATION -> searchList = getCampusAssoc(userInput);
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


    /**
     * this function returns the values from the db, which are associated with Buildings
     *
     * @param searchQuery   the search input of the user
     * @return              results, associated with the search input
     */
    public static List<String> getBuildingAssoc(String searchQuery) {

        /* will be out final output */
        List<String> results = new ArrayList<>();

        /* for each building in the Building Data Hashmap */
        for (String building : DataCollector.getBuildingData().keySet()) {

            /* If a building was found that matches the search string */
            if(Objects.equals(building, searchQuery)) {

                /* Add all the information associated with the key to the string List */
                for (String Key : DataCollector.getBuildingData().get(searchQuery).keySet()){

                    if (DataCollector.getBuildingData().get(searchQuery).get(Key) != null) {

                        results.addAll(DataCollector.getBuildingData().get(searchQuery).get(Key));
                    }
                }
            }
        }

        if (results.size() == 0) {
            results.add(NO_SEARCH_PATTERN);
        }
        return results;
    }


    /**
     * this function returns the values from the db, which are associated with Locations
     *
     * @param searchQuery   the search input of the user
     * @return              results, associated with the search input
     */
    public static List<String> getCampusAssoc(String searchQuery) {

        /* Dummy List */
        List<String> results = new ArrayList<>();

        /* for each Campus in the CampusData Hashmap */
        for (String campus : DataCollector.getCampusData().keySet()) {

            /* If a campus was found that matches the search string */
            if(Objects.equals(campus, searchQuery)) {

                /* Add all the information associated with the key to the string List */
                for (String Key : DataCollector.getCampusData().get(searchQuery).keySet()) {

                    if (DataCollector.getCampusData().get(searchQuery).get(Key) != null) {
                        results.addAll(DataCollector.getCampusData().get(searchQuery).get(Key));
                    }
                }
            }
        }

        if (results.size() == 0) {
            results.add(NO_SEARCH_PATTERN);
        }
        return results;
    }


    /**
     * this function returns the values from the db, which are associated with Rooms
     *
     * @param searchQuery   the search input of the user
     * @return              results, associated with the search input
     */
    public static List<String> getRoomAssoc(String searchQuery) {

        /* Dummy List */
        List<String> results = new ArrayList<>();

        /* for each building in the Building Data Hashmap */
        for (String room : DataCollector.getRoomData().keySet()) {

            /* If a building was found that matches the search string */
            if(Objects.equals(room, searchQuery)) {

                /* Add all the information associated with the key to the string List */
                for (String Key : DataCollector.getRoomData().get(searchQuery).keySet()) {

                    if (DataCollector.getRoomData().get(searchQuery).get(Key) != null) {
                        results.addAll(DataCollector.getRoomData().get(searchQuery).get(Key));
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
