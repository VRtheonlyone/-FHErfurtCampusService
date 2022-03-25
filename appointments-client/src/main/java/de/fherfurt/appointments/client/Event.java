package de.fherfurt.appointments.client;

/**
 * class responsible for creating event objects, providing all necessary variables and methods for it
 */
public class Event {

    private final String startDate;
    private final String endDate;
    private final String title;
    private final String location;
    private final String building;
    private final String room;

    /**
     * the constructor of the event with the important arguments for it
     *
     * @param startDate the start date of the event
     * @param endDate   the end date of the event
     * @param title     the title of the event
     * @param location  the location of the event
     * @param building  the building of the event
     * @param room      the room of the event
     */
    public Event(String startDate, String endDate, String title, String location, String building, String room) {

        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.location = location;
        this.building = building;
        this.room = room;
    }

    /**
     * get start date of the event
     *
     * @return start date of the event
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * get end date of the event
     *
     * @return end date of the event
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * get title of the event
     *
     * @return title of the event
     */
    public String getTitle() {
        return title;
    }

    /**
     * get location of the event
     *
     * @return location of the event
     */
    public String getLocation() {
        return location;
    }

    /**
     * get building of the event
     *
     * @return building of the event
     */
    public String getBuilding() {
        return building;
    }

    /**
     * get room of the event
     *
     * @return room of the event
     */
    public String getRoom() {
        return room;
    }

    public String toString(){return this.title;}
}
