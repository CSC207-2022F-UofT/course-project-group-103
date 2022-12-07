package screens;

import presenters.CreateReviewPresenter;

import javax.swing.*;
import java.awt.*;

public class CreateReviewScreen extends JPanel {

    CreateReviewPresenter createReviewPresenter;
    JTextField review;
    JTextField rating;

    public CreateReviewScreen(CreateReviewPresenter controller) {
        this.createReviewPresenter = controller;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.draw();
    }

    public void draw() {
        // back button
        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> createReviewPresenter.onBack());

        review = new JTextField(15);
        rating = new JTextField(15);
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
        submit.addActionListener(e -> {
            try {
                this.createReviewPresenter.onCreateReview(review.getText(), rating.getText());
            } catch (Exception exc) {JOptionPane.showMessageDialog(this, exc.getMessage());}
        });
    }

    public void redraw() {
        this.removeAll();
        this.draw();
        this.repaint();
        this.revalidate();
    }
}
