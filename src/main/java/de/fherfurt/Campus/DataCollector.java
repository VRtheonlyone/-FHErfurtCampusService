package de.fherfurt.Campus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCollector {

    // ID Counters
    public static Integer BuildingCounter = 0;
    public static Integer RoomCounter = 0;
    public static Integer CampusCounter = 0;

    /* Inner Hashmaps */
    public Map <String, List<String>> BuildingInnerMap = new HashMap<>();
    public Map <String, List<String>> CampusInnerMap = new HashMap<>();
    public Map <String, List<String>> RoomInnerMap = new HashMap<>();

    /* Outer Hashmaps */
    public Map<String, Map<String, List<String>>> CampusData = new HashMap<>();
    public Map<String, Map<String, List<String>>> BuildingData = new HashMap<>();
    public Map<String, Map<String, List<String>>> RoomData = new HashMap<>();
}
