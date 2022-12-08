package screens;

import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;
import presenters.HomeScreenPresenter;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class HomeScreen extends JPanel {

    HomeScreenPresenter homeScreenPresenter;

    public HomeScreen(HomeScreenPresenter presenter) {
        this.homeScreenPresenter = presenter;
        // setup
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // title
        JLabel title = new JLabel("Home Page");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        // buttons
        JButton listing_button = new JButton("View Listing");
        listing_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton account_button = new JButton("View Account");
        account_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton create_listing_button = new JButton("Create Listing");
        create_listing_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton messenger_button = new JButton("Messenger");
        messenger_button.setAlignmentX(CENTER_ALIGNMENT);
        this.add(listing_button);
        this.add(account_button);
        this.add(create_listing_button);
        this.add(messenger_button);

        listing_button.addActionListener(e -> {
            homeScreenPresenter.onLoadListing();});
        account_button.addActionListener(e -> {
            homeScreenPresenter.onLoadAccount();});
        create_listing_button.addActionListener(e -> {
            homeScreenPresenter.onCreateListing();});
        messenger_button.addActionListener(e -> {
            try {
                homeScreenPresenter.onOpenMessenger();
            } catch (MessengerNotFound | UndefinedUserType | IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
