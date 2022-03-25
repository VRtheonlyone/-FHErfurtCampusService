package de.fherfurt.campus.client;

/**
 * @author Vadim Rodt, vadim.rodt@fh-erfurt.de
 * This interface was programmed for the Persons Service with which they can check whether a certain Room exists
 *
 */

public interface CampusForPersonsClient {

    boolean checkRoomExists(String searchedRoom);
}
