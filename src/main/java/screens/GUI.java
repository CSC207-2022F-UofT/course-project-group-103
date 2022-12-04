package screens;

import controllers.*;
import interactors.*;
import interactors.containers.*;
import managers.*;
import javax.swing.*;
import java.awt.*;
import java.awt.font.ShapeGraphicAttribute;
import java.util.ArrayList;

public class GUI extends JFrame implements Presenter {

    /**
     * TODO:
     * -property manager has issues with the getUser() method since it assumes all users have reviews,
     * -current implementation of Login Manager doesn't account for any realtors
     * -reviews should be implemented on the account page
     * -messaging should be implemented on the account page
     * -update the property page so the owner account is accessible to users
     */

    final String properties_path = "course-project-group-103/src/main/Databases/PropertyListing.json";
    final String users_path = "course-project-group-103/src/main/Databases/UserListing.json";
    final String reviews_path = "course-project-group-103/src/main/Databases/ReviewList.json";
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
    ArrayList<String> pageOrder = new ArrayList<>();

    public GUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(400, 300));

        //set up managers
        PropertyManager propertyManager = new PropertyManager(properties_path, users_path, reviews_path);
        LoginManager loginManager = new LoginManager(users_path, reviews_path);

        //set up containers
        ActiveUser activeUser = new ActiveUser();
        AccountToDisplay accountToDisplay = new AccountToDisplay();
        PropertyToDisplay propertyToDisplay = new PropertyToDisplay();
        ListingFilters listingFilters = new ListingFilters();

        // set up login screen
        LoginInteractor loginInteractor = new LoginInteractor(loginManager, activeUser);
        LoginScreenController loginScreenController = new LoginScreenController(loginInteractor, this);
        loginScreen = new LoginScreen(loginScreenController);

        // set up sign-up screen
        SignUpInteractor signUpInteractor = new SignUpInteractor(activeUser, loginManager);
        SignUpScreenController signUpScreenController = new SignUpScreenController(signUpInteractor, this);
        signUpScreen = new SignUpScreen(signUpScreenController);

        // set up home screen
        HomeInteractor homeInteractor = new HomeInteractor(accountToDisplay, activeUser);
        HomeScreenController homeScreenController = new HomeScreenController(this, homeInteractor);
        homeScreen = new HomeScreen(homeScreenController);

        // set up listing screen
        ListingInteractor listingInteractor = new ListingInteractor(propertyManager, propertyToDisplay, listingFilters);
        ListingController listingController = new ListingController(listingInteractor, this);
        listingScreen = new ListingScreen(listingController);

        // set up property screen
        PropertyInteractor propertyInteractor = new PropertyInteractor(propertyToDisplay, activeUser,
                accountToDisplay, propertyManager);
        PropertyScreenController propertyScreenController = new PropertyScreenController(propertyInteractor, this);
        propertyScreen = new PropertyScreen(propertyScreenController);

        // set up account screen
        AccountInteractor accountInteractor = new AccountInteractor(accountToDisplay, activeUser,
                propertyToDisplay, propertyManager);
        AccountController accountController = new AccountController(accountInteractor, this);
        accountScreen = new AccountScreen(accountController);

        // set up active account screen
        ActiveAccountInteractor activeAccountInteractor = new ActiveAccountInteractor(activeUser,
                propertyToDisplay, propertyManager);
        ActiveAccountController activeAccountController = new ActiveAccountController(activeAccountInteractor, this);
        activeAccountScreen = new ActiveAccountScreen(activeAccountController);

        // set up create listing screen
        CreateListingInteractor createListingInteractor = new CreateListingInteractor(activeUser,
                propertyManager, loginManager);
        CreateListingController createListingController = new CreateListingController(this, createListingInteractor);
        createListingScreen = new CreateListingScreen(createListingController);

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

}
