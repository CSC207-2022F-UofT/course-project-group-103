package interactors.input_boundary;

public interface LoadAccountInput {
    /**
     * Accesses the account of the given ID.
     *
     * @param id: ID of account to access.
     */
    void loadAccount(String id);
}
