package interactors.output_boundary;

public interface LoginOuput {
    void onLoginSuccess(String id);
    void onLoginFailure(String message);
    void onChangePasswordFailure(String message);
}
