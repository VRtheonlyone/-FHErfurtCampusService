package de.fherfurt.campus;
import static org.junit.jupiter.api.Assertions.*;

import de.fherfurt.campus.main.Building;
import de.fherfurt.campus.main.Campus;
import de.fherfurt.campus.main.Room;
import de.fherfurt.campus.utilities.Search;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static de.fherfurt.campus.constants.Constants.*;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Vadim Rodt, vadim.rodt@fh-erfurt.de
 * @coauthor Polina Luzina, polina.luzina@fh-erfurt.de
 * */

public class SearchTest {

    Building MyBuilding= new Building("Haus 3", Campus.Schlueter);
    Room MyRoom = new Room("Room 1", MyBuilding);
    List<String> SearchResults = new ArrayList<>();

    @Test
    @DisplayName("Search for Building results should work")
    void searchForBuildingResults() {

        //GIVEN
        String userInput = "Haus 3";

        // WHEN
        SearchResults = Search.searchForResults(userInput, BUILDING);

        //THEN
        assertEquals(Search.searchForResults("Haus 3", BUILDING), SearchResults);

    }


    @Test
    @DisplayName("Search for Room results should work")
    void searchForRoomResults() {

        //GIVEN
        String userInput = "Room 1";

        // WHEN
        SearchResults = Search.searchForResults(userInput, ROOM);

        //THEN
        assertEquals(Search.searchForResults("Room 1", ROOM), SearchResults);
    }


    @Test
    @DisplayName("Search for Campus results should work")
    void searchForCampusResults() {

        //GIVEN
        String userInput = "Leipziger Strasse";

        // WHEN
        SearchResults = Search.searchForResults(userInput, CAMPUS);

        //THEN
        assertEquals(Search.searchForResults("Leipziger Strasse", CAMPUS), SearchResults);
    }
}