package Users;

import java.util.ArrayList;

public class Realtor extends User{
    public Realtor(String ID, String name, String password, String contact, String securityQuestion, String securityAnswer) {
        super(ID, name, password, contact, securityQuestion, securityAnswer);
    }

    public ArrayList<String> info() {
        return super.info();
    }
}
