package de.fherfurt.persons.client;

import java.util.List;

public class DevPersonsService implements PersonsClient {

    private static List<DevPersonsService> persons;
    private String firstname;
    private String lastname;
    private int personID;
    private String roomTitle;

    @Override
    public DevPersonsService findPersonUsingIteratorBy(int personID)
    {
        for(DevPersonsService person : persons)
        {
            if(person.getPersonID() == personID)
            {
                return person;
            }
        }
        return null;
    };

    public String getFirstName() {return firstname;}

    public String getLastName() {return lastname;}

    public String getFullName() {return this.firstname+" "+this.lastname;}

    public int getPersonID() {return personID;}

    public String getRoomTitle() {return roomTitle;}
}
