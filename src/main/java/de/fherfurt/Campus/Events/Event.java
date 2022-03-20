package de.fherfurt.Campus.Events;

import de.fherfurt.Campus.DataCollector;

import java.util.List;

public class Event{

    String startDate;
    String endDate;
    String title;
    String location;
    String building;
    String room;

    public Event(String _startDate, String _endDate, String _title, String _location, String _building, String _room) {

        this.startDate = _startDate;
        this.endDate = _endDate;
        this.title = _title;
        this.location = _location;
        this.building = _building;
        this.room = _room;
    }

}
