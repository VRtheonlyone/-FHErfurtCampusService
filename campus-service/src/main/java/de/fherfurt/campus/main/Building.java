package de.fherfurt.campus.main;

import java.util.*;

import static de.fherfurt.campus.constants.Constants.*;
import de.fherfurt.appointments.client.*;
import de.fherfurt.campus.utilities.CampusUtilities;

/**
 * @author Vadim Rodt, vadim.rodt@fh-erfurt.de
 * The Building class creates instances of Buildings that are connected to Rooms and the Campus that they are located in
 * It includes various attributes and functions to manipulate these attributes. Whenever attributes are manipulated, the data in the DataCollector Hashmaps are also manipulated.
 */

public class Building implements EventsSetter {

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
    private Campus campusAffiliation;
    private List<BuildingTypes> type = new ArrayList<>();
    private List<Event> events = new ArrayList<>();
    private List<String> roomsAsStrings = new ArrayList<>();

    private List<Room> rooms = new ArrayList<>();
    private Map <String, List<String>> allBuildingData = new HashMap<>();
    private static List<Building> allBuildings = new ArrayList<>();
    public static final Building dummyBuilding = new Building();

    public Building(boolean accessibility, String buildingTitle, List<Room> buildingRooms, List<BuildingTypes> buildingType, Campus campusAffiliation) {

        buildingCounter += 1 ;
        setTitleForBuilding(buildingTitle);
        setAffiliationForBuilding(campusAffiliation);
        setRoomsForBuilding(buildingRooms);
        setAccessibilityForBuilding(accessibility);
        setTypeForBuilding(buildingType);
        setIDForBuilding(buildingCounter);
    }
    public Building(boolean accessibility, String buildingTitle, Campus campusAffiliation) {

        buildingCounter += 1 ;
        setTitleForBuilding(buildingTitle);
        setAffiliationForBuilding(campusAffiliation);
        setAccessibilityForBuilding(accessibility);
        setIDForBuilding(buildingCounter);
    }
    public Building(String buildingTitle, Campus campusAffiliation){
        buildingCounter += 1 ;
        setIDForBuilding(buildingCounter);
        setAffiliationForBuilding(campusAffiliation);
        setTitleForBuilding(buildingTitle);
    }
    private Building(){}

    public void setTitleForBuilding (String title) {

        this.title = title;

        List<String> Titles = new ArrayList<>();
        Titles.add(title);

        this.allBuildingData.put(TITLE,Titles);
        updateBuildingDataHashmap();
    }
    public void setRoomsForBuilding (List<Room> buildingRooms) {

        this.rooms = buildingRooms;
        updateRoomsAsStringsList();
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
    public List<String> getRoomsAsStrings(){return this.roomsAsStrings;}
    public Map <String, List<String>> getAllDataOfBuilding(){return this.allBuildingData;}
    public List<Building> getAllBuildings() {return allBuildings;}

    public void deleteBuildingFromHashmaps(){

        Map<String, Map<String, List<String>>> updatedBuildingHashmap = DataCollector.getBuildingData();
        for (String building : DataCollector.getBuildingData().keySet()) {
            if (Objects.equals(this.title, building)) {
                updatedBuildingHashmap.remove(this.title);
                break;
            }
        }
        DataCollector.setBuildingData(updatedBuildingHashmap);
        this.campusAffiliation.deleteBuildingFromCampus(this);

        for(Room buildingRoom : this.rooms){
            buildingRoom.setAffiliationForRoom(dummyBuilding);
        }
    }
    public void deleteRoomFromRoomList(Room buildingRoom) {
        this.rooms.remove(buildingRoom);
        updateRoomsAsStringsList();
        updateBuildingDataHashmap();
    }

    public void addingRoomToRoomList(Room roomTitle) {

        this.rooms.add(roomTitle);
        updateRoomsAsStringsList();
        updateBuildingDataHashmap();

    }
    public void addBuildingType(BuildingTypes buildingType){

        if(this.type == null)
        {
            this.type = new ArrayList<>();
        }

        this.type.add(buildingType);

        List<String> buildingTypes = new ArrayList<>();
        for (BuildingTypes type : this.type) {
            buildingTypes.add(type.toString());
        }
        this.allBuildingData.put(TYPES,buildingTypes);
        updateBuildingDataHashmap();
    }

    public void updateBuildingDataHashmap() {

        Map<String, Map<String, List<String>>> updatedBuildingDataHashmap = DataCollector.getBuildingData();
        updatedBuildingDataHashmap.put(this.title, this.allBuildingData);
        updatedBuildingDataHashmap.remove(null);
        DataCollector.setBuildingData(updatedBuildingDataHashmap);
    }
    public void updateRoomsAsStringsList(){

        for (Room room : this.rooms) {

            this.roomsAsStrings.add(room.getRoomTitle());
            room.setAffiliationForRoom(this);
        }
        this.allBuildingData.put(ROOM, roomsAsStrings);
    }
}

