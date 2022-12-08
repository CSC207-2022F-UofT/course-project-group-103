package interactors.output_boundary;

public interface LoginOuput {

    /**
     * Called with the id of the user when they are logged in.
     *
     * @param id: id of the user who was logged-in.
     */
    void onLoginSuccess(String id);
    /**
     * Called when an attempt to log in fails.
     *
     * @param message: failure message.
     */
    void onLoginFailure(String message);
}
