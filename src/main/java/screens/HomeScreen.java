package screens;

import controllers.HomeScreenController;
import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JPanel {

    HomeScreenController homeScreenController;

    public HomeScreen(HomeScreenController c) {
        this.homeScreenController = c;
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
        this.add(listing_button);
        this.add(account_button);
        this.add(create_listing_button);

        listing_button.addActionListener(e -> {homeScreenController.listing();});
        account_button.addActionListener(e -> {homeScreenController.account();});
        create_listing_button.addActionListener(e -> {homeScreenController.createListing();});
    }
}
