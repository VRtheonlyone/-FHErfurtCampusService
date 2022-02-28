package de.fherfurt.Campus;
import java.util.ArrayList;
import java.util.List;

import static de.fherfurt.Campus.Main.*;

public class Room {

    //-------------------------------ATTRIBUTES----------------------------------//

    // intern room ID for easy handling
    private Integer id;

    // Number of the room
    private String title;

    // floor the room is located on
    private Integer floor;

    // List of persons for the room
    private List<String> persons;

    // To which Building the room belongs
    private String buildingAffiliation;

    //---------------------------------------------------------------------------------------------------//


    // ----------------------------------- CONSTRUCTOR ---------------------------------------------


    public Room(String _roomTitle, Integer _floorNumber, List<String> _roomPersons, String _affiliation,DataCollector _collector)
    {

        DataCollector.RoomCounter +=1;
        this.id = DataCollector.RoomCounter;

        setTitleForRoom(_roomTitle, _collector);
        setFloorForRoom(_floorNumber, _collector);
        setPersonsForRoom(_roomPersons, _collector);
        setAffiliationForRoom(_affiliation, _collector);
        setIdForRoom(this.id, _collector);
    }
    // ---------------------------------------------------------------------------------------------//

    // ----------------------------- SETTER ---------------------------------------- //


    public void setTitleForRoom(String _roomTitle, DataCollector _collector)
    {

        this.title = _roomTitle;

        List<String> Titles = new ArrayList<>();
        Titles.add(_roomTitle);

        _collector.RoomInnerMap.put(TITLE,Titles);
        _collector.RoomData.put(_roomTitle,_collector.RoomInnerMap);
    }

    public void setFloorForRoom(Integer _floorNumber, DataCollector _collector)
    {
        this.floor = _floorNumber;
        List<String> Floor = new ArrayList<>();
        Floor.add(String.valueOf(_floorNumber));

        _collector.RoomInnerMap.put(FLOOR, Floor);
        _collector.RoomData.put(this.title, _collector.RoomInnerMap);
    }

    public void setPersonsForRoom(List<String> _roomPersons, DataCollector _collector)
    {
        this.persons = _roomPersons;

        _collector.RoomInnerMap.put(PERSONS, _roomPersons);
        _collector.RoomData.put(this.title, _collector.RoomInnerMap);
    }

    public void setAffiliationForRoom(String _affiliation, DataCollector _collector)
    {
        this.buildingAffiliation = _affiliation;
        List<String> Affiliation = new ArrayList<>();
        Affiliation.add(_affiliation);

        _collector.RoomInnerMap.put(BUILDING_AFFILIATION,Affiliation);
        _collector.RoomData.put(this.title,_collector.RoomInnerMap);
    }

    public void setIdForRoom(Integer _roomID, DataCollector _collector)
    {
        this.id = _roomID;
        List<String> IDs = new ArrayList<>();
        IDs.add(String.valueOf(_roomID));

        _collector.RoomInnerMap.put(ID,IDs);
        _collector.RoomData.put(this.title,_collector.RoomInnerMap);
    }

    // ---------------------------------------------------------------------------------------------//

    // ----------------------------- GETTER ---------------------------------------- //

    public Integer getRoomID() {return this.id;}

    public String getRoomTitle() {return this.title;}

    public Integer getFloorNumber() {return this.floor;}

    public List<String> getRoomPersons() {return this.persons;}

    public String getRoomAffiliation() {return this.buildingAffiliation;}


    // ---------------------------------------------------------------------------------------------//

    // ----------------------------- DELETES ---------------------------------------- //


    // Deletes Room and its Data from all HashMaps
    public void deleteRoom (DataCollector _collector)
    {
        // Delete building in buildingsGeoLocations Hashmap
        for (String room : _collector.RoomData.keySet())
        {
            if(this.title.equals(room))
            {
                _collector.RoomData.remove(room);
            }
        }
        this.title = null;
        this.id = null;
        this.floor = null;
        this.persons = null;
        this.buildingAffiliation = null;
    }

    // ---------------------------------------------------------------------------------------------//


}


