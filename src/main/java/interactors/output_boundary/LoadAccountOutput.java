package interactors.output_boundary;

import interactors.AccountModel;
import interactors.ReviewModel;
import interactors.SingleListingModel;
import java.util.ArrayList;

public interface LoadAccountOutput {

    /**
     * Called with the account info when an account was successfully accessed.
     *
     * @param listings: Array list of single listings models for the account's listed properties
     * @param reviews: Array list of review models for reviews on the account
     * @param account: Account model containing basic information about the account
     */
    void onLoadAccountSuccess(ArrayList<SingleListingModel> listings, ArrayList<ReviewModel> reviews,
                              AccountModel account);
    /**
     * Called when an attempt to access an account was failed.
     *
     * @param message: failure message
     */
    void onLoadAccountFailure(String message);
}
