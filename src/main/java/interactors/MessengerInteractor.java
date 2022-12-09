package interactors;

import entities.User;
import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;
import interactors.gateway_interfaces.LoginGateway;
import interactors.gateway_interfaces.MessengerGateway;
import entities.Messenger;
import interactors.input_boundary.MessengerInput;
import interactors.output_boundary.MessengerOutput;

import java.io.IOException;
import java.util.ArrayList;

public class MessengerInteractor implements MessengerInput {

    MessengerGateway messengerGateway;

    LoginGateway loginGateway;
    MessengerOutput openMessengerOutput;

    public MessengerInteractor(MessengerGateway gatewayMessenger, LoginGateway gatewayLogin, MessengerOutput output) {
        this.messengerGateway = gatewayMessenger;
        this.loginGateway = gatewayLogin;
        this.openMessengerOutput = output;
    }

    public ArrayList<String> getChat(String sender_ID, String receiver_ID) throws UndefinedUserType, IOException, MessengerNotFound {
        Messenger currentMessenger = this.messengerGateway.getMessenger(sender_ID, receiver_ID);
        ArrayList<ArrayList<String>> messageLog = currentMessenger.getMessageLog();
        ArrayList<String> messages = new ArrayList<>();
        String username1 = loginGateway.getUser(sender_ID).getName();
        String username2 = loginGateway.getUser(receiver_ID).getName();
        for (ArrayList<String> log : messageLog) {
            if (sender_ID.equals(log.get(0))) {
                messages.add(username1 + ": " + log.get(1));
            } else if (receiver_ID.equals(log.get(0))) {
                messages.add(username2 + ": " + log.get(1));
            }
        }
        return messages;
    }

    public String[] getNames(String sender_ID) throws IOException, UndefinedUserType, MessengerNotFound {
        ArrayList<Messenger> messengers = this.messengerGateway.getMessengers(sender_ID);
        String[] messengerNames = new String[messengers.size()];
        for (int i = 0; i < messengers.size(); i++) {
            if (sender_ID.equals(messengers.get(i).getUser1ID())) {
                String user2ID = messengers.get(i).getUser2ID();
                User user2 = loginGateway.getUser(user2ID);
                messengerNames[i] = (user2.getName());
            } else if (sender_ID.equals(messengers.get(i).getUser2ID())) {
                String user1ID = messengers.get(i).getUser1ID();
                User user1 = loginGateway.getUser(user1ID);
                messengerNames[i] = (user1.getName());
            }
        }
        return messengerNames;
    }

    public String getUserID(String username) {
        ArrayList<User> users = loginGateway.getUsers();
        for (User user: users) {
            if (user.getName().equals(username)) {
                return user.getID();
            }
        }
        return null;
    }
}