package interactors.output_boundary;

public interface DeletePropertyOutput {
    void onDeletePropertySuccess();
    void onDeletePropertyFailure(String message);
}
