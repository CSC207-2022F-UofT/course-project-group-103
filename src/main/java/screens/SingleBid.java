package screens;

import controllers.SingleBidController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleBid extends JPanel implements ActionListener {

    SingleBidController singleBidController;

    public SingleBid(SingleBidController c) {
        this.singleBidController = c;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // info
        for (String s: this.singleBidController.getBidInfo()) {
            this.add(new JLabel(s));
        }

        // button
        JButton b = new JButton("Go to Account");
        b.addActionListener(this);
        this.add(b);

    }

    public void actionPerformed(ActionEvent evt) {
        this.singleBidController.account();
    }
}
