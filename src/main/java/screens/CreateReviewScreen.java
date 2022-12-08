package screens;

import presenters.CreateReviewPresenter;

import javax.swing.*;
import java.awt.*;

public class CreateReviewScreen extends JPanel {

    CreateReviewPresenter createReviewPresenter;

    //Text field where the user can write their review
    JTextField review;

    //Allows user input their rating on someone out of 5
    JComboBox<String> rating;

    /**
     * Constructor that sets up the layout
     *
     * @param controller: Presenter that tells his UI how to update
     */
    public CreateReviewScreen(CreateReviewPresenter controller) {
        this.createReviewPresenter = controller;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * Adds components to the background panel and creates a review for the user corresponding to ownerID.
     * @param ownerID: ID of the owner that is being reviewed
     */
    public void draw(String ownerID) {
        this.removeAll();
        // back button
        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> createReviewPresenter.onBack());

        // entering review and rating inputs
        review = new JTextField(15);
        String[] ratings = {"Select rating", "1", "2", "3", "4", "5"};
        rating = new JComboBox<>(ratings);

        JLabel review_tag = new JLabel("Enter Review: ");
        JLabel rating_tag = new JLabel("Enter Rating: ");
        JButton submit = new JButton("Submit Review");
        review.setAlignmentX(Component.CENTER_ALIGNMENT);
        rating.setAlignmentX(Component.CENTER_ALIGNMENT);
        review_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        rating_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(review_tag);
        this.add(review);
        this.add(rating_tag);
        this.add(rating);
        this.add(submit);
        submit.addActionListener(e ->
            this.createReviewPresenter.onCreateReview(review.getText(),(String) rating.getSelectedItem(), ownerID)
        );
        this.repaint();
        this.revalidate();
    }
}
