package Messenger;

import Exceptions.UndefinedUserType;
import Managers.PropertyManager;
import Users.*;

import java.io.IOException;
import java.util.ArrayList;

public class Messenger {
    private String User1_ID;
    private String User2_ID;
    private String ID;
    private ArrayList<ArrayList<String>> messageLog = new ArrayList<>();

    public Messenger(String User1_ID, String User2_ID, String ID, ArrayList<ArrayList<String>> messageLog) {
        this.User1_ID = User1_ID;
        this.User2_ID = User2_ID;
        this.ID = ID;
        this.messageLog = messageLog;
    }

    public String getUser1_ID() {
        return User1_ID;
    }

    public String getUser2_ID() {
        return User2_ID;
    }

    public String getID() {
        return ID;
    }

    public ArrayList<ArrayList<String>> getMessageLog() {
        return this.messageLog;
    }

}
