package interactors.input_boundary;

public interface DeleteAccountInput {

    /**
     * Deletes account if passwords match.
     *
     * @param id: ID of account to delete.
     * @param password: password of account to delete.
     */
    void deleteAccount(String id, String password);
}
