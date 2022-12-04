package entities;

public class User {

    private final String ID;
    private String name;
    private String password;
    private String contact;
    private String hiredRealtorID;

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

    public void sendOffer(){

    }

    public void sendBid(){

    }

    public void hireRealtor(String realtorID){
        this.hiredRealtorID = realtorID;
    }
}
