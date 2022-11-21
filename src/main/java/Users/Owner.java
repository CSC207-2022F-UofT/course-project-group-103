package Users;

import Managers.PropertyManager;


public class Owner extends User {
    private PropertyManager p;
    private String contact_info;

    public Owner(String name, String id) {
        super(name, id);
        p = new PropertyManager();
    }

    public void addContact(String contact_info) {
        this.contact_info = contact_info;
    }

    public String getContact() {
        return contact_info;
    }
}
