package interactors;

public class AccountModel {

    String name;
    String id;
    String contact;

    public AccountModel(String name, String id, String contact) {
        this.name = name;
        this.id = id;
        this.contact = contact;
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
}
