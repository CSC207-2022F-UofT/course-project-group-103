package interactors.input_boundary;

public interface LoginInput {

    /**
     * Logs a user in.
     *
     * @param username: username of account to log in.
     * @param password: password of account to log in.
     */
    void login(String username, String password);
    String getSecurityQuestion(String name);
}
