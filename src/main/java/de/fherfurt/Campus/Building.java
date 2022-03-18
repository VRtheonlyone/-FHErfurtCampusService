package de.fherfurt.Campus;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static de.fherfurt.Campus.Constants.*;
import static de.fherfurt.Campus.Main.*;
import de.fherfurt.Campus.Location;

public class Building /*implements Events*/ {

    // class method
    public static Map<String, Map<String, List<String>>> getAllBuildings(DataCollector _collector)
    {
        return _collector.BuildingData;
    }


    private boolean accessibility;
    private String title;
    private Integer id;
    private List<String> rooms;
    private String geolocation;
    private List<String> type;
    private String campusAffiliation;
    private List<String> event;
    private Map <String, List<String>> allData = new HashMap<>();

    /* Constructor */
    public Building(boolean _accessibility, String _buildingTitle, List<String> _buildingRooms, String _buildingGeoLocation, List<String> _buildingType, String _affiliation, DataCollector _collector) {

        DataCollector.BuildingCounter += 1 ;
        this.id = DataCollector.BuildingCounter;

        setTitleForBuilding(_buildingTitle, _collector);
        setAffiliationForBuilding(_affiliation, _collector);
        setRoomsForBuilding(_buildingRooms, _collector);
        setGeoLocationForBuilding(_buildingGeoLocation, _collector);
        setAccessibilityForBuilding(_accessibility, _collector);
        setTypeForBuilding(_buildingType, _collector);
        setIDForBuilding(this.id,_collector);
    }

    public void setTitleForBuilding (String _title, DataCollector _collector)
    {
        this.title = _title;

        List<String> Titles = new ArrayList<>();
        Titles.add(_title);

        this.allData.put(TITLE,Titles);
        _collector.BuildingData.put(_title,this.allData);
    }
    public void setRoomsForBuilding (List<String> _rooms, DataCollector _collector)
    {
        this.rooms = _rooms;

        this.allData.put(ROOM,_rooms);
        _collector.BuildingData.put(this.title,this.allData);
    }
    public void setGeoLocationForBuilding (String _geoLocation, DataCollector _collector)
    {
        this.geolocation = _geoLocation;

        List<String> Geolocations = new ArrayList<>();
        Geolocations.add(_geoLocation);

        this.allData.put(GEOLOCATION,Geolocations);
        _collector.BuildingData.put(this.title,this.allData);
    }
    public void setIDForBuilding(Integer _id, DataCollector _collector)
    {
        this.id = _id;
        List<String> IDs = new ArrayList<>();
        IDs.add(String.valueOf(_id));

        this.allData.put(ID,IDs);
        _collector.BuildingData.put(this.title,this.allData);
    }
    public void setTypeForBuilding (List <String> _type, DataCollector _collector)
    {
        this.type = _type;
        this.allData.put(TYPES,_type);
        _collector.BuildingData.put(this.title,this.allData);
    }
    public void setAccessibilityForBuilding (boolean _accessibility, DataCollector _collector)
    {
        this.accessibility = _accessibility;

        List<String> Accessibility = new ArrayList<>();
        Accessibility.add(String.valueOf(_accessibility));

        this.allData.put(ACCESSIBILITY,Accessibility);
        _collector.BuildingData.put(this.title,this.allData);
    }
    public void setAffiliationForBuilding(String _affiliation, DataCollector _collector)
    {
        this.campusAffiliation = _affiliation;
        List<String> Affiliation = new ArrayList<>();
        Affiliation.add(_affiliation);

        this.allData.put(CAMPUS_AFFILIATION,Affiliation);
        _collector.BuildingData.put(this.title,this.allData);
       // _collector.CampusData.get(BUILDING).put(this.title);
    }
    public void setEventForBuilding(List<String> _event, DataCollector _collector)
    {
        this.event = _event;

        this.allData.put(EVENTS, _event);
        _collector.BuildingData.put(this.title,this.allData);
    }

    public String getGeoLocation()
    {
        return this.geolocation;
    }
    public boolean getAccessibility()
    {
        return this.accessibility;
    }
    public String getTitle()
    {
        return this.title;
    }
    public Integer getID()
    {
        return this.id;
    }
    public List<String> getRooms()
    {
        return this.rooms;
    }
    public List<String> getType()
    {
        return this.type;
    }
    public String getAffiliation()
    {
        return this.campusAffiliation;
    }
    public List <String> getEvent(){return this.event;}
    public Map <String, List<String>> getAllData(){return this.allData;}

    public void deleteBuilding (DataCollector _collector)
    {
        // Delete building in buildingsGeoLocations Hashmap
        for (String building : _collector.BuildingData.keySet())
        {
            if(this.title.equals(building))
            {
                // removes Building from Building Hashmap
                _collector.BuildingData.remove(building);

                // removes Building from Campus Hashmap
                for (String Campus : _collector.CampusData.keySet())
                {
                        _collector.CampusData.get(Campus).get(BUILDING).remove(this.title);
                }

                for(String Room : this.rooms)
                {
                    /* Removes Building Affiliation for all rooms that are in this building */
                    _collector.RoomData.get(Room).get(BUILDING_AFFILIATION).remove(this.title);
                }
            }
        }
        this.title = null;
        this.id = null;
        this.rooms = null;
        this.geolocation = null;
        this.type = null;
        this.campusAffiliation = null;
        this.event = null;
        this.accessibility = false;
    }
    public void deleteRoom(String _room, DataCollector _collector)
    {
        if(this.rooms.contains(_room)) {
            this.rooms.remove(_room);
            List<String> myRooms = this.rooms;

            this.allData.put(ROOM, myRooms);
            _collector.BuildingData.put(this.title, this.allData);
        }
    }
    public void addRoom(String _roomTitle, DataCollector _collector)
    {
        this.rooms.add(_roomTitle);
        List<String> roomList = this.rooms;

        this.allData.put(ROOM,roomList);
        _collector.BuildingData.put(this.title, this.allData);

    }



    /* @Override
    public void setEvents(String eventLocation) {

    }*/


}

