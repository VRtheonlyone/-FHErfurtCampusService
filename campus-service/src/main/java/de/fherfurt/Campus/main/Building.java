package de.fherfurt.campus.main;

import java.util.*;

import static de.fherfurt.campus.constants.Constants.*;
import de.fherfurt.appointments.client.*;
import de.fherfurt.campus.utilities.CampusUtilities;

public class Building implements EventsSetter {

    // class method
    public enum BuildingTypes {

        EDUCATION {
            public String toString() {
                return "Education";
            }
        },

        CAFETERIA {
            public String toString() {
                return "Cafeteria";
            }
        },

        LIBRARY {
            public String toString() {
                return "Library";
            }
        },

        GYMNASIUM {
            public String toString() {
                return "Gymnasium";
            }
        }
    }

    private static Integer buildingCounter = 0;
    private boolean accessibility;
    private String title;
    private Integer id;
    private List<BuildingTypes> type;
    private Campus campusAffiliation;
    private List<Event> events;

    private List<Room> rooms;
    private Map <String, List<String>> allBuildingData = new HashMap<>();
    private static List<Building> allBuildings = new ArrayList<>();
    public static final Building dummyBuilding = new Building();

    /* Constructor */
    public Building(boolean accessibility, String buildingTitle, List<Room> buildingRooms, List<BuildingTypes> buildingType, Campus campusAffiliation) {

        buildingCounter += 1 ;
        setTitleForBuilding(buildingTitle);
        setAffiliationForBuilding(campusAffiliation);
        setRoomsForBuilding(buildingRooms);
        setAccessibilityForBuilding(accessibility);
        setTypeForBuilding(buildingType);
        setIDForBuilding(buildingCounter);
    }
    private Building(){};

    public void setTitleForBuilding (String title) {

        this.title = title;

        List<String> Titles = new ArrayList<>();
        Titles.add(title);

        this.allBuildingData.put(TITLE,Titles);
        updateBuildingDataHashmap();
    }
    public void setRoomsForBuilding (List<Room> buildingRooms) {

        this.rooms = buildingRooms;

        List<String> roomList = new ArrayList<>();

        for (Room room : buildingRooms) {
            roomList.add(room.getRoomTitle());
        }

        this.allBuildingData.put(ROOM,roomList);
        updateBuildingDataHashmap();
    }
    public void setIDForBuilding(Integer id) {

        this.id = id;
        List<String> IDs = new ArrayList<>();
        IDs.add(String.valueOf(id));

        this.allBuildingData.put(ID,IDs);
        updateBuildingDataHashmap();
    }
    public void setTypeForBuilding (List <BuildingTypes> buildingType) {

        this.type = buildingType;

        List<String> buildingTypes = new ArrayList<>();
        for (BuildingTypes type : buildingType) {
            buildingTypes.add(type.toString());
        }
        this.allBuildingData.put(TYPES,buildingTypes);
        updateBuildingDataHashmap();
    }
    public void setAccessibilityForBuilding (boolean accessibility) {

        this.accessibility = accessibility;

        List<String> Accessibility = new ArrayList<>();
        Accessibility.add(String.valueOf(accessibility));

        this.allBuildingData.put(ACCESSIBILITY,Accessibility);
        updateBuildingDataHashmap();
    }
    public void setAffiliationForBuilding(Campus campusAffiliation) {

        this.campusAffiliation = campusAffiliation;
        campusAffiliation.addBuildingToCampus(this);

        List<String> Affiliation = new ArrayList<>();
        Affiliation.add(campusAffiliation.toString());

        this.allBuildingData.put(CAMPUS_AFFILIATION,Affiliation);
        updateBuildingDataHashmap();
    }
    public void setEventForBuilding(List<Event> buildingEvents) {

        this.events = buildingEvents;
        List<String> eventListForBuilding = new ArrayList<>();

        for (Event event : buildingEvents) {
            eventListForBuilding.add(event.getTitle());
        }

        this.allBuildingData.put(EVENTS, eventListForBuilding);
        updateBuildingDataHashmap();
    }
    @Override
    public void setEvents() {
        CampusUtilities.setClassEvents(BUILDING, this.getTitle(), Collections.singletonList(this.events));
    }

    public boolean getAccessibility()
    {
        return this.accessibility;
    }
    public Integer getBuildingCounter(){return Building.buildingCounter;}
    public String getTitle() {return this.title;}
    public Integer getID() {return this.id;}
    public List<Room> getRooms() {return this.rooms;}
    public List<BuildingTypes> getType() {return this.type;}
    public Campus getAffiliation() {return this.campusAffiliation;}
    public List <Event> getEvents(){return this.events;}
    public Map <String, List<String>> getAllDataOfBuilding(){return this.allBuildingData;}
    public List<Building> getAllBuildings() {return allBuildings;}

    public void deleteBuildingFromHashmaps(){

        for (String building : DataCollector.getBuildingData().keySet()) {
            if (this.title.equals(building)) {
                Map<String, Map<String, List<String>>> updatedBuildingHashmap = DataCollector.getBuildingData();
                updatedBuildingHashmap.remove(this.title);
                DataCollector.setBuildingData(updatedBuildingHashmap);
            }
        }
        this.campusAffiliation.deleteBuildingFromCampus(this);

        for(Room buildingRoom : this.rooms){
            buildingRoom.setAffiliationForRoom(null);
        }
    }

    public void deleteRoomFromRoomList(Room buildingRoom)
    {
        if(this.rooms.contains(buildingRoom)) {
            this.rooms.remove(buildingRoom);
            List<String> myRooms = new ArrayList<>();

            for(Room Room : this.rooms)
            {
                myRooms.add(Room.getRoomTitle());
            }

            buildingRoom.setAffiliationForRoom(null);

            this.allBuildingData.put(ROOM, myRooms);
            updateBuildingDataHashmap();
        }
    }
    public void addRoom(Room roomTitle)
    {
        this.rooms.add(roomTitle);
        List<String> roomList = new ArrayList<>();
        roomList.add(roomTitle.getRoomTitle());

        this.allBuildingData.put(ROOM,roomList);
        updateBuildingDataHashmap();

    }

    public void updateBuildingDataHashmap()
    {
        Map<String, Map<String, List<String>>> updatedBuildingDataHashmap = DataCollector.getBuildingData();
        updatedBuildingDataHashmap.put(this.title, this.allBuildingData);
        DataCollector.setBuildingData(updatedBuildingDataHashmap);
    }





}

