package interactors.gateway_interfaces;

import entities.*;
import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;

import java.io.IOException;
import java.util.ArrayList;

public interface MessengerGateway {

    ArrayList<Messenger> getMessengers(String sender_ID) throws IOException, MessengerNotFound, UndefinedUserType;
    Messenger getMessenger(String sender_ID, String receiver_ID) throws MessengerNotFound, IOException, UndefinedUserType;
    void addMessage(String sender_ID, String receiver_ID, String message) throws UndefinedUserType, IOException, MessengerNotFound;
}
