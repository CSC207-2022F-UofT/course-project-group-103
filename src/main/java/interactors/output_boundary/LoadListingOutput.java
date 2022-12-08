package interactors.output_boundary;

import interactors.SingleListingModel;

import java.util.ArrayList;

public interface LoadListingOutput {

    /**
     * Called with the listing info when the listings were successfully loaded.
     *
     * @param info: Array list of single listing models for all properties in database
     */
    void onLoadListingSuccess(ArrayList<SingleListingModel> info);
    /**
     * Called when an attempt to load the listings failed.
     *
     * @param message: failure message
     */
    void onLoadListingFailure(String message);
}
