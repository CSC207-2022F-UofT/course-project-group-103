package Messenger;

import Users.*;

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
        ArrayList<String> Log = new ArrayList<>();
        Log.add(sender.getID());
        Log.add(message);
        messageLog.add(Log);
    }
}
