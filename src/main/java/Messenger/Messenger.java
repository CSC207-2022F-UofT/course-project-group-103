package Messenger;

import Users.*;

import java.util.ArrayList;

public class Messenger {
    private User User1;
    private User User2;
    private String ID;
    private ArrayList<String> messageLog = new ArrayList<>();

    public User getUser1() {
        return User1;
    }

    public User getUser2() {
        return User2;
    }

    public ArrayList<String> getMessageLog() {
        return this.messageLog;
    }

    public String sendAlert(){
        return messageLog.get(messageLog.size() - 1);
    }

    public String sendMessage(User sender, String message) {
        messageLog.add(sender.getName() + ": " + message);
        return message;
    }
}
