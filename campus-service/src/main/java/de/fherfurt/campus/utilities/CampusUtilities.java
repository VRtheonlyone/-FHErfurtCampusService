package de.fherfurt.campus.utilities;

import de.fherfurt.campus.main.DataCollector;
import de.fherfurt.appointments.client.*;

import java.util.Map;
import java.util.Objects;

import static de.fherfurt.campus.constants.Constants.*;
import static de.fherfurt.campus.constants.Constants.ROOM;
import java.util.*;

/**
 * @author Nikita Studenikin, nikita.studenikin@fh-erfurt.de
 * class contains functions, which can be used overall the project
 */
public class CampusUtilities {


    /**
     * This function sets events in the 3 main classes of the campus part: location, building and room
     *
     * @param entryKey  what shall the setter look for ('location', 'building' or 'room')
     * @param objectTitle   the name of this object (example: 'Campus Altonaer Strasse')
     * @param localEventsList   the local class events variable, on which the associated event should be saved to
     */
    public static void setClassEvents(String entryKey, String objectTitle, List<Object> localEventsList) {

        Map<String, Map<String, String>> Events = DataCollector.getEvents();

        for (Map.Entry<String, Map<String, String>> someEvent : Events.entrySet()) {
            for (Map.Entry<String, String> EventEntry : someEvent.getValue().entrySet()) {
                if (Objects.equals(EventEntry.getKey(), entryKey)) {
                    if (Objects.equals(objectTitle, EventEntry.getValue())) {

                        Event locationEvent = new Event(
                                someEvent.getValue().get(EVENT_START_DATE),
                                someEvent.getValue().get(EVENT_END_DATE),
                                someEvent.getValue().get(EVENT_TITLE),
                                someEvent.getValue().get(CAMPUS),
                                someEvent.getValue().get(BUILDING),
                                someEvent.getValue().get(ROOM));

                        localEventsList.add(locationEvent);
                    }
                }
            }
        }
    }
}
