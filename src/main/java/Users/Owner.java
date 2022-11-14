package Users;

import Managers.PropertyManager;

import java.util.List;

public class Owner extends User {
    PropertyManager p;
    String contact_info;

    public Owner() {
        super();
    }
    public List[] getReviews() {

    }

    public void addContact (String contact_info) {
        this.contact_info = contact_info;
    }
}
