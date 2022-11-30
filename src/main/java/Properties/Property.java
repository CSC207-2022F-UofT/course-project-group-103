package Properties;
import org.json.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Users.Owner;

public abstract class Property {

    private String name;
    private String address;
    private String ID;

    private Owner owner;
    private int sqFt;

    private float price;

    public Property(String name, String address, String ID, Owner owner, int sqFt, float price) {
        this.name = name;
        this.address = address;
        this.ID = ID;
        this.owner = owner;
        this.sqFt = sqFt;
        this.price = price;
    }

    public Property() {

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getID() {
        return ID;
    }

    public Owner getOwner() {
        return owner;
    }

    public int getSqFt() {
        return sqFt;
    }
    public float getPrice(String id) { return price; }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract  void getSold();
    public  abstract  void markSold();

    public abstract void editProperty();

    public abstract void updateListing();

}



