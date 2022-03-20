package de.fherfurt.Campus;

import de.fherfurt.Campus.Events.Event;

import java.util.Map;
import java.util.Objects;

import static de.fherfurt.Campus.Constants.*;
import static de.fherfurt.Campus.Constants.ROOM;
import java.util.*;

public class CampusUtilities {

    public static void setClassEvents(String _entryKey, String _objectTitle, List<Object> _localEventsList) {

        Map<String, Map<String, String>> Events = DataCollector.Events;

        for (Map.Entry<String, Map<String, String>> someEvent : Events.entrySet()) {
            for (Map.Entry<String, String> EventEntry : someEvent.getValue().entrySet()) {
                if (Objects.equals(EventEntry.getKey(), _entryKey)) {
                    if (Objects.equals(_objectTitle, EventEntry.getValue())) {

                        de.fherfurt.Campus.Events.Event locationEvent = new Event(
                                someEvent.getValue().get(EVENT_START_DATE),
                                someEvent.getValue().get(EVENT_END_DATE),
                                someEvent.getValue().get(EVENT_TITLE),
                                someEvent.getValue().get(LOCATION),
                                someEvent.getValue().get(BUILDING),
                                someEvent.getValue().get(ROOM));

                        _localEventsList.add(locationEvent);
                    }
                }
            }
        }
    }
}
