package interactors;

public class SingleRealtorModel {

    /**
     * Name of the realtor.
     */
    String name;
    /**
     * Contact info of the realtor.
     */
    String contact;
    /**
     * ID of realtor.
     */
    String id;

    /**
     * Constructor for the realtor model, assigns its attributes.
     *
     * @param name: name of realtor
     * @param contact: contact of realtor
     */
    public SingleRealtorModel(String name, String contact, String id) {
        this.name = name;
        this.contact = contact;
        this.id = id;
    }

    /**
     * Gets the name of this realtor.
     * @return String representation of name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the contact info of this realtor.
     * @return String representation of contact info.
     */
    public String getContact() {
        return this.contact;
    }

    /**
     * Gets the ID of this realtor.
     * @return String representation of ID.
     */
    public String getID() {
        return this.id;
    }
}
