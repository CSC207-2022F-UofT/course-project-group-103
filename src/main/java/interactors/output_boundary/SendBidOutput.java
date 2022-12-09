package interactors.output_boundary;

public interface SendBidOutput {
    /**
     * Called when a bid was successfully placed.
     */
    void onSendBidSuccess();
    /**
     * Called when a bid attempt was fails.
     *
     * @param message: failure message.
     */
    void onSendBidFailure(String message);
}
