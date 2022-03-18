package de.fherfurt.Campus.Persons;

import java.util.HashMap;
import java.util.List;

public interface PersonsRooms {

   HashMap<String, List<String>> getAllRoomsWithPersons();
   String SearchRoomOfPerson(String _person);
}
