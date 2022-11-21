package Users;

public class Owner extends User {
    private String name;

    public Owner(String name) {
        super(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
