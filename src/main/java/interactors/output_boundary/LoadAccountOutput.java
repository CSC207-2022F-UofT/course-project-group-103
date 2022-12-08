package interactors.output_boundary;

import interactors.AccountModel;
import interactors.ReviewModel;
import interactors.SingleListingModel;
import java.util.ArrayList;

public interface LoadAccountOutput {
    void onLoadAccountSuccess(ArrayList<SingleListingModel> listings, ArrayList<ReviewModel> reviews,
                              AccountModel account);
    void onLoadAccountFailure(String message);
}
