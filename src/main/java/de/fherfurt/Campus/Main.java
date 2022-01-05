package de.fherfurt.Campus;
import java.lang.*;

public class Main {

    public static final BuildingDataCollection BuildingDataCollector = new BuildingDataCollection();
    public static final LocationDataCollection LocationDataCollector = new LocationDataCollection(); //--> Helen
    public static final RoomDataCollection RoomDataCollector = new RoomDataCollection(); //--> Jann


    public static final String LOCATION = "Location";
    public static final String BUILDING = "Building";
    public static final String ROOM = "Room";

    public static void main(String[] args) {
        Object Search = new Search();
        System.out.println(de.fherfurt.Campus.Search.searchForResults("1", ROOM));
    }
}
