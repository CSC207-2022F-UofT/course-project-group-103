package interactors.output_boundary;

public interface SignUpOutput {

    /**
     * Called with the id of the user when they are signed up.
     *
     * @param id: id of the user who was signed up.
     */
    void onSignUpSuccess(String id);

    /**
     * Called when an attempt to sign up fails.
     *
     * @param message: failure message.
     */
    void onSignUpFailure(String message);
}
