package screens;

import presenters.CreateReviewPresenter;

import javax.swing.*;
import java.awt.*;

public class CreateReviewScreen extends JPanel {

    CreateReviewPresenter createReviewPresenter;
    JTextField review;
    JComboBox<String> rating;


    public CreateReviewScreen(CreateReviewPresenter controller) {
        this.createReviewPresenter = controller;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

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
