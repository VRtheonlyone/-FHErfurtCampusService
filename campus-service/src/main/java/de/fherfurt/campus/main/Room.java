package de.fherfurt.campus.main;

import de.fherfurt.campus.utilities.CampusUtilities;
import de.fherfurt.persons.client.DevPersonsService;
import de.fherfurt.appointments.client.*;

import java.util.*;
import static de.fherfurt.campus.constants.Constants.*;

public class Room implements EventsSetter {

    private Integer id;
    private String title;
    private Integer floor;
    private Building buildingAffiliation;
    private Map<String, List<String>> allRoomData = new HashMap<>(); // No Setter necessary --> Is filled internally by the other methods
    private List<DevPersonsService> allPersonsForThisRoom;
    public  List<Event> roomEvents; //--> fix to private and add getter + setter then fix related issues

    private static List<DevPersonsService> allPersonsWithRoom;
    private static HashMap<Room, List <DevPersonsService>> roomsWithPersons = new HashMap<>();
    private static Integer roomCounter = 0;
    private static List<Room> allRoomsList;

    public Room(String roomTitle, Integer floorNumber, List<DevPersonsService> roomPersons, Building affiliatedBuilding) {

        roomCounter += 1;
        this.id = roomCounter;

        setTitleForRoom (roomTitle);
        setFloorForRoom (floorNumber);
        setPersonsForRoom (roomPersons);
        setAffiliationForRoom (affiliatedBuilding);
        setRoomsWithPersons();
        addRoomToAllRoomsList(this);
    }
    public Room(String roomTitle, Integer floorNumber, Building affiliatedBuilding) {

        roomCounter += 1;
        this.id = roomCounter;

        setTitleForRoom (roomTitle);
        setFloorForRoom (floorNumber);
        setAffiliationForRoom (affiliatedBuilding);
        setIdForRoom(this.id);
        addRoomToAllRoomsList(this);
    }
    public Room(String roomTitle){}

    public void setRoomsWithPersons() {
        roomsWithPersons.put(this, this.allPersonsForThisRoom);
    }
    public void setTitleForRoom(String roomTitle) {
        this.title = roomTitle;

        List<String> Titles = new ArrayList<>();
        Titles.add(roomTitle);

        this.allRoomData.put(TITLE,Titles);
       DataCollector.getBuildingData().put (roomTitle,this.allRoomData);
    }
    public void setFloorForRoom(Integer floorNumber) {
        this.floor = floorNumber;
        List<String> Floor = new ArrayList<>();
        Floor.add(String.valueOf(floorNumber));

        this.allRoomData.put(FLOOR, Floor);
        updateRoomDataHashmap();
    }
    public void setPersonsForRoom(List<DevPersonsService> roomPersons) {

        this.allPersonsForThisRoom = roomPersons;

        for (DevPersonsService person : roomPersons){

            if(!allPersonsWithRoom.contains(person)) {

                allPersonsWithRoom.add(person);
            }
        }

        List<String> personTitle = new ArrayList<>();

        for(DevPersonsService person : roomPersons) {

            personTitle.add(String.valueOf(person));
        }

        this.allRoomData.put(PERSONS, personTitle);
        setRoomsWithPersons();
        updateRoomDataHashmap();
    }
    public void setAffiliationForRoom(Building affiliatedBuilding) {
        this.buildingAffiliation = affiliatedBuilding;
        List<String> affiliatedBuildingTitle = new ArrayList<>();
        affiliatedBuildingTitle.add(affiliatedBuilding.getTitle());

        this.allRoomData.put(BUILDING_AFFILIATION,affiliatedBuildingTitle);
        updateRoomDataHashmap();
    }
    public void setIdForRoom(Integer roomID) {
        for (Room room : allRoomsList){

            if(Objects.equals(room.getRoomID(), roomID)){return;}
        }

        this.id = roomID;
        List<String> IDs = new ArrayList<>();
        IDs.add(String.valueOf (roomID));

        this.allRoomData.put(ID,IDs);
        updateRoomDataHashmap();
    }
    public void setAllPersonsForThisRoom(List<DevPersonsService> allPersonsForThisRoom) {
        this.allPersonsForThisRoom = allPersonsForThisRoom;
    }

    @Override
    public void setEvents() {
        CampusUtilities.setClassEvents(ROOM, this.getRoomTitle(), Collections.singletonList(this.roomEvents));
    }
    public List<Event> getEvents()
    {
        return this.roomEvents;
    }

    public Integer getRoomID() {return this.id;}
    public String getRoomTitle() {return this.title;}
    public Integer getFloorNumber() {return this.floor;}
    public Building getBuildingAffiliation() {return this.buildingAffiliation;}
    public List<Room> getRoomList() {return allRoomsList;}
    public List<DevPersonsService> getAllPersonsForThisRoom() {
        return allPersonsForThisRoom;
    }
    public static HashMap<Room, List <DevPersonsService>> getRoomsWithPersons(){return roomsWithPersons;}
    public static List <DevPersonsService> getAllPersonsWithRoom (){

        return allPersonsWithRoom;
    }

    public static void deleteRoom(Room roomToBeDeleted) {
        for (String room :DataCollector.getRoomData().keySet())
        {
            if(roomToBeDeleted.getRoomTitle().equals(room))
            {
                Map<String, Map<String, List<String>>> UpdatedRoomHashmap = DataCollector.getRoomData();
                UpdatedRoomHashmap.remove(roomToBeDeleted.title);
                DataCollector.setRoomData(UpdatedRoomHashmap);
            }
        }

        for (String building : DataCollector.getBuildingData().keySet())
        {
            if(DataCollector.getBuildingData().get(building).get(ROOM).contains(roomToBeDeleted.title))
            {
                Map<String, Map<String, List<String>>> UpdatedBuildingHashmap = DataCollector.getBuildingData();
                UpdatedBuildingHashmap.get(building).get(ROOM).remove(roomToBeDeleted.title);
                DataCollector.setRoomData(UpdatedBuildingHashmap);
            }
        }

        for(Room roomInAllRooms : allRoomsList)
        {
            if (Objects.equals(roomInAllRooms, roomToBeDeleted)) {
                roomToBeDeleted = null;
                break;
            }
        }

       roomsWithPersons.remove(roomToBeDeleted);

    }
    public void deletePersonFromThisRoom(DevPersonsService person) {

        this.allPersonsForThisRoom.remove(person);

        List<String> allTitlesOfPersonsForThisRoom = new ArrayList<>();

        for(DevPersonsService personOfThisRoom : allPersonsForThisRoom) {

            allTitlesOfPersonsForThisRoom.add(String.valueOf(person));
        }

        this.allRoomData.put(PERSONS,allTitlesOfPersonsForThisRoom);
        allPersonsWithRoom.remove(person);

        updateRoomDataHashmap();
        setRoomsWithPersons();
    }

    public void addPersonToThisRoom(DevPersonsService person) {

        this.allPersonsForThisRoom.add(person);
        List<String> personFullName = new ArrayList<>();

        for(DevPersonsService personOfThisRoom : allPersonsForThisRoom)
        {
            personFullName.add(personOfThisRoom.getFullName());
        }

        this.allRoomData.put(PERSONS,personFullName);

        updateRoomDataHashmap();
        setRoomsWithPersons();
    }
    public void addRoomToAllRoomsList(Room thisRoom){

        allRoomsList.add(this);
    }

    public static Room searchForRoomOfPerson(DevPersonsService person) {

            for (Map.Entry<Room, List <DevPersonsService>> entry : roomsWithPersons.entrySet())
            {
                if (entry != null && entry.getValue().contains(person))
                {
                    return entry.getKey();
                }
            }

            return null;
    }

    public void updateRoomDataHashmap() {

        Map<String, Map<String, List<String>>> UpdatedRoomData = DataCollector.getRoomData();
        UpdatedRoomData.put(this.title,this.allRoomData);
        DataCollector.setRoomData(UpdatedRoomData);
    }


}