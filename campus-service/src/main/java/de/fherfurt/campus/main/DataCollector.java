package de.fherfurt.campus.main;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Vadim Rodt, vadim.rodt@fh-erfurt.de
 * The DataCollector class collects the data from the main classes: Campus, Building, Room
 **/

public class DataCollector {

    private static Map<String, Map<String, List<String>>> CampusData = new HashMap<>();
    private static Map<String, Map<String, List<String>>> BuildingData = new HashMap<>();
    private static Map<String, Map<String, List<String>>> RoomData = new HashMap<>();
    private static Map<String, Map<String, String>> Events = new HashMap<>();

    public static void setCampusData(Map<String, Map<String, List<String>>> campusData) {
        CampusData = campusData;
    }
    public static void setBuildingData(Map<String, Map<String, List<String>>> buildingData) {BuildingData = buildingData;}
    public static void setRoomData(Map<String, Map<String, List<String>>> roomData) {
        RoomData = roomData;
    }
    public static void setEvents(Map<String, Map<String, String>> events) {Events = events;}

    public static Map<String, Map<String, List<String>>> getBuildingData() {
        return BuildingData;
    }
    public static Map<String, Map<String, List<String>>> getCampusData() {
        return CampusData;
    }
    public static Map<String, Map<String, List<String>>> getRoomData() {
        return RoomData;
    }
    public static Map<String, Map<String, String>> getEvents() {
        return Events;
    }

}
