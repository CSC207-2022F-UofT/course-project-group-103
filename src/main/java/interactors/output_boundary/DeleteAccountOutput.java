package interactors.output_boundary;

public interface DeleteAccountOutput {
    void onDeleteAccountSuccess();
    void onDeleteAccountFailure(String message);
}
