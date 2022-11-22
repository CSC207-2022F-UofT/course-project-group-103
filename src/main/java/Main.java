import Exceptions.UndefinedUserType;
import Managers.PropertyManager;
import Users.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UndefinedUserType, IOException {
        User user = PropertyManager.getUser("4");
        System.out.println(user.getName());
        User user1 = PropertyManager.getUser("1");
        System.out.println(user1.getName());
        User user2 = PropertyManager.getUser("2");
        System.out.println(user2.getName());
    }
}
