package entities.users;

import entities.Messenger.Messenger;

import entities.review.Review;

import java.util.ArrayList;

import exceptions.MessengerNotFound;

import exceptions.MessageNotAppropriate;

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

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
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

    public void sendMessage(User receiver, String message) throws MessengerNotFound, MessageNotAppropriate{
        /**
         * Given a User object (receiver) and a String (message), this method uses the getMessenger method to
         * locate the User object's Entities.Messenger class and logs the String message into the messageLog using addMessage.
         * This method also checks if a message is inappropriate via the 'calculateIfAppropriate' method.
         * If the message contains inappropriate language, an error message will be thrown and the message will not
         * be logged.
         */
        Messenger MessengerToBeUsed = getMessenger(receiver);
        if (Review.calculateIfAppropriate(message)) {
            MessengerToBeUsed.addMessage(receiver, message);
        } else {
            throw new MessageNotAppropriate("This message is inappropriate");
        }
    }

    public Messenger getMessenger(User contact) throws MessengerNotFound {
        /**
         * This method takes in a User Object and iterates through a user's messengers attribute and returns the
         * Entities.Messenger class that contains the User "contact".
         * We need this Entities.Messenger class in order to store the messages in the correct messageLog since
         * the messengers attribute contains many Entities.Messenger classes, each with their own messageLogs.
        */
        for (Messenger MessengerClass : messengers) {
            if ((this == MessengerClass.getUser1() && contact == MessengerClass.getUser2()) ||
                    (this == MessengerClass.getUser2() && contact == MessengerClass.getUser1())) {
                return MessengerClass;
            }
        }
    throw new MessengerNotFound("Entities.Messenger not found in messengers");
    }
}
