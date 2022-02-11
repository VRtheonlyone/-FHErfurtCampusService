package de.fherfurt.Campus;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import static de.fherfurt.Campus.Main.*;


public class Building {

    private boolean accessibility;

    // Name of the building
    private String title;

    // ID Number of Building
    private Integer id;

    // List of Rooms for Building
    private List<String> rooms;

    // Geographical Coordinates of Building
    private String geolocation;

    // List of all Building Types
    private List<String> type;

    // Campus associated with building
    private String campusAffiliation;

    // Event associated with Building
    private List<String> event;

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

    /* SETTER */

    public void setTitleForBuilding (String _title, DataCollector _collector)
    {
        this.title = _title;

        List<String> Titles = new ArrayList<>();
        Titles.add(_title);
        _collector.BuildingInnerMap.put(TITLE,Titles);
        _collector.BuildingData.put(_title,_collector.BuildingInnerMap);
    }

    public void setRoomsForBuilding (List<String> _rooms, DataCollector _collector)
    {
        this.rooms = _rooms;

        _collector.BuildingInnerMap.put(ROOMS,_rooms);
        _collector.BuildingData.put(this.title,_collector.BuildingInnerMap);
    }

    public void setGeoLocationForBuilding (String _geoLocation, DataCollector _collector)
    {
        this.geolocation = _geoLocation;

        List<String> Geolocations = new ArrayList<>();
        Geolocations.add(_geoLocation);

        _collector.BuildingInnerMap.put(GEOLOCATION,Geolocations);
        _collector.BuildingData.put(this.title,_collector.BuildingInnerMap);
    }

    public void setIDForBuilding(Integer _id, DataCollector _collector)
    {
        this.id = _id;

        List<String> IDs = new ArrayList<>();
        IDs.add(String.valueOf(_id));

        _collector.BuildingInnerMap.put(ID,IDs);
        _collector.BuildingData.put(this.title,_collector.BuildingInnerMap);
    }

    public void setTypeForBuilding (List <String> _type, DataCollector _collector)
    {
        this.type = _type;


        _collector.BuildingInnerMap.put(TYPES,_type);
        _collector.BuildingData.put(this.title,_collector.BuildingInnerMap);
    }

    public void setAccessibilityForBuilding (boolean _accessibility, DataCollector _collector)
    {
        this.accessibility = _accessibility;

        List<String> Accessibility = new ArrayList<>();
        Accessibility.add(String.valueOf(_accessibility));

        _collector.BuildingInnerMap.put(ACCESSIBILITY,Accessibility);
        _collector.BuildingData.put(this.title,_collector.BuildingInnerMap);
    }

    public void setAffiliationForBuilding(String _affiliation, DataCollector _collector)
    {
        this.campusAffiliation = _affiliation;
        List<String> Affiliation = new ArrayList<>();
        Affiliation.add(_affiliation);

        _collector.BuildingInnerMap.put(CAMPUS_AFFILIATION,Affiliation);
        _collector.BuildingData.put(this.title,_collector.BuildingInnerMap);
    }

    public void setEventForBuilding(List<String> _event, DataCollector _collector)
    {
        this.event = _event;

        _collector.BuildingInnerMap.put(EVENTS, this.event);
        _collector.BuildingData.put(this.title,_collector.BuildingInnerMap);
    }

    /* Getter */

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

    // ----------------------------- DELETES ----------------------------------------//

    // Deletes Building and its Data from all HashMaps in the BuildingDataCollector
    public void deleteBuilding (DataCollector _collector)
    {
        // Delete building in buildingsGeoLocations Hashmap
        for (String building : _collector.BuildingData.keySet())
        {
            if(this.title.equals(building))
            {
                _collector.BuildingData.remove(building);
                _collector.CampusInnerMap.get(BUILDING).remove(building);

                for(String Room : this.rooms) {

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
    }

    /* DELETE */
    public void deleteRoom(String _room, DataCollector _collector)
    {
        this.rooms.remove(_room);
        List <String> myRooms = this.rooms;

        _collector.BuildingInnerMap.put(ROOMS,myRooms);
        _collector.BuildingData.put(this.title, _collector.BuildingInnerMap);
    }

    /* ADD */
    public void addRoom(String _roomTitle, DataCollector _collector)
    {
        this.rooms.add(_roomTitle);
        List<String> roomList = this.rooms;

        _collector.BuildingInnerMap.put(ROOMS,roomList);
        _collector.BuildingData.put(this.title, _collector.BuildingInnerMap);

    }

}

