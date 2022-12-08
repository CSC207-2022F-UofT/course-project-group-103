package interactors.output_boundary;

public interface DeleteAccountOutput {

    /**
     * Called when an account was successfully deleted.
     */
    void onDeleteAccountSuccess();
    /**
     * Called when an attempt to delete an account was failed.
     *
     * @param message: failure message
     */
    void onDeleteAccountFailure(String message);
}
