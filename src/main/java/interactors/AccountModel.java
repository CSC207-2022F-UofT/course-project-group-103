package interactors;

public class AccountModel {

    String name;
    String id;
    String contact;
    String securityQuestion;
    String securityAnswer;

    /**
     * Constructor that creates a user that is logged in.
     *
     * @param name: name of the user
     * @param id: id of the user
     * @param contact: contact of the user
     * @param securityQuestion: security question of the user
     * @param securityAnswer: security answer of the user
     */
    public AccountModel(String name, String id, String contact, String securityQuestion, String securityAnswer) {
        this.name = name;
        this.id = id;
        this.contact = contact;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }

    /**
     * Constructor that creates a user that is not logged in.
     *
     * @param name: name of the user
     * @param id: id of the user
     */
    public AccountModel(String name, String id) {
        this.name = name;
        this.id = id;
        this.contact = null;
        this.securityQuestion = null;
        this.securityAnswer = null;
    }

    public String getName() {
        return this.name;
    }

    public String getID() {
        return this.id;
    }

    public String getContact() {
        return this.contact;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }
}
