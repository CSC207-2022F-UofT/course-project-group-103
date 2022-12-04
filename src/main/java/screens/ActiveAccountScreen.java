package screens;

import controllers.ActiveAccountController;
import controllers.SingleListingController;

import javax.swing.*;
import java.awt.*;

public class ActiveAccountScreen extends JPanel {

    ActiveAccountController activeAccountController;

    public ActiveAccountScreen(ActiveAccountController c) {
        this.activeAccountController = c;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.draw();
    }

    public void draw() {
        // go back to home
        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> activeAccountController.back());

        // info group
        JPanel group = new JPanel();

        // account info
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        for (String s: this.activeAccountController.getInfo()) {
            info.add(new JLabel(s));
        }

        // if account is owner
        if (this.activeAccountController.isOwnerType()) {
            // properties listed by account
            JPanel properties = new JPanel();
            properties.add(new JLabel("Properties Listed: "));
            properties.setLayout(new BoxLayout(properties, BoxLayout.Y_AXIS));
            for (SingleListingController controller: this.activeAccountController.createUserProperties()) {
                properties.add(new SingleListing(controller));
            }
            JScrollPane prop_scroll = new JScrollPane(properties);

            // add account reviews here as well

            group.add(prop_scroll);
        }

        group.add(info);
        this.add(group);

        // sign out button
        JButton b = new JButton("Sign Out");
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(b);
        b.addActionListener(e -> {activeAccountController.signOut();});
    }

    public void redraw() {
        this.removeAll();
        this.draw();
        this.repaint();
        this.revalidate();
    }
}
