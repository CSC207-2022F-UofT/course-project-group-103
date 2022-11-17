package Users;

public class User {

    private String name;
    private String password;
    private String contact;
    private Realtor hiredRealtor;

    public User(String name, String password, String contact, Realtor hiredRealtor) {
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.hiredRealtor = hiredRealtor;
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
