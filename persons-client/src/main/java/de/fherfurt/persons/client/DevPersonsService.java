package de.fherfurt.persons.client;

import java.util.List;

/**
 * @author Vadim Rodt, vadim.rodt@fh-erfurt.de
 * An individualised Person Class that includes the functions defined in the PeronsClient interface
 * This class is used heavily by the Room class which tracks Rooms to which certain persons belong
 */

public class DevPersonsService implements PersonsClient {

    private static List<DevPersonsService> persons;
    private String firstname;
    private String lastname;
    private int personID;
    private String roomTitle;

    public DevPersonsService(String firstname, String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public static void setPersons(List<DevPersonsService> persons) {
        DevPersonsService.persons = persons;
    }

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
    }

    @Override
    public byte[] findPersonAvatarBy(int personId) {
        return new byte[0];
    }

    public String getFirstName() {return firstname;}

    public String getLastName() {return lastname;}

    public String getFullName() {return this.firstname+" "+this.lastname;}

    public int getPersonID() {return personID;}

    public String getRoomTitle() {return roomTitle;}
}
