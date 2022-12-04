package screens;

import controllers.SingleListingController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleListing extends JPanel implements ActionListener {
    SingleListingController singleListingController;

    public SingleListing(SingleListingController c) {
        this.singleListingController = c;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // info
        for (String s: this.singleListingController.getListingInfo()) {
            this.add(new JLabel(s));
        }

        // button
        JButton b = new JButton("Go to Property");
        b.addActionListener(this);
        this.add(b);

    }

    // Button pressed
    public void actionPerformed(ActionEvent evt) {
        this.singleListingController.showProperty();
    }
}
