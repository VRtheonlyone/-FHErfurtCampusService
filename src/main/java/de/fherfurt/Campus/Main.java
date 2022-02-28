package de.fherfurt.Campus;
import java.lang.*;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static final String ROOMS = "Rooms" ;
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

        Building House1 = new Building(true, "Haus 1", RoomList1,"123.12312", TypeList1 , CAMPUS_2 , FirstDataCollector);
        Building House2 = new Building(false, "Haus 2", RoomList2,"123.12312", TypeList2 , CAMPUS_1 , FirstDataCollector);

        House1.setIDForBuilding(5,FirstDataCollector);
        System.out.printf("My ID: %s",House1.getID());
    }
}
