package entities;


import java.util.ArrayList;

public class Messenger {
    private final String user1ID;
    private final String user2ID;
    private final String ID;
    private ArrayList<ArrayList<String>> messageLog = new ArrayList<>();

    public Messenger(String user1ID, String user2ID, String ID, ArrayList<ArrayList<String>> messageLog) {
        this.ID = ID;
        this.user1ID = user1ID;
        this.user2ID = user2ID;
        this.messageLog = messageLog;
    }

    public String getUser1ID() {
        return user1ID;
    }

    public String getUser2ID() {
        return user2ID;
    }

    public String getID() {
        return ID;
    }

    public ArrayList<ArrayList<String>> getMessageLog() {
        return this.messageLog;
    }

}
