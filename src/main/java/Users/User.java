package Users;

import Messenger.Messenger;

import java.util.ArrayList;

import Exceptions.MessengerNotFound;

public class User {

    private final String ID;
    private String name;
    private String password;
    private String contact;
    private String hiredRealtorID;

    private ArrayList<Messenger> messengers;

    public User(String ID, String name, String password, String contact, String hiredRealtorID) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.hiredRealtorID = hiredRealtorID;
    }

    public User(String ID, String name, String password, String contact) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.hiredRealtorID = null;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getContact() {
        return contact;
    }

    public String getHiredRealtorID() {
        return hiredRealtorID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void sendOffer() {
    }

    public void sendBid() {
    }

    public void hireRealtor(String realtorID) {
        this.hiredRealtorID = realtorID;
    }

    public void sendMessage(User receiver, String message) {
        Messenger MessengerToBeUsed = getMessenger(receiver);
        MessengerToBeUsed.addMessage(receiver, message);
    }

    public Messenger getMessenger(User messenger) {
        /*
        This method takes in a User Object and returns its associated Messenger Class.
        We need this Messenger class to store the messages in the correct messageLog since
        the messengers attribute contains many Messenger classes, each with their own messageLogs.
        */
        for (Messenger MessengerClass : messengers) {
            if ((this == MessengerClass.getUser1() && messenger == MessengerClass.getUser2()) ||
                    (this == MessengerClass.getUser2() && messenger == MessengerClass.getUser1())) {
                return MessengerClass;
            }
        }
    return error;
    }
}
