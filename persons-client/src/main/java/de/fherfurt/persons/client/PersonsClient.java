package de.fherfurt.persons.client;
/**
 * @author Tran Anh Hoang
 * @version 1.0.0.0
 * This Interface defines the provided functionality for Person Service.
 * It should be used by other services.
 */
public interface PersonsClient {

    DevPersonsService findPersonUsingIteratorBy(int PersonID);

    byte[] findPersonAvatarBy(int personId);


}
