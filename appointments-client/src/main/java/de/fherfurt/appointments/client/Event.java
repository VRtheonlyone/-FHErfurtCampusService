package de.fherfurt.appointments.client;

public class Event{

    private final String startDate;
    private final String endDate;
    private final String title;
    private final String location;
    private final String building;
    private final String room;

    public Event(String _startDate, String _endDate, String _title, String _location, String _building, String _room) {

        this.startDate = _startDate;
        this.endDate = _endDate;
        this.title = _title;
        this.location = _location;
        this.building = _building;
        this.room = _room;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getBuilding() {
        return building;
    }

    public String getRoom() {
        return room;
    }

    public String toString(){return this.title;}
}
