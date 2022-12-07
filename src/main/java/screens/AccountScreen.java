package screens;

import presenters.AccountScreenPresenter;
import presenters.SingleListingPresenter;
import presenters.SingleReviewPresenter;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class AccountScreen extends JPanel {

    AccountScreenPresenter accountScreenPresenter;

    public AccountScreen(AccountScreenPresenter presenter) {
        this.accountScreenPresenter = presenter;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.draw();
    }

    public void draw() {
        // go back to home
        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> accountScreenPresenter.onBack());

        // info group
        JPanel group = new JPanel();
        group.setLayout(new BoxLayout(group, BoxLayout.X_AXIS));

        // account info
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        for (String s: this.accountScreenPresenter.onGetInfo()) {
            info.add(new JLabel(s));
        }
        this.add(info);

        // if account is owner
        if (this.accountScreenPresenter.onOwnerType()) {
            // properties listed by account
            JPanel properties = new JPanel();
            properties.add(new JLabel("Properties Listed: "));
            properties.add(new JLabel(" "));
            properties.setLayout(new BoxLayout(properties, BoxLayout.Y_AXIS));
            for (SingleListingPresenter controller: this.accountScreenPresenter.onCreateUserProperties()) {
                properties.add(new SingleListing(controller));
            }
            JScrollPane prop_scroll = new JScrollPane(properties);

            // reviews of account
            JPanel reviews = new JPanel();
            reviews.add(new JLabel("Reviews: "));
            reviews.add(new JLabel(" "));
            reviews.setLayout(new BoxLayout(reviews, BoxLayout.Y_AXIS));
            for (SingleReviewPresenter controller: this.accountScreenPresenter.onCreateUserReviews()) {
                reviews.add(new SingleReview(controller));
            }
            JScrollPane review_scroll = new JScrollPane(reviews);

            group.add(prop_scroll);
            group.add(review_scroll);
        }
        JScrollPane group_scroll = new JScrollPane(group);
        group_scroll.setBorder(createEmptyBorder());
        this.add(group_scroll);

        // if owner type to add review button at bottom
        if (this.accountScreenPresenter.onOwnerType()) {
            // add review button
            JButton create_review = new JButton("Add Review");
            create_review.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(create_review);
            create_review.addActionListener(e -> accountScreenPresenter.onCreateReview());
        }
    }

    public void redraw() {
        this.removeAll();
        this.draw();
        this.repaint();
        this.revalidate();
    }
}
