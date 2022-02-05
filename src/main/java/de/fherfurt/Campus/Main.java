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

    public static void main(String[] args) {
        DataCollector FirstDataCollector = new DataCollector();

        List <String> List1 = new ArrayList<>();
        List1.add("R 202");
        List1.add("H 324");
        List1.add("H 302");
        List1.add("H 402");

        List <String> TypeList = new ArrayList<>();
        TypeList.add("Gymnasium");
        TypeList.add("Cafeteria");

        
        Building House1 = new Building(true, "Haus 1", List1,"123.12312", TypeList , "Campus 3" , FirstDataCollector);


        System.out.printf("Building with accessibility: %b\n",House1.getAccessibility());
        System.out.printf("Building with title: %s\n",House1.getTitle());
        System.out.printf("Building with rooms: %s\n",House1.getRooms());
        System.out.printf("Building with geoLocation: %s\n",House1.getGeoLocation());
        System.out.printf("Building with affiliation: %b\n",House1.getAffiliation());

        System.out.printf("Building with rooms: %s\n",FirstDataCollector.BuildingData);
        House1.addRoom("R 666", FirstDataCollector);
        System.out.printf("Building Data: %s\n",FirstDataCollector.BuildingData);

        House1.addAffiliation("Campus 1",FirstDataCollector);
        System.out.printf("Building Data: %s\n",FirstDataCollector.BuildingData);

        House1.deleteBuilding(FirstDataCollector);

        System.out.printf("Building Data: %s\n",FirstDataCollector.BuildingData);





        //Object Search = new Search();

        //System.out.println(de.fherfurt.Campus.Search.searchForResults("1", ROOM));


    }
}
