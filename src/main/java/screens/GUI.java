package screens;

import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;
import interactors.gateway_interfaces.MessengerGateway;
import presenters.*;
import interactors.*;
import managers.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class GUI extends JFrame implements ViewInterface {

    /**
     * TODO:
     * -current implementation of Login Manager doesn't account for any realtors
     * -messaging should be implemented on the account page
     * -weird bug on delete account with bids
     */

    final String properties_path = "src/main/Databases/PropertyListing.json";
    final String users_path = "src/main/Databases/UserListing.json";
    final String reviews_path = "src/main/Databases/ReviewList.json";
    final String inappropriate_words_path = "src/main/Databases/InappropriateWordsList.json";
    final String messengers_path = "src/main/Databases/MessengerDatabase.json";


    JPanel screens;
    CardLayout screen;
    LoginScreen loginScreen;
    SignUpScreen signUpScreen;
    HomeScreen homeScreen;
    ListingScreen listingScreen;
    PropertyScreen propertyScreen;
    CreateListingScreen createListingScreen;
    ActiveAccountScreen activeAccountScreen;
    AccountScreen accountScreen;
    CreateReviewScreen createReviewScreen;
    ChangePasswordScreen changePasswordScreen;
    MessengerChatScreen messengerChatScreen;
    RealtorListingScreen realtorListingScreen;
    EstimateMortgageScreen mortgageEstimatorScreen;


    ArrayList<String> pageOrder = new ArrayList<>();
    String activeUser;

    public GUI() throws IOException, MessengerNotFound, UndefinedUserType {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(400, 400));

        //set up managers
        LoginManager loginManager = new LoginManager(users_path, reviews_path);
        PropertyManager propertyManager = new PropertyManager(properties_path, users_path, reviews_path, loginManager);
        ReviewManager reviewManager = new ReviewManager(reviews_path, inappropriate_words_path);
        MessageManager messageManager = new MessageManager(messengers_path);


        // set up sign-up screen
        SignUpScreenPresenter signUpScreenPresenter = new SignUpScreenPresenter(this, loginManager);
        signUpScreen = new SignUpScreen(signUpScreenPresenter);

        // set up home screen
        HomeScreenPresenter homeScreenPresenter = new HomeScreenPresenter(this, propertyManager, reviewManager, loginManager);
        homeScreen = new HomeScreen(homeScreenPresenter);

        // set up listing screen
        ListingScreenPresenter listingScreenPresenter = new ListingScreenPresenter(this,
                propertyManager, loginManager);
        listingScreen = new ListingScreen(listingScreenPresenter);

        // set up property screen
        PropertyScreenPresenter propertyScreenPresenter = new PropertyScreenPresenter(this,
                propertyManager, loginManager, reviewManager);
        propertyScreen = new PropertyScreen(propertyScreenPresenter);

        // set up create listing screen
        CreateListingPresenter createListingPresenter = new CreateListingPresenter(this,
                propertyManager, loginManager);
        createListingScreen = new CreateListingScreen(createListingPresenter);

        // set up active account screen
        ActiveAccountPresenter activeAccountPresenter = new ActiveAccountPresenter(this,
                propertyManager, loginManager, reviewManager);
        activeAccountScreen = new ActiveAccountScreen(activeAccountPresenter);

        // set up account screen
        AccountPresenter accountPresenter = new AccountPresenter(this, propertyManager, loginManager);
        accountScreen = new AccountScreen(accountPresenter);

        // set up change password screen
        ChangePasswordScreenPresenter changePasswordScreenPresenter =
                new ChangePasswordScreenPresenter(this, loginManager);
        changePasswordScreen = new ChangePasswordScreen(changePasswordScreenPresenter);

        // set up login screen
        LoginScreenPresenter loginScreenPresenter = new LoginScreenPresenter(this, loginManager);
        loginScreen = new LoginScreen(loginScreenPresenter, activeAccountPresenter, changePasswordScreenPresenter);

        // set up create review screen
        CreateReviewPresenter createReviewPresenter = new CreateReviewPresenter(this, reviewManager);
        createReviewScreen = new CreateReviewScreen(createReviewPresenter);


        // set up mortgage estimator screen
        EstimateMortgagePresenter estimateMortgagePresenter = new EstimateMortgagePresenter(this);
        mortgageEstimatorScreen = new EstimateMortgageScreen(estimateMortgagePresenter);

        // set up chat screen
        MessengerPresenter messengerPresenter = new MessengerPresenter(this, messageManager, loginManager);
        SendMessagePresenter sendMessagePresenter = new SendMessagePresenter(this, messageManager, loginManager);
        messengerChatScreen = new MessengerChatScreen(messengerPresenter, sendMessagePresenter);


        // set up realtor listing screen
        RealtorListingPresenter realtorListingPresenter = new RealtorListingPresenter(this, loginManager);
        realtorListingScreen = new RealtorListingScreen(realtorListingPresenter);


        // set up card layout
        screen = new CardLayout();
        screens = new JPanel(screen);
        screens.setBorder(BorderFactory.createEmptyBorder());
        this.add(screens);

        // add all screens to card layout
        screens.add(loginScreen, "Login");
        screens.add(signUpScreen, "Sign Up");
        screens.add(homeScreen, "Home");
        screens.add(listingScreen, "Listing");
        screens.add(propertyScreen, "Property");
        screens.add(createListingScreen, "Create Listing");
        screens.add(activeAccountScreen, "Active Account");
        screens.add(accountScreen, "Account");
        screens.add(changePasswordScreen, "Change Password");
        screens.add(createReviewScreen, "Create Review");
        screens.add(messengerChatScreen, "Messenger");
        screens.add(realtorListingScreen, "Realtor Listing");
        screens.add(mortgageEstimatorScreen, "Estimate Mortgage");
    }

    public void displayLogin() {
        // clears the page order otherwise can run into problems
        pageOrder.clear();
        loginScreen.redraw();
        screen.show(screens, "Login");
    }

    public void displayFailure(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void displaySuccess(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void displayHome() {
        pageOrder.clear();
        screen.show(screens, "Home");
    }

    public void displaySignUp() {
        signUpScreen.redraw();
        screen.show(screens, "Sign Up");
    }

    public void displayListing() {
        listingScreen.redraw();
        screen.show(screens, "Listing");
        pageOrder.add("Listing");
    }

    public void refreshListing(ArrayList<SingleListingModel> info) {
        listingScreen.setUpListings(info);
    }

    public void displayProperty(PropertyModel property) {
        propertyScreen.setUpInfo(property, this.activeUser);
        screen.show(screens, "Property");
        pageOrder.add("Property");
    }

    public void displayRealtorListing(ArrayList<SingleRealtorModel> realtors) {
        realtorListingScreen.draw(realtors);
        screen.show(screens, "Realtor Listing");
        pageOrder.add("Realtor Listing");
    }



    public void displayPrevious() {
        if (pageOrder.size()<2) {
            screen.show(screens, "Home");
            pageOrder.clear();
        }
        else {
            pageOrder.remove(pageOrder.size()-1);
            screen.show(screens,pageOrder.get(pageOrder.size()-1));
        }
    }

    public void displayCreateListing() {
        createListingScreen.redraw();
        screen.show(screens, "Create Listing");
        pageOrder.add("Create Listing");
    }

    public void displayActiveAccount(ArrayList<SingleListingModel> listing,
                                     ArrayList<ReviewModel> reviews, AccountModel account) {
        activeAccountScreen.setUpAccount(listing, reviews, account);
        screen.show(screens, "Active Account");
        pageOrder.add("Active Account");
    }

    public void displayAccount(ArrayList<SingleListingModel> listing,
                                     ArrayList<ReviewModel> reviews, AccountModel account) {
        accountScreen.setUpAccount(listing, reviews, account);
        screen.show(screens, "Account");
        pageOrder.add("Account");
    }

    public void displayCreateReview(String id) {
        createReviewScreen.draw(id);
        screen.show(screens, "Create Review");
        pageOrder.add("Create Review");
    }

    public void displayMortgageEstimator(float price) {
        mortgageEstimatorScreen.draw(price);
        screen.show(screens, "Estimate Mortgage");
        pageOrder.add("Estimate Mortgage");
    }

    public void setActiveUser(String id) {
        this.activeUser = id;
    }

    public String getActiveUser() {
        return this.activeUser;
    }

    public void displayChangePassword(String securityQuestion) {
        changePasswordScreen.redraw(securityQuestion, true);
        screen.show(screens, "Change Password");
        pageOrder.add("Change Password");
    }
    public void displayChangePasswordInactive(String securityQuestion) {
        changePasswordScreen.redraw(securityQuestion, false);
        screen.show(screens, "Change Password");
        pageOrder.add("Change Password");
    }

    public void displayChat(String user2ID) throws MessengerNotFound, UndefinedUserType, IOException {
        messengerChatScreen.draw(user2ID);
        screen.show(screens, "Messenger");
        pageOrder.add("Messenger");
    }
}
