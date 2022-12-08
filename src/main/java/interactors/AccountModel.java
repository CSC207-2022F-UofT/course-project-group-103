package interactors;

public class AccountModel {

    /**
     * Username of account.
     */
    String name;
    /**
     * ID of account.
     */
    String id;
    /**
     * Contact information of account.
     */
    String contact;

    /**
     * Constructor of the AccountModel, assigns its attributes.
     *
     * @param name: name of account.
     * @param id: id of account
     * @param contact: contact information of account.
     */
    public AccountModel(String name, String id, String contact) {
        this.name = name;
        this.id = id;
        this.contact = contact;
    }

    /**
     * Gets the name of the account.
     * @return String representation of name of the account.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the ID of the account.
     * @return String representation of ID of the account.
     */
    public String getID() {
        return this.id;
    }

    /**
     * Gets the contact information of the account.
     * @return String representation of the contact information of the account.
     */
    public String getContact() {
        return this.contact;
    }
}
