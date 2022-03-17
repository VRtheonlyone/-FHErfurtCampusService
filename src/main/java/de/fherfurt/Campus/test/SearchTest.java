package de.fherfurt.Campus.test;
import de.fherfurt.Campus.*;

import static org.junit.jupiter.api.Assertions.*;
import static de.fherfurt.Campus.Main.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static de.fherfurt.Campus.Main.TITLE;

public class SearchTest {

    DataCollector Collector = new DataCollector();
    private final List<String> Rooms = new ArrayList<>();
    private final List<String> Buildings = new ArrayList<>();
    private final List<String> Types = new ArrayList<>();
    private final List<String> Persons = new ArrayList<>();

    Location TestCampus = new Location(CAMPUS_1, "123.456", Buildings, Collector);
    Location TestCampus1 = new Location(CAMPUS_2, "XYsDa", Buildings, Collector);
    Building TestBuilding = new Building(true, "Haus 1", Rooms, "123.12312", Types, TestCampus1.getCampusTitle(), Collector);
    Building TestBuilding1 = new Building(true, "Haus 2", Rooms, "XYZ123", Types, TestCampus.getCampusTitle(), Collector);
    Room TestRoom = new Room("Room 1", 1, Persons, TestBuilding.getTitle(), Collector);
    Room TestRoom1 = new Room ("Room 2", 3, Persons,TestBuilding1.getTitle(), Collector);
    List<String> SearchResults = new ArrayList<>();

    @Test
    @DisplayName("Search for Building results should work")
    void searchForBuildingResults() {

        String SearchBuilding = "Haus 1";

            for (String Key : Collector.BuildingData.get(SearchBuilding).keySet()) {
                if (Collector.BuildingData.get(SearchBuilding).get(Key) != null) {
                    SearchResults.addAll(Collector.BuildingData.get(SearchBuilding).get(Key));
                }
            }
        System.out.println(SearchResults);
        assertEquals(Search.searchForResults(SearchBuilding, BUILDING, Collector), SearchResults);
    }

    @Test
    @DisplayName("Search for Room results should work")
    void searchForRoomResults() {

        String SearchRoom = "Room 1";

        for (String Key : Collector.RoomData.get(SearchRoom).keySet())
        {
            if (Collector.RoomData.get(SearchRoom).get(Key) != null)
            {
                SearchResults.addAll(Collector.RoomData.get(SearchRoom).get(Key));
            }
        }
        System.out.println(SearchResults);
        assertEquals(Search.searchForResults(SearchRoom, ROOM, Collector), SearchResults);
    }

    @Test
    @DisplayName("Search for Campus results should work")
    void searchForCampusResults() {

        String SearchCampus = CAMPUS_1;

        for (String Key : Collector.CampusData.get(SearchCampus).keySet())
        {
            if (Collector.CampusData.get(SearchCampus).get(Key) != null)
            {
                SearchResults.addAll(Collector.CampusData.get(SearchCampus).get(Key));
            }
        }
        System.out.println(SearchResults);
        assertEquals(Search.searchForResults(SearchCampus, LOCATION, Collector), SearchResults);
    }
}