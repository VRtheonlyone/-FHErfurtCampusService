package de.fherfurt.persons.client;
/**
 * @author Tran Anh Hoang
 * @version 1.0.0.0
 */
public interface PersonsClient {

    DevPersonsService findPersonUsingIteratorBy(int PersonID);

    byte[] findPersonAvatarBy(int personId);


}
