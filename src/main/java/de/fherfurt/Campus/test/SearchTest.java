package de.fherfurt.Campus.test;

import de.fherfurt.Campus.DataCollector;
import de.fherfurt.Campus.Search;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.fherfurt.Campus.Main.TITLE;

public class SearchTest {
    DataCollector Collector = new DataCollector();
    private final List<String> LOCATION = new ArrayList<>();
    private final List<String> BUILDING = new ArrayList<>();
    private final List<String> ROOM = new ArrayList<>();
    Search MySearch = new Search();


    @Test
    @DisplayName("Function to search for results should work")
    void searchForResults() {
        String NewSearchList= ;

        MySearch.searchForResults( _userInput, _searchFilter, Collector);
        assertEquals(MySearch.(), Collector.RoomData.get(MySearch.());
    }

    @Test
    @DisplayName("getting building assoc should work")
    void getBuildingAssoc() {
        String NewResults= ;
        MySearch.getBuildingAssoc(_searchQuery, DataCollector );
        assertEquals(MySearch.(), Collector.RoomData.get(MySearch.());
    }

    @Test
    @DisplayName("getting campus assoc should work")
    void getCampusAssoc() {
        String NewResults= ;
        MySearch.getCampusAssoc( _searchQuery, DataCollector);
        assertEquals(MySearch.(), Collector.RoomData.get(MySearch.());
    }

    @Test
    @DisplayName("Getting room assoc should work")
    void getRoomAssoc() {
        String NewResults= ;
        MySearch.getRoomAssoc( _searchQuery, DataCollector );
        assertEquals(MySearch.(), Collector.RoomData.get(MySearch.());
    }
}
