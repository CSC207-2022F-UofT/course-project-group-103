package screens;

import controllers.AccountController;
import controllers.SingleListingController;

import javax.swing.*;
import java.awt.*;

public class AccountScreen extends JPanel {

    AccountController accountController;

    public AccountScreen(AccountController c) {
        this.accountController = c;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.draw();
    }

    public void draw() {
        // go back to home
        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> accountController.back());

        // info group
        JPanel group = new JPanel();

        // account info
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        for (String s: this.accountController.getInfo()) {
            info.add(new JLabel(s));
        }

        // if account is owner
        if (this.accountController.isOwnerType()) {
            // properties listed by account
            JPanel properties = new JPanel();
            properties.add(new JLabel("Properties Listed: "));
            properties.setLayout(new BoxLayout(properties, BoxLayout.Y_AXIS));
            for (SingleListingController controller: this.accountController.createUserProperties()) {
                properties.add(new SingleListing(controller));
            }
            JScrollPane prop_scroll = new JScrollPane(properties);

            // add account reviews here as well

            group.add(prop_scroll);
        }

        group.add(info);
        this.add(group);
    }

    public void redraw() {
        this.removeAll();
        this.draw();
        this.repaint();
        this.revalidate();
    }
}
