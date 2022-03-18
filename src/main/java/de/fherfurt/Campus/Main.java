package de.fherfurt.Campus;
import java.lang.*;
import java.util.List;
import java.util.ArrayList;

import static de.fherfurt.Campus.Constants.*;

public class Main {

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

        List <String> Persons1 = new ArrayList<>();
        Persons1.add("Günther");
        Persons1.add("Herbet");

        List <String> Persons2 = new ArrayList<>();
        Persons2.add("Richart");
        Persons2.add("Vadim");

        Building House1 = new Building(true, "Haus 1", RoomList1,"denflwqwd", TypeList1 , String.valueOf(Location.Campuses.ALTONAER) , FirstDataCollector);
        Building House2 = new Building(false, "Haus 2", RoomList2,"123.12312", TypeList2 , String.valueOf(Location.Campuses.SCHLUETER) , FirstDataCollector);
        Room Room1 = new Room("Room1", 1, Persons1, House1.getTitle(),FirstDataCollector);
        Room Room2 = new Room("Room2", 2, Persons2, House2.getTitle(),FirstDataCollector);

        House1.setIDForBuilding(5,FirstDataCollector);
        System.out.printf("My ID: %s\n",House1.getID());

        System.out.printf("Buildings: %s\n", Building.getAllBuildings(FirstDataCollector));
        System.out.printf("Rooms: %s\n", Room.getAllRooms(FirstDataCollector));

        System.out.printf("Search Result: %s\n", Search.searchForResults("Haus 1", BUILDING, FirstDataCollector));

        System.out.printf("Building Key Set: %s\n", FirstDataCollector.BuildingData.get("Haus 2").get(GEOLOCATION));
        System.out.printf("Room Key Set: %s\n", FirstDataCollector.RoomData.get("Room1").get(FLOOR));

        System.out.println(Room.getRoomsWithPersons().containsKey("Room1"));
        System.out.println(Room.SearchForPersonInRoomsWithPersons("Richart"));
    }
}
