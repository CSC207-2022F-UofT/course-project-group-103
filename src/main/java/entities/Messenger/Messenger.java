package entities.Messenger;

import entities.users.User;

import java.util.ArrayList;

public class Messenger {
    private User User1;
    private User User2;
    private String ID;
    private ArrayList<ArrayList<String>> messageLog = new ArrayList<>();

    public User getUser1() {
        return User1;
    }

    public User getUser2() {
        return User2;
    }

    public ArrayList<ArrayList<String>> getMessageLog() {
        return this.messageLog;
    }

    public void addMessage(User sender, String message) {
        /**
         * This method takes in a User object (sender) and a String (message) and creates an arrayList containing the
         * sender's ID and the message they have sent. This Arraylist is then stored in the message Log.
         */
        ArrayList<String> newLog = new ArrayList<>();
        newLog.add(sender.getID());
        newLog.add(message);
        messageLog.add(newLog);
    }
}
