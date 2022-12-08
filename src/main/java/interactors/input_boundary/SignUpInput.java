package interactors.input_boundary;

public interface SignUpInput {
    void signUp(String username, String contact, String password, String confirm_password, String securityQuestion,
                String securityAnswer);
}
