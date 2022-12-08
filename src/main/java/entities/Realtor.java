package entities;

public class Realtor extends User{
    /**
     * Constructor for realtor class, assigns values to its attributes.
     *
     * @param ID: Unique ID of the realtor.
     * @param name: Name of the realtor.
     * @param password: Password of the realtor.
     * @param contact: Contact information of the realtor.
     * @param securityQuestion: Chosen Security Question by the realtor.
     * @param securityAnswer: Chosen Security Answer by the realtor.
     */
    public Realtor(String ID, String name, String password, String contact, String securityQuestion, String securityAnswer) {
        super(ID, name, password, contact, securityQuestion, securityAnswer);
    }
}
