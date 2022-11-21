package Users;

public class User {

    protected String name;

    protected String id;
    protected String password;
    protected String contact;
    protected Realtor hiredRealtor;

    public User(String name, String id, String password, String contact) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.contact = contact;
        this.hiredRealtor = null;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

        this.hiredRealtor = realtor;
    }
}
