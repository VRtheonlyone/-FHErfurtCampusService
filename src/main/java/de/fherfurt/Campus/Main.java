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

        List <String> TypeList = new ArrayList<>();
        TypeList.add("Gymnasium");
        TypeList.add("Cafeteria");

        List <String> Event = new ArrayList<>();
        Event.add("Megaparty");
        Event.add("3rd August 2022");

        Building House1 = new Building(true, "Haus 1", RoomList1,"123.12312", TypeList , CAMPUS_2 , FirstDataCollector);

        System.out.printf("Building: %s\n",FirstDataCollector.BuildingData);

        System.out.printf("Building with title: %s\n",House1.getTitle());
        System.out.printf("Building with rooms: %s\n",House1.getRooms());

        System.out.printf("Building with accessibility: %s\n",House1.getAccessibility());
        System.out.printf("Building with geoLocation: %s\n",House1.getGeoLocation());
        System.out.printf("Building with affiliation: %s\n",House1.getAffiliation());
        System.out.printf("Building with type: %s\n",House1.getType());
        System.out.printf("Building with affiliation: %s\n",House1.getID());

        House1.setEventForBuilding(Event, FirstDataCollector);
        System.out.printf("Building: %s\n",FirstDataCollector.BuildingData);

        House1.addRoom("R 333", FirstDataCollector);
        System.out.printf("Building Data: %s\n",FirstDataCollector.BuildingData);

        House1.deleteRoom("R 202", FirstDataCollector);
        System.out.printf("Building Data: %s\n",FirstDataCollector.BuildingData);

        House1.deleteBuilding(FirstDataCollector);
        System.out.printf("Building Data: %s\n",FirstDataCollector.BuildingData);
    }
}
