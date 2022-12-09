package interactors.output_boundary;

public interface HireRealtorOutput {
    /**
     * Called when hire realtor was successful
     */
    void onHireRealtorSuccess();
    /**
     * Called when hire realtor failed.
     */
    void onHireRealtorFailure(String message);
}
