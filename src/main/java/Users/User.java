package Users;

import Messenger.Messenger;

import java.util.ArrayList;

import Exceptions.MessengerNotFound;

public class User {

    protected final String ID;
    protected String name;
    protected String password;
    protected String contact;
    protected String hiredRealtorID;
    protected String securityQuestion;
    protected String securityAnswer;

    private ArrayList<Messenger> messengers;


    public User(String ID, String name, String password, String contact, String hiredRealtorID, String securityQuestion, String securityAnswer) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.hiredRealtorID = hiredRealtorID;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }

    public User(String ID, String name, String password, String contact, String securityQuestion, String securityAnswer) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
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

    public void sendMessage(User receiver, String message) throws MessengerNotFound {
        Messenger MessengerToBeUsed = getMessenger(receiver);
        MessengerToBeUsed.addMessage(receiver, message);
    }

    public Messenger getMessenger(User messenger) throws MessengerNotFound {
        /**
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
    throw new MessengerNotFound("Messenger not found in messengers");
    }
}
