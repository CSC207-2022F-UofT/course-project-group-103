package Users;

public class User {

    protected String name;

    protected String ID;
    protected String password;
    protected String contact;
    protected String hiredRealtorID;

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

    public void setId(String id) {
        this.ID = id;
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
