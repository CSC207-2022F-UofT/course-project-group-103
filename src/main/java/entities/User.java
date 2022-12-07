package entities;

public class User {

    /**
     * Unique ID of the user.
     */
    private final String ID;
    /**
     * Name of the user.
     */
    private String name;
    /**
     * Password of the user.
     */
    private String password;
    /**
     * Contact information of user.
     */
    private String contact;
    /**
     * ID of user's hired realtor.
     */
    private String hiredRealtorID;

    /**
     * One of the constructors for the user class, assigns values to its attributes. This constructor
     * will assign a hiredRealtorID.
     *
     * @param ID: Unique ID of the user.
     * @param name: Name of the user.
     * @param password: Password of the user.
     * @param contact: Contact information of the user.
     * @param hiredRealtorID: ID of the user's hired realtor.
     */
    public User(String ID, String name, String password, String contact, String hiredRealtorID) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.hiredRealtorID = hiredRealtorID;
    }

    /**
     * One of the constructors for the user class, assigns values to its attributes. This constructor
     * will assign a hiredRealtorID.
     *
     * @param ID: Unique ID of the user.
     * @param name: Name of the user.
     * @param password: Password of the user.
     * @param contact: Contact information of the user.
     */
    public User(String ID, String name, String password, String contact) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.hiredRealtorID = null;
    }

    /**
     * Returns the ID of the user.
     * @return string of user ID.
     */
    public String getID() {
        return ID;
    }

    /**
     * Returns the name of the user.
     * @return string of the user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the password of the user.
     * @return string of the user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the contact information of the user.
     * @return string of the user's contact information.
     */
    public String getContact() {
        return contact;
    }

    /**
     * Returns the ID of the hired realtor of the user.
     * @return string of the user's hired realtor's ID.
     */
    public String getHiredRealtorID() {
        return hiredRealtorID;
    }

    /**
     * Changes the name of the user.
     *
     * @param name: new name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Changes the password of the user.
     *
     * @param password: new password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Changes the contact information of the user.
     *
     * @param contact: new contact information of the user.
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * Changes the hired realtor of the user.
     *
     * @param realtorID: new ID of the user's hired realtor.
     */
    public void hireRealtor(String realtorID){
        this.hiredRealtorID = realtorID;
    }
}
