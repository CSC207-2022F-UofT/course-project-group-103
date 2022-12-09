package interactors.input_boundary;

public interface SignUpInput {

    /**
     * Signs up a new user.
     *
     * @param username: username of new account to sign up.
     * @param contact: contact information of new account to sign up.
     * @param password: password of new account to sign up.
     * @param confirm_password: password confirmation of new account to sign up.
     */
    void signUp(String username, String contact, String password, String confirm_password, String securityQuestion,
                String securityAnswer);
}
