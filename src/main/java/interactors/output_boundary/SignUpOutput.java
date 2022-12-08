package interactors.output_boundary;

public interface SignUpOutput {
    void onSignUpSuccess(String id);
    void onSignUpFailure(String message);
}
