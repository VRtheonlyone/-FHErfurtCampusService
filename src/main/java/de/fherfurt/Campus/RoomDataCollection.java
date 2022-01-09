package de.fherfurt.Campus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomDataCollection extends GeneralDataCollection{

    // Hashmap of the roomID´s
    public Map <String, Integer> roomID = new HashMap<>();

    //
    public Map <String, String> roomTitle = new HashMap<>();

    // Hashmap of the Room and all the Persons associated with that room
    public Map <String, List<String>> roomPersons = new HashMap<>();



}
