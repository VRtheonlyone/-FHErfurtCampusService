package de.fherfurt.Campus;
import java.lang.*;

public class Main {

    public static final BuildingDataCollection BuildingDataCollector = new BuildingDataCollection();
    public static final LocationDataCollection LocationDataCollector = new LocationDataCollection(); //--> Helen
    public static final RoomDataCollection RoomDataCollector = new RoomDataCollection(); //--> Jann



    public static final String LOCATION = "Location";
    public static final String BUILDING = "Building";
    public static final String ROOM = "Room";

    public Main(String LOCATION,String BUILDING, String ROOM ) {
        this.LOCATION=LOCATION;
        this.BUILDING=BUILDING;
        this.ROOM=ROOM;
    }
public String getLocation() {
 return LOCATION;
}
public void setLocation(String LOCATION) {
        this.LOCATION=LOCATION;
    }


    public String getBuilding() {
        return BUILDING;
    }
    public void setBuilding(String BUILDING){
        this.BUILDING=BUILDING;
    }


    public String getRoom() {
        return ROOM;
    }
    public void setRoom(String ROOM){
        this.ROOM=ROOM;
    }

    public static void main(String[] args) {
        Object Search = new Search(
                Object Buildingcollection,
        );
        System.out.println(de.fherfurt.Campus.Search.searchForResults("1", ROOM));


    }
}
