package de.fherfurt.Campus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCollector {

    /* ID Counters */
    public static Integer BuildingCounter = 0;
    public static Integer RoomCounter = 0;
    public static Integer CampusCounter = 0;

    /* Outer Hashmaps */
    public Map<String, Map<String, List<String>>> CampusData = new HashMap<>();
    public Map<String, Map<String, List<String>>> BuildingData = new HashMap<>();
    public Map<String, Map<String, List<String>>> RoomData = new HashMap<>();

    /* Events */
    public Map<String, List<String>> Events = new HashMap<>(); // -> wird aufgrund von Appointment-Teams Daten aufgefüllt



    // Events = ['event1' = ['location', 'building', 'Room'], 'event2' = [...]]

    // Events = [
    //          'event1' => ['startdate' => '23.02.03', 'enddate' => '24.02.03', 'location' => 'Altonaer Straße'],
    //          'event2' => ['...' => '...', ... ],
    //          '..' => [...]
    //          ]
}
