package Users;

import Messenger.Messenger;

import java.util.ArrayList;

public class User {

    private String name;
    private String password;
    private String contact;
    private Realtor hiredRealtor;
    private ArrayList<Messenger> messengers;

    public User(String name, String password, String contact, Realtor hiredRealtor, ArrayList<Messenger> messengers) {
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.hiredRealtor = hiredRealtor;
        this.messengers = messengers;
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

    public Realtor getHiredRealtor() {
        return hiredRealtor;
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

    public void sendOffer(){
    }

    public void sendBid(){

    }

    public void hireRealtor(Realtor realtor){

    }
}
