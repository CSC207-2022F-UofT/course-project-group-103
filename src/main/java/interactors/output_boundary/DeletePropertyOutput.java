package interactors.output_boundary;

public interface DeletePropertyOutput {

    /**
     * Called when a property was successfully deleted.
     */
    void onDeletePropertySuccess();
    /**
     * Called when an attempt to delete a property was failed.
     *
     * @param message: failure message
     */
    void onDeletePropertyFailure(String message);
}
