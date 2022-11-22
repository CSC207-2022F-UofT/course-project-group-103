package Users;

public class User {

    protected final String ID;
    protected String name;
    protected String password;
    protected String contact;
    protected String hiredRealtorID;
    protected String securityQuestion;
    protected String securityAnswer;

    public User(String ID, String name, String password, String contact, String hiredRealtorID, String securityQuestion, String securityAnswer) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.hiredRealtorID = hiredRealtorID;
    }

    public User(String ID, String name, String password, String contact, String securityQuestion, String securityAnswer) {
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

    public void sendOffer(){

    }

    public void sendBid(){

    }

    public void hireRealtor(String realtorID){
        this.hiredRealtorID = realtorID;
    }
}
