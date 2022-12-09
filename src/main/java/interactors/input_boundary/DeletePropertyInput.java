package interactors.input_boundary;

public interface DeletePropertyInput {

    /**
     * Deletes property if the owners password match.
     *
     * @param id: ID of property to delete.
     * @param password: password of owner of property to delete.
     */
    void deleteProperty(String id, String password);
}
