package interactors.output_boundary;

public interface ChangePasswordOutput {
    void onWrongSecurityAnswer(String message);
    void onChangePasswordSuccess(String message);
}
