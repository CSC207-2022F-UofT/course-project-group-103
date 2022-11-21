package Users;

public class User {
    private String name;
    public Realtor hiredRealtor;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void hireRealtor(Realtor realtor) {
        this.hiredRealtor = realtor;
        realtor.getClientManager().addClient(this);
    }
}
