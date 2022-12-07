package interactors.output_boundary;

import interactors.SingleListingModel;

import java.util.ArrayList;

public interface LoadListingOutput {
    void onLoadListingSuccess(ArrayList<SingleListingModel> info);
    void onLoadListingFailure(String message);
}
