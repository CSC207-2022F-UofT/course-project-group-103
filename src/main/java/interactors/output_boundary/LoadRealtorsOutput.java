package interactors.output_boundary;

import interactors.SingleRealtorModel;

import java.util.ArrayList;

public interface LoadRealtorsOutput {
    /**
     * Called when load realtors was successful.
     * @param realtors: Array list of realtor models to be passed to view
     */
    void onLoadRealtorsSuccess(ArrayList<SingleRealtorModel> realtors);
    /**
     * Called when load realtors failed.
     * @param message: String to return.
     */
    void onLoadRealtorsFailure(String message);
}
