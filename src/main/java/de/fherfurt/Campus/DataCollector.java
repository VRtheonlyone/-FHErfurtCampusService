package de.fherfurt.Campus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCollector {



    public static Integer BuildingCounter = 0;
    public static Integer RoomCounter = 0;
    public static Integer CampusCounter = 0;

    public Map<String, Map<String, List<String>>> CampusData = new HashMap<>();
    public Map<String, Map<String, List<String>>> BuildingData = new HashMap<>();
    public Map<String, Map<String, List<String>>> RoomData = new HashMap<>();

    /* public DataCollector(List<String> CampusKeys, List<String> BuildingKeys, List<String> RoomKeys) {

        //this.buildInnerCampusMap();

    } */

    public Map <String, List <String>> buildInnerCampusMap(List<String> CampusKeys)
    {
        Map<String, List<String>> innerCampusMap = new HashMap <>();
        for(String key : CampusKeys){
            innerCampusMap.put(key, null);

        }
        return innerCampusMap;
    }


}
