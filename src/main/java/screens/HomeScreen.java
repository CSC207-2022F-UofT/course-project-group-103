package screens;

import presenters.HomeScreenPresenter;
import javax.swing.*;
import java.awt.*;

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
        JButton realtor_listing_button = new JButton("View Realtor Listing");
        realtor_listing_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(listing_button);
        this.add(account_button);
        this.add(create_listing_button);
        this.add(realtor_listing_button);

        listing_button.addActionListener(e -> {
            homeScreenPresenter.onLoadListing();});
        account_button.addActionListener(e -> {
            homeScreenPresenter.onLoadAccount();});
        create_listing_button.addActionListener(e -> {
            homeScreenPresenter.onCreateListing();});
        realtor_listing_button.addActionListener(e -> {
            homeScreenPresenter.onRealtorListing();});
    }
}
