package de.fherfurt.campus.main;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCollector {

    private static Map<String, Map<String, List<String>>> CampusData = new HashMap<>();
    private static Map<String, Map<String, List<String>>> BuildingData = new HashMap<>();
    private static Map<String, Map<String, List<String>>> RoomData = new HashMap<>();
    private static Map<String, Map<String, String>> Events = new HashMap<>(); // -> wird aufgrund von Appointment-Teams Daten aufgefüllt

    public static void setCampusData(Map<String, Map<String, List<String>>> _campusData) {
        CampusData = _campusData;
    }
    public static void setBuildingData(Map<String, Map<String, List<String>>> _buildingData) {BuildingData = _buildingData;}
    public static void setRoomData(Map<String, Map<String, List<String>>> _roomData) {
        RoomData = _roomData;
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
