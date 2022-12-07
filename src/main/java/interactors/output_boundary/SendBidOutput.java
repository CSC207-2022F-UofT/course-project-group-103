package interactors.output_boundary;

public interface SendBidOutput {
    void onSendBidSuccess();
    void onSendBidFailure(String message);
}
