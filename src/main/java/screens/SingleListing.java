package screens;

import presenters.SingleListingPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleListing extends JPanel implements ActionListener {
    SingleListingPresenter singleListingPresenter;

    public SingleListing(SingleListingPresenter presenter) {
        this.singleListingPresenter = presenter;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // info
        for (String s: this.singleListingPresenter.onListingInfo()) {
            this.add(new JLabel(s));
        }

        // button
        JButton b = new JButton("Go to Property");
        b.addActionListener(this);
        this.add(b);
        this.add(new JLabel(" "));
    }

    // Button pressed
    public void actionPerformed(ActionEvent evt) {
        this.singleListingPresenter.onShowProperty();
    }
}
