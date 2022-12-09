import interactors.*;
import presenters.ViewInterface;
import java.util.ArrayList;

public class presenter_dependancy implements ViewInterface {

    public void displayLogin() {}
    public void displayFailure(String message) {}
    public void displaySuccess(String message) {}
    public void displayHome() {}
    public void displaySignUp() {}
    public void displayListing() {}
    public void refreshListing(ArrayList<SingleListingModel> info) {}
    public void displayProperty(PropertyModel property) {}
    public void displayRealtorListing(ArrayList<SingleRealtorModel> realtors) {}
    public void displayPrevious() {}
    public void displayCreateListing() {}
    public void displayActiveAccount(ArrayList<SingleListingModel> listing,
                                     ArrayList<ReviewModel> reviews, AccountModel account) {}
    public void displayAccount(ArrayList<SingleListingModel> listing,
                               ArrayList<ReviewModel> reviews, AccountModel account) {}
    public void displayCreateReview(String id) {}
    public void displayMortgageEstimator(float price) {}
    public void setActiveUser(String id) {}
    public String getActiveUser() {return null;}
}
