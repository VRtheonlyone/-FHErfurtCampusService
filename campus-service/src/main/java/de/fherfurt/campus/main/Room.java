package de.fherfurt.campus.main;

import de.fherfurt.campus.client.CampusForPersonsClient;
import de.fherfurt.campus.utilities.CampusUtilities;
import de.fherfurt.persons.client.DevPersonsService;
import de.fherfurt.appointments.client.*;

import java.util.*;
import static de.fherfurt.campus.constants.Constants.*;

/**
 * @author Jann Lucas Pischke, jann.pischke@fh-erfurt.de
 * The Room class defines a room and stashes it into a hashmap
 * this includes add/deletes/change functions
 */


public class Room implements EventsSetter, CampusForPersonsClient {

    /**
     * @param id is the unique key to identify a specific room
     * @param title is the title/name/room number of the room
     * @param floor is the floor/level the room is located
     * @param buildingAffiliation is an object containing the the building the room is part of
     * @param allRoomData is a hashmap which contains all existing rooms
     * @param allPersonForThisRoom is an array for the communication for service persons
     * @param roomEvents is an array which contains all events for a specific room
     * @param allPersonsWithRoom is an array containing all persons with a affiliated room
     * @param roomsWithPerson is a hashmap for the service persons containing all rooms with affiliated persons
     * @param roomCounter sets the start integer for the id which is increased with every new entry
     * @param allRoomList is a list with all rooms
     */
    private Integer id;
    private String title;
    private Integer floor;
    private Building buildingAffiliation;
    private Map<String, List<String>> allRoomData = new HashMap<>(); // No Setter necessary --> Is filled internally by the other methods
    private List<DevPersonsService> allPersonsForThisRoom = new ArrayList<>();
    public  List<Event> roomEvents = new ArrayList<>(); //--> fix to private and add getter + setter then fix related issues

    private static List<DevPersonsService> allPersonsWithRoom = new ArrayList<>();
    private static HashMap<Room, List <DevPersonsService>> roomsWithPersons = new HashMap<>();
    private static Integer roomCounter = 0;
    private static List<Room> allRoomsList = new ArrayList<>();

    /**
     * constructor for the room
     * it increases the roomCounter by one and calls the setter and add functions
     */
    public Room(String roomTitle, Integer floorNumber, List<DevPersonsService> roomPersons, Building affiliatedBuilding) {

        roomCounter += 1;
        this.id = roomCounter;

        setTitleForRoom (roomTitle);
        setFloorForRoom (floorNumber);
        setPersonsForRoom (roomPersons);
        setAffiliationForRoom (affiliatedBuilding);
        setRoomsWithPersonsHashmap();
        addRoomToAllRoomsList();
    }


    /**
     * alternative constructor when there are nor persons/person assigned to the room
     */
    public Room(String roomTitle, Integer floorNumber, Building affiliatedBuilding) {

        roomCounter += 1;

        setTitleForRoom (roomTitle);
        setFloorForRoom (floorNumber);
        setAffiliationForRoom (affiliatedBuilding);
        setIdForRoom(this.id);
        addRoomToAllRoomsList();
    }
    public Room(String roomTitle, Building affiliatedBuilding){

        roomCounter += 1;
        setIdForRoom(this.id);
        setAffiliationForRoom(affiliatedBuilding);
        setTitleForRoom(roomTitle);
    }


    /**
     * alternative constructor when there are nor persons/person assigned to the room
     */
    public void setRoomsWithPersonsHashmap() {
        roomsWithPersons.put(this, this.allPersonsForThisRoom);
    }


    /**
     * set function to assign the room a title/name/room number
     */
    public void setTitleForRoom(String roomTitle) {
        this.title = roomTitle;

        List<String> Titles = new ArrayList<>();
        Titles.add(roomTitle);

        this.allRoomData.put(TITLE,Titles);
       updateRoomDataHashmap();
    }


    /**
     * set function to assign the room a floor/level
     */
    public void setFloorForRoom(Integer floorNumber) {
        this.floor = floorNumber;
        List<String> Floor = new ArrayList<>();
        Floor.add(String.valueOf(floorNumber));

        this.allRoomData.put(FLOOR, Floor);
        updateRoomDataHashmap();
    }


    /**
     * set function assign a list of persons to a room
     */
    public void setPersonsForRoom(List<DevPersonsService> roomPersons) {

        this.allPersonsForThisRoom = roomPersons;

        for (DevPersonsService person : roomPersons){

            if(!allPersonsWithRoom.contains(person)) {

                allPersonsWithRoom.add(person);
            }
        }

        List<String> personTitle = new ArrayList<>();

        for(DevPersonsService person : roomPersons) {

            personTitle.add(person.getFullName());
        }

        this.allRoomData.put(PERSONS, personTitle);
        setRoomsWithPersonsHashmap();
        updateRoomDataHashmap();
    }


    /**
     * set function to assign a room to a building
     */
    public void setAffiliationForRoom(Building affiliatedBuilding) {
        this.buildingAffiliation = affiliatedBuilding;
        List<String> affiliatedBuildingTitle = new ArrayList<>();
        affiliatedBuildingTitle.add(affiliatedBuilding.getTitle());

        this.allRoomData.put(BUILDING_AFFILIATION,affiliatedBuildingTitle);
        updateRoomDataHashmap();
    }


    /**
     * set function to give a room a specific id
     */
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


    /**
     * function to set an event in rooms for the interface with
     */
    @Override
    public void setEvents() {
        CampusUtilities.setClassEvents(ROOM, this.getRoomTitle(), Collections.singletonList(this.roomEvents));
    }
    public List<Event> getEvents() {return this.roomEvents;}


    /**
     * get functions, they return the respective data types
     */
    public Integer getRoomID() {return this.id;}
    public String getRoomTitle() {return this.title;}
    public Integer getFloorNumber() {return this.floor;}
    public Building getBuildingAffiliation() {return this.buildingAffiliation;}
    public List<DevPersonsService> getAllPersonsForThisRoom() {
        return allPersonsForThisRoom;
    }
    public static List<Room> getAllRoomsList() {return allRoomsList;}
    public static HashMap<Room, List <DevPersonsService>> getRoomsWithPersons(){return roomsWithPersons;}
    public static List <DevPersonsService> getAllPersonsWithRoom (){

        return allPersonsWithRoom;
    }


    /**
     * delete function to delete the room form all hashmaps the room is marked
     */
    public  void deleteRoomFromAllMapsAndLists() {
        Map<String, Map<String, List<String>>> UpdatedRoomHashmap = DataCollector.getRoomData();
        Map<String, Map<String, List<String>>> UpdatedBuildingHashmap = DataCollector.getBuildingData();

        for (String room :DataCollector.getRoomData().keySet())
        {
            if(this.getRoomTitle().equals(room))
            {
                UpdatedRoomHashmap.remove(this.title);
                break;
            }
        }
        DataCollector.setRoomData(UpdatedRoomHashmap);

        for (String building : DataCollector.getBuildingData().keySet()) {
            if (DataCollector.getBuildingData().get(building).containsKey(ROOM)){
                if (DataCollector.getBuildingData().get(building).get(ROOM).contains(this.getRoomTitle())) {

                    UpdatedBuildingHashmap.get(building).get(ROOM).remove(this.getRoomTitle());
                    break;
                }
            }
        }
        DataCollector.setRoomData(UpdatedBuildingHashmap);

        roomsWithPersons.remove(this);
        allRoomsList.remove(this);
    }


    /**
     * delete function to delete a specific assigned person from a room
     */
    public void deletePersonFromThisRoom(DevPersonsService person) {

        this.allPersonsForThisRoom.remove(person);

        List<String> allTitlesOfPersonsForThisRoom = new ArrayList<>();

        for(DevPersonsService personOfThisRoom : allPersonsForThisRoom) {

            allTitlesOfPersonsForThisRoom.add(String.valueOf(person));
        }

        this.allRoomData.put(PERSONS,allTitlesOfPersonsForThisRoom);
        allPersonsWithRoom.remove(person);

        updateRoomDataHashmap();
        setRoomsWithPersonsHashmap();
    }


    /**
     * add function to add a specific assigned person to a room
     * and adds them in the respective hashmaps by function calls
     */
    public void addPersonToThisRoom(DevPersonsService person) {

        this.allPersonsForThisRoom.add(person);
        List<String> personFullName = new ArrayList<>();

        for(DevPersonsService personOfThisRoom : allPersonsForThisRoom)
        {
            personFullName.add(personOfThisRoom.getFullName());
        }

        this.allRoomData.put(PERSONS,personFullName);

        updateRoomDataHashmap();
        setRoomsWithPersonsHashmap();
    }

    /**
     *
     * @param searchedRoom = search String entered
     * @return boolean --> true if searched Room Title exists, false if it does not
     */
    @Override
    public boolean checkRoomExists(String searchedRoom)
    {
        for(Room existingRoom : allRoomsList)
        {
            if (Objects.equals(searchedRoom,existingRoom.getRoomTitle()))
            {
                return true;
            }
        }
        return false;
    }


    /**
     * adds a room to the hashmap which contains all rooms
     */
    public void addRoomToAllRoomsList(){

        allRoomsList.add(this);
    }


    /**
     * search for a room of a specific person
     */
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


    /**
     * function to update the hashmaps
     */
    public void updateRoomDataHashmap() {

        Map<String, Map<String, List<String>>> UpdatedRoomData = DataCollector.getRoomData();
        UpdatedRoomData.put(this.title,this.allRoomData);
        UpdatedRoomData.remove(null);
        DataCollector.setRoomData(UpdatedRoomData);
    }


}