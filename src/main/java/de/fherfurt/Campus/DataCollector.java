package de.fherfurt.Campus;
import de.fherfurt.Campus.Events.Event;

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

    /* Specific Event map */
    public Map<String, String> Event = new HashMap<>();

    /* Events map */
    public static Map<String, Map<String, String>> Events = new HashMap<>();

    public DataCollector() {
        Event.put(Constants.EVENT_START_DATE, "20.03.2023");
        Event.put(Constants.EVENT_END_DATE, "20.04.2023");
        Event.put(Constants.EVENT_TITLE, "Geburtstag von Vadim");
        Event.put(Constants.LOCATION, Constants.CAMPUS_ALT);
        Event.put(Constants.BUILDING, "Haus 2");
        Event.put(Constants.ROOM, "Raum 2");

        Events.put("Vadims GB", Event);
    }
}


    // Events = ['event1' = ['location', 'building', 'Room'], 'event2' = [...]]

    // Events = [
    //          'event1' => ['startdate' => '23.02.03', 'enddate' => '24.02.03', 'location' => 'Altonaer Straße'],
    //          'event2' => ['...' => '...', ... ],
    //          '..' => [...]
    //          ]

