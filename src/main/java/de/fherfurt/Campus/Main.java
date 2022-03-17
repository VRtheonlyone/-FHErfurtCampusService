package de.fherfurt.Campus;
import java.lang.*;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static final String ROOM = "Room" ;
    public static final String GEOLOCATION = "Geolocation";
    public static final String ID = "ID";
    public static final String ACCESSIBILITY = "Accessibility";
    public static final String TYPES = "Types";
    public static final String TITLE = "Title";
    public static final String CAMPUS_AFFILIATION ="Campus Affiliation";
    public static final String BUILDING_AFFILIATION ="Building Affiliation";
    public static final String EVENTS ="Events";
    public static final String LOCATION = "Location";
    public static final String BUILDING = "Building";
    public static final String PERSONS = "Persons";
    public static final String FLOOR = "Floor";
    public static final String NO_SEARCH_PATTERN = "No search Pattern found!";

    public static final String EDUCATION = "Education";
    public static final String CAFETERIA = "Cafeteria";
    public static final String LIBRARY = "Library";
    public static final String GYMNASIUM = "Gymnasium";

    /*Campus Types*/
    public static final String CAMPUS_1 = "Schlüterstrasse";
    public static final String CAMPUS_2 = "Leipziger Strasse";
    public static final String CAMPUS_3 = "Altonaer Strasse";


    public static void main(String[] args) {

        DataCollector FirstDataCollector = new DataCollector();

        List <String> RoomList1 = new ArrayList<>();
        RoomList1.add("R 202");
        RoomList1.add("H 324");
        RoomList1.add("H 302");
        RoomList1.add("H 402");

        List <String> RoomList2 = new ArrayList<>();
        RoomList2.add("R 111");
        RoomList2.add("R 222");

        List <String> TypeList1 = new ArrayList<>();
        TypeList1.add("Gymnasium");
        TypeList1.add("Cafeteria");

        List <String> TypeList2 = new ArrayList<>();
        TypeList1.add("Education");

        List <String> Event = new ArrayList<>();
        Event.add("Megaparty");
        Event.add("3rd August 2022");

        Building House1 = new Building(true, "Haus 1", RoomList1,"denflwqwd", TypeList1 , CAMPUS_2 , FirstDataCollector);
        Building House2 = new Building(false, "Haus 2", RoomList2,"123.12312", TypeList2 , CAMPUS_1 , FirstDataCollector);
        Room Room1 = new Room("Room1", 1, House1.getTitle(),FirstDataCollector);
        Room Room2 = new Room("Room2", 2, House2.getTitle(),FirstDataCollector);


        House1.setIDForBuilding(5,FirstDataCollector);
        System.out.printf("My ID: %s\n",House1.getID());

        System.out.printf("Buildings: %s\n", Building.getAllBuildings(FirstDataCollector));
        System.out.printf("Rooms: %s\n", Room.getAllRooms(FirstDataCollector));

        System.out.printf("Search Result: %s\n", Search.searchForResults("Haus 1", BUILDING, FirstDataCollector));

        System.out.printf("Building Key Set: %s\n", FirstDataCollector.BuildingData.get("Haus 2").get(GEOLOCATION));
        System.out.printf("Room Key Set: %s\n", FirstDataCollector.RoomData.get("Room1").get(FLOOR));
    }
}
