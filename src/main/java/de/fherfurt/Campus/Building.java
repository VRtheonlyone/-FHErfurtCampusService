package de.fherfurt.Campus;
import javax.xml.crypto.Data;
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

    private String campusAffiliation;

    // --> Get fitting data structure for event affiliation: tuple, List<String>, HashMap?


    //---------------------------------------------------------------------------------------------------//

         
    // ----------------------------------- CONSTRUCTOR ---------------------------------------------
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
    // ---------------------------------------------------------------------------------------------//

    // ----------------------------- SETTER ----------------------------------------//

    public void setTitleForBuilding (String _title, DataCollector _collector)
    {
        this.title = _title;
        _collector.BuildingData.put(this.title, new HashMap(){{put(TITLE,_title);}});
    }

    public void setRoomsForBuilding (List<String> _rooms, DataCollector _collector)
    {
        this.rooms = _rooms;
        _collector.BuildingData.put(this.title, new HashMap(){{put(ROOMS,_rooms);}});
    }

    public void setGeoLocationForBuilding (String _geoLocation, DataCollector _collector)
    {
        this.geolocation = _geoLocation;
       _collector.BuildingData.put(this.title, new HashMap(){{put(GEOLOCATION,_geoLocation);}});
    }

    public void setIDForBuilding(Integer _id, DataCollector _collector)
    {
        this.id = _id;
        
        // Integer must be converted to String to be written into the Hashmap,because it is a String List
        String IDString = String.valueOf(_id);
        _collector.BuildingData.put(this.title, new HashMap(){{put(ID, IDString);}});
    }

    public void setTypeForBuilding (List <String> _type, DataCollector _collector)
    {
        this.type = _type;
        _collector.BuildingData.put(this.title, new HashMap(){{put(TYPES,_type);}});
    }

    public void setAccessibilityForBuilding (boolean _accessibility, DataCollector _collector)
    {
        this.accessibility = _accessibility;
        _collector.BuildingData.put(this.title, new HashMap(){{put(ACCESSIBILITY,_accessibility);}});
    }

    public void setAffiliationForBuilding(String _affiliation, DataCollector _collector)
    {
        this.campusAffiliation = _affiliation;
        _collector.BuildingData.put(this.title, new HashMap(){{put(CAMPUS_AFFILIATION,_affiliation);}});
    }

    //-------------------------------------------------------------------------------//
    // ----------------------------- GETTER ----------------------------------------//


    // Returns Geographical Location of a building as a String
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
            }
        }
        this.title = null;
        this.id = null;
        this.rooms = null;
        this.geolocation = null;
        this.type = null;
        this.campusAffiliation = null;
    }


    // Delete given Rooms associated with a given building
    public void deleteBuildingRooms(List<String> _rooms, DataCollector _collector)
    {
        // For every key in the BuildingDataCollector
        for (String building: _collector.BuildingData.keySet())
        {
            // if there is a match
            if (this.title.equals(building))
            {
                // for every room in passed List
               for(String myRoom : _rooms)
               {
                   // for every room in the matching key
                   for (String Room : this.rooms)
                   {
                       // if there is a match between the rooms
                       if (myRoom.equals(Room))
                       {
                           // Remove the Room from the List
                           this.rooms.remove(myRoom);
                           _collector.BuildingData.get(building).get(ROOMS).remove(Room);

                           // Print out which Room was deleted for which Building
                           System.out.printf("Room %s was removed from Building %s.\n", Room, building);

                       }
                   }
               }
            }
            else
            {
                System.out.printf("There is no building with the name %s", this.title);
            }
        }
    }

    public void addRoom(String _roomTitle, DataCollector _collector)
    {
        //Adds the room to the current instance's roomList
        this.rooms.add(_roomTitle);
        List<String> roomList = this.rooms;

        //Updates the roomList for this Building
        _collector.BuildingData.put(this.title, new HashMap(){{put(ROOMS,roomList);}});

    };

    public void addAffiliation(String _affiliation, DataCollector _collector)
    {
        //Adds the room to the current instance's roomList
        this.campusAffiliation = _affiliation;
        //Updates the roomList for this Building
        _collector.BuildingData.put(this.title, new HashMap(){{put(CAMPUS_AFFILIATION,_affiliation);}});

    };



    // Gets List of all Rooms associated with a building
    public List<String> getRoomsForBuilding (DataCollector _collector)
    {
        // Define an empty List of Strings
        List <String> roomList = new ArrayList<>();

        // Iterate through the hashmap
        for(String building : _collector.BuildingData.keySet())
        {
            // Check whether input String matches key in the array
            if (this.title.equals(building))
            {
                // Add all values associated with key to the list
                roomList.addAll(_collector.BuildingData.get(building).get(ROOMS));

                // return List of all Rooms for the respective building
                return roomList;
            }
        }

        roomList.add("There are currently no rooms associated with this building.\n");
        return roomList;
    }
}

