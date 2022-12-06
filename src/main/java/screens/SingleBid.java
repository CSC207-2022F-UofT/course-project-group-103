package screens;

import presenters.SingleBidPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleBid extends JPanel implements ActionListener {

    SingleBidPresenter singleBidPresenter;

    public SingleBid(SingleBidPresenter presenter) {
        this.singleBidPresenter = presenter;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // info
        for (String s: this.singleBidPresenter.onBidInfo()) {
            this.add(new JLabel(s));
        }

        // button
        JButton b = new JButton("Go to Account");
        b.addActionListener(this);
        this.add(b);
        this.add(new JLabel(" "));
    }

    public void actionPerformed(ActionEvent evt) {
        this.singleBidPresenter.onAccount();
    }
}
