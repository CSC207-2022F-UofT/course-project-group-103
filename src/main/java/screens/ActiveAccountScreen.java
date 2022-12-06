package screens;

import presenters.ActiveAccountPresenter;
import presenters.SingleListingPresenter;
import presenters.SingleReviewPresenter;

import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.createEmptyBorder;

public class ActiveAccountScreen extends JPanel {

    ActiveAccountPresenter activeAccountPresenter;

    public ActiveAccountScreen(ActiveAccountPresenter presenter) {
        this.activeAccountPresenter = presenter;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.draw();
    }

    public void draw() {
        // go back to home
        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> activeAccountPresenter.onBack());

        // info group
        JPanel group = new JPanel();
        group.setLayout(new BoxLayout(group, BoxLayout.X_AXIS));

        // account info
        JPanel info = new JPanel();
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        for (String s: this.activeAccountPresenter.onGetInfo()) {
            info.add(new JLabel(s));
        }
        this.add(info);

        // if account is owner
        if (this.activeAccountPresenter.onOwnerType()) {
            // properties listed by account
            JPanel properties = new JPanel();
            properties.add(new JLabel("Properties Listed: "));
            properties.add(new JLabel(" "));
            properties.setLayout(new BoxLayout(properties, BoxLayout.Y_AXIS));
            for (SingleListingPresenter controller: this.activeAccountPresenter.onCreateUserProperties()) {
                properties.add(new SingleListing(controller));
            }
            JScrollPane prop_scroll = new JScrollPane(properties);

            // reviews of account
            JPanel reviews = new JPanel();
            reviews.add(new JLabel("Reviews: "));
            reviews.add(new JLabel(" "));
            reviews.setLayout(new BoxLayout(reviews, BoxLayout.Y_AXIS));
            for (SingleReviewPresenter controller: this.activeAccountPresenter.onCreateUserReviews()) {
                reviews.add(new SingleReview(controller));
            }
            JScrollPane review_scroll = new JScrollPane(reviews);

            group.add(prop_scroll);
            group.add(review_scroll);
        }
        JScrollPane group_scroll = new JScrollPane(group);
        group_scroll.setBorder(createEmptyBorder());
        this.add(group_scroll);

        // sign out button
        JButton b = new JButton("Sign Out");
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(b);
        b.addActionListener(e -> {
            activeAccountPresenter.onSignOut();});

        // delete account button
        JButton delete = new JButton("Delete Account");
        delete.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(delete);
        delete.addActionListener(e -> {
            String password = JOptionPane.showInputDialog(this, "Enter Password: ");
            try {
                this.activeAccountPresenter.onDeleteAccount(password);
            } catch(Exception exc) {
                JOptionPane.showMessageDialog(this, exc.getMessage());
            }
        });
    }

    public void redraw() {
        this.removeAll();
        this.draw();
        this.repaint();
        this.revalidate();
    }
}
