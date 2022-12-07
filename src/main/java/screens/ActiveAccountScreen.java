package screens;

import interactors.AccountModel;
import interactors.ReviewModel;
import interactors.SingleListingModel;
import presenters.ActiveAccountPresenter;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ActiveAccountScreen extends JPanel {

    ActiveAccountPresenter activeAccountPresenter;
    JPanel info;
    JPanel group;

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

        // account info
        info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        this.add(info);

        // reviews and properties group
        group = new JPanel();
        group.setLayout(new BoxLayout(group, BoxLayout.X_AXIS));
        JScrollPane group_pane = new JScrollPane(group);
        this.add(group_pane);

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
            this.activeAccountPresenter.onDeleteAccount(password);
        });
    }

    public void setUpAccount(ArrayList<SingleListingModel> listings,
                             ArrayList<ReviewModel> reviews, AccountModel account) {
        // basic account info
        info.removeAll();
        JLabel name = new JLabel(account.getName());
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel contact = new JLabel(account.getContact());
        contact.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.add(name);
        info.add(contact);
        info.repaint();
        info.revalidate();

        // properties listed and reviews
        group.removeAll();
        JPanel user_properties = new JPanel();
        user_properties.setLayout(new BoxLayout(user_properties, BoxLayout.Y_AXIS));
        for (SingleListingModel m: listings) {
            String id = m.getID();
            JLabel address = new JLabel("Address: " + m.getAddress());
            JLabel price = new JLabel("Price: " + m.getPrice());
            JButton b = new JButton("See Property");
            b.addActionListener(e -> {
                this.activeAccountPresenter.onAccessProperty(id);
            });
            user_properties.add(address);
            user_properties.add(price);
            user_properties.add(b);
            user_properties.add(new JLabel(" "));
        }
        JPanel user_reviews = new JPanel();
        user_reviews.setLayout(new BoxLayout(user_reviews, BoxLayout.Y_AXIS));
        for (ReviewModel m: reviews) {
            JLabel writer = new JLabel("Writer: " + m.getWriterName());
            JLabel rating = new JLabel("Rating: " + m.getRating());
            JLabel content = new JLabel("Review: " + m.getContent());
            JLabel date = new JLabel("Date: " + m.getDate());
            user_reviews.add(writer);
            user_reviews.add(rating);
            user_reviews.add(content);
            user_reviews.add(date);
            user_reviews.add(new JLabel(" "));
        }
        JScrollPane listings_pane = new JScrollPane(user_properties);
        group.add(listings_pane);
        JScrollPane reviews_pane = new JScrollPane(user_reviews);
        group.add(reviews_pane);
        group.repaint();
        group.revalidate();
    }
}
