package de.fherfurt.Campus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.fherfurt.Campus.Main.*;

import static de.fherfurt.Campus.Main.ID;

public class Room {

    // class method
    public static Map<String, Map<String, List<String>>> getAllRooms(DataCollector _collector)
    {
        return _collector.RoomData;
    }
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

    // Inner Hashmap of DataCollector
    private Map<String, List<String>> allData = new HashMap<>();

    //---------------------------------------------------------------------------------------------------//


    // ----------------------------------- CONSTRUCTOR ---------------------------------------------


    public Room(String _roomTitle, Integer _floorNumber, List<String> _roomPersons, String _affiliation,DataCollector _collector) {

        DataCollector.RoomCounter +=1;
        this.id = DataCollector.RoomCounter;

        setTitleForRoom(_roomTitle, _collector);
        setFloorForRoom(_floorNumber, _collector);
        setPersonsForRoom(_roomPersons, _collector);
        setAffiliationForRoom(_affiliation, _collector);
        setIdForRoom(this.id, _collector);
    }

    public Room(String _roomTitle, Integer _floorNumber, String _affiliation,DataCollector _collector) {

        DataCollector.RoomCounter +=1;
        this.id = DataCollector.RoomCounter;

        setTitleForRoom(_roomTitle, _collector);
        setFloorForRoom(_floorNumber, _collector);
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

        this.allData.put(TITLE,Titles);
        _collector.RoomData.put(_roomTitle,this.allData);
    }

    public void setFloorForRoom(Integer _floorNumber, DataCollector _collector)
    {
        this.floor = _floorNumber;
        List<String> Floor = new ArrayList<>();
        Floor.add(String.valueOf(_floorNumber));

        this.allData.put(FLOOR, Floor);
        _collector.RoomData.put(this.title, this.allData);
    }

    public void setPersonsForRoom(List<String> _roomPersons, DataCollector _collector)
    {
        this.persons = _roomPersons;

        this.allData.put(PERSONS, _roomPersons);
        _collector.RoomData.put(this.title, this.allData);
    }

    public void setAffiliationForRoom(String _affiliation, DataCollector _collector)
    {
        this.buildingAffiliation = _affiliation;
        List<String> Affiliation = new ArrayList<>();
        Affiliation.add(_affiliation);

        this.allData.put(BUILDING_AFFILIATION,Affiliation);
        _collector.RoomData.put(this.title,this.allData);
    }

    public void setIdForRoom(Integer _roomID, DataCollector _collector)
    {
        this.id = _roomID;
        List<String> IDs = new ArrayList<>();
        IDs.add(String.valueOf(_roomID));

        this.allData.put(ID,IDs);
        _collector.RoomData.put(this.title,this.allData);
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

    // Deletes a specific person out of the persons listed
    public void deletePerson(String _persons, DataCollector _collector)
    {
        this.persons.remove(_persons);
        List <String> RoomPerson = this.persons;

        this.allData.put(PERSONS,RoomPerson);
        _collector.RoomData.put(this.title, this.allData);
    }

    // -------------------------------------------------------------------------- //

    // ----------------------------- ADD ---------------------------------------- //

    // Adds a person to the list of a room
    public void addPerson(String _personName, DataCollector _collector)
    {
        this.persons.add(_personName);
        List<String> NewPerson = this.persons;

        this.allData.put(PERSONS,NewPerson);
        _collector.RoomData.put(this.title, this.allData);
    }


    // -------------------------------------------------------------------------- //

}


