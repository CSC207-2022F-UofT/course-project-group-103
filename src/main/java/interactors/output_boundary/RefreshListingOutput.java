package interactors.output_boundary;

import interactors.SingleListingModel;

import java.util.ArrayList;

public interface RefreshListingOutput {

    /**
     * Called with the listing info when the filtered listings were successfully loaded.
     *
     * @param info: Array list of single listing models for all properties in database that meet the filters.
     */
    void onUpdateFilterSuccess(ArrayList<SingleListingModel> info);
    /**
     * Called when an attempt to load the filtered listings failed.
     *
     * @param message: failure message
     */
    void onUpdateFilterFailure(String message);
}
