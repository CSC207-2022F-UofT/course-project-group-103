package interactors.output_boundary;

import interactors.SingleListingModel;

import java.util.ArrayList;

public interface RefreshListingOutput {
    void onUpdateFilterSuccess(ArrayList<SingleListingModel> info);
    void onUpdateFilterFailure(String message);
}
