package screens;

import presenters.*;
import interactors.*;
import interactors.containers.*;
import managers.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame implements ViewInterface {

    /**
     * TODO:
     * -current implementation of Login Manager doesn't account for any realtors
     * -messaging should be implemented on the account page
     */

    final String properties_path = "src/main/Databases/PropertyListing.json";
    final String users_path = "src/main/Databases/UserListing.json";
    final String reviews_path = "src/main/Databases/ReviewList.json";
    JPanel screens;
    CardLayout screen;
    LoginScreen loginScreen;
    SignUpScreen signUpScreen;
    HomeScreen homeScreen;
    ListingScreen listingScreen;
    PropertyScreen propertyScreen;
    AccountScreen accountScreen;
    ActiveAccountScreen activeAccountScreen;
    CreateListingScreen createListingScreen;
    CreateReviewScreen createReviewScreen;
    RealtorListingScreen realtorListingScreen;
    ArrayList<String> pageOrder = new ArrayList<>();

    public GUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(400, 400));

        //set up managers
        PropertyManager propertyManager = new PropertyManager(properties_path, users_path, reviews_path);
        LoginManager loginManager = new LoginManager(users_path, reviews_path);
        ReviewManager reviewManager = new ReviewManager(reviews_path);

        //set up containers
        ActiveUser activeUser = new ActiveUser();
        AccountToDisplay accountToDisplay = new AccountToDisplay();
        PropertyToDisplay propertyToDisplay = new PropertyToDisplay();
        ListingFilters listingFilters = new ListingFilters();

        // set up login screen
        LoginInteractor loginInteractor = new LoginInteractor(loginManager, activeUser);
        LoginScreenPresenter loginScreenPresenter = new LoginScreenPresenter(loginInteractor, this);
        loginScreen = new LoginScreen(loginScreenPresenter);

        // set up sign-up screen
        SignUpInteractor signUpInteractor = new SignUpInteractor(activeUser, loginManager);
        SignUpScreenPresenter signUpScreenPresenter = new SignUpScreenPresenter(signUpInteractor, this);
        signUpScreen = new SignUpScreen(signUpScreenPresenter);

        // set up home screen
        HomeScreenPresenter homeScreenPresenter = new HomeScreenPresenter(this);
        homeScreen = new HomeScreen(homeScreenPresenter);

        // set up listing screen
        ListingInteractor listingInteractor = new ListingInteractor(propertyManager, propertyToDisplay, listingFilters);
        ListingScreenPresenter listingScreenPresenter = new ListingScreenPresenter(listingInteractor, this);
        listingScreen = new ListingScreen(listingScreenPresenter);

        // set up property screen
        PropertyInteractor propertyInteractor = new PropertyInteractor(propertyToDisplay, activeUser,
                accountToDisplay, propertyManager);
        PropertyScreenPresenter propertyScreenPresenter = new PropertyScreenPresenter(propertyInteractor, this);
        propertyScreen = new PropertyScreen(propertyScreenPresenter);

        // set up account screen
        AccountInteractor accountInteractor = new AccountInteractor(accountToDisplay, activeUser,
                propertyToDisplay, propertyManager, reviewManager);
        AccountScreenPresenter accountScreenPresenter = new AccountScreenPresenter(accountInteractor, this);
        accountScreen = new AccountScreen(accountScreenPresenter);

        // set up active account screen
        ActiveAccountInteractor activeAccountInteractor = new ActiveAccountInteractor(activeUser,
                propertyToDisplay, propertyManager, loginManager, reviewManager);
        ActiveAccountPresenter activeAccountPresenter = new ActiveAccountPresenter(activeAccountInteractor, this);
        activeAccountScreen = new ActiveAccountScreen(activeAccountPresenter);

        // set up create listing screen
        CreateListingInteractor createListingInteractor = new CreateListingInteractor(activeUser,
                propertyManager, loginManager);
        CreateListingPresenter createListingPresenter = new CreateListingPresenter(this, createListingInteractor);
        createListingScreen = new CreateListingScreen(createListingPresenter);

        // set up create review screen
        CreateReviewInteractor createReviewInteractor = new CreateReviewInteractor(reviewManager,
                activeUser, accountToDisplay);
        CreateReviewPresenter createReviewPresenter = new CreateReviewPresenter(createReviewInteractor, this);
        createReviewScreen = new CreateReviewScreen(createReviewPresenter);

        RealtorSearchInteractor realtorSearchInteractor = new RealtorSearchInteractor();
        RealtorListingPresenter realtorListingPresenter = new RealtorListingPresenter(realtorSearchInteractor, this);
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
        screens.add(accountScreen,"Account");
        screens.add(activeAccountScreen, "Active Account");
        screens.add(createListingScreen, "Create Listing");
        screens.add(createReviewScreen, "Create Review");
        screens.add(realtorListingScreen, "Realtor Listing");
    }

    public void displayHome() {
        screen.show(screens, "Home");
    }
    public void displayLogin() {
        // clears the page order otherwise can run into problems
        pageOrder.clear();
        loginScreen.redraw();
        screen.show(screens, "Login");
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
    public void displayProperty() {
        propertyScreen.redraw();
        screen.show(screens, "Property");
        pageOrder.add("Property");
    }

    public void displayAccount() {
        accountScreen.redraw();
        screen.show(screens, "Account");
        pageOrder.add("Account");
    }

    public void displayActiveAccount() {
        activeAccountScreen.redraw();
        screen.show(screens, "Active Account");
        pageOrder.add("Active Account");
    }

    public void displayCreateListing() {
        createListingScreen.redraw();
        screen.show(screens, "Create Listing");
        pageOrder.add("Create Listing");
    }

    public void displayCreateReview() {
        createReviewScreen.redraw();
        screen.show(screens, "Create Review");
        pageOrder.add("Create Review");
    }

    public void displayRealtorListing() {
        createReviewScreen.redraw();
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

    public void clearPrevious() {
        pageOrder.clear();
    }

    public void refreshAccount() {accountScreen.redraw();}

}
