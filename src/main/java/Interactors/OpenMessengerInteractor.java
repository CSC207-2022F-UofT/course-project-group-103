package Interactors;

import Exceptions.MessengerNotFound;
import Exceptions.UndefinedUserType;
import Managers.MessageManager;
import Messenger.Messenger;

import java.io.IOException;
import java.util.ArrayList;

public class OpenMessengerInteractor {
    String User1_ID;
    String User2_ID;

    public OpenMessengerInteractor(String User1_ID, String User2_ID) {
        this.User1_ID = User1_ID;
        this.User2_ID = User2_ID;
    }

    public void displayChat() throws MessengerNotFound, UndefinedUserType, IOException {
        Messenger currentMessenger = MessageManager.getMessenger(User1_ID, User2_ID);
        ArrayList<ArrayList<String>> messageLog = currentMessenger.getMessageLog();
        for (ArrayList<String> log : messageLog) {
            System.out.println(log.get(1));
        }
    }
}
