package Interactors;

import Exceptions.MessengerNotFound;
import Exceptions.UndefinedUserType;
import Managers.MessageManager;
import Managers.PropertyManager;
import Messenger.Messenger;
import Users.User;

import java.io.IOException;
import java.util.ArrayList;

public class OpenMessengerInteractor {
    String sender_ID;
    String receiver_ID;

    public OpenMessengerInteractor(String sender_ID, String receiver_ID) {
        this.sender_ID = sender_ID;
        this.receiver_ID = receiver_ID;
    }

    public void displayChat() throws MessengerNotFound, UndefinedUserType, IOException {
        Messenger currentMessenger = MessageManager.getMessenger(sender_ID, receiver_ID);
        ArrayList<ArrayList<String>> messageLog = currentMessenger.getMessageLog();
        for (ArrayList<String> log : messageLog) {
            System.out.println(log.get(1));
        }
    }

    public String getUsername(String receiver_ID) throws UndefinedUserType, IOException {
        User receiver = PropertyManager.getUser(receiver_ID);
        return  receiver.getName();
    }
}
