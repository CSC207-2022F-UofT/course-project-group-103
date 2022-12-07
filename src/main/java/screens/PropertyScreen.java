package screens;

import presenters.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropertyScreen extends JPanel implements ActionListener {
    PropertyScreenPresenter propertyScreenPresenter;
    JTextField bid;

    public PropertyScreen(PropertyScreenPresenter presenter) {
        // setup
        this.propertyScreenPresenter = presenter;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.draw();
    }

    public void draw() {

        bid = new JTextField(15);

        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> propertyScreenPresenter.onBack());

        // title
        JLabel title = new JLabel("Property:");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        // property info
        for (String s: this.propertyScreenPresenter.onInfoList()) {
            JLabel l = new JLabel(s);
            l.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(l);
        }

        // check if active user is the owner of listing
        if (this.propertyScreenPresenter.onCheckOwner()) {
            // delete property
            JButton delete = new JButton("Delete Property");
            delete.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(delete);
            delete.addActionListener(e -> {
                String password = JOptionPane.showInputDialog(this, "Enter Password: ");
                try {
                    this.propertyScreenPresenter.onDeleteProperty(password);
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(this, exc.getMessage());
                }
            });
            // bids on the property
            JPanel bids_panel = new JPanel();
            JLabel tag = new JLabel("Bids: ");
            tag.setAlignmentX(Component.CENTER_ALIGNMENT);
            bids_panel.add(tag);
            bids_panel.setLayout(new BoxLayout(bids_panel, BoxLayout.Y_AXIS));
            for (SingleBidPresenter p: this.propertyScreenPresenter.onCreateBids()) {
                SingleBid bid = new SingleBid(p);
                bid.setAlignmentX(Component.CENTER_ALIGNMENT);
                bids_panel.add(bid);
            }
            JScrollPane bids = new JScrollPane(bids_panel);
            this.add(bids);
        } else {
            JButton owner = new JButton("Owner Account");
            owner.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(owner);
            owner.addActionListener(e -> {
                this.propertyScreenPresenter.onOwnerAccount();
            });
            // send offer field
            JLabel bidInfo = new JLabel("Set Offer Amount: ");
            JButton sendOffer = new JButton("Send Offer");
            sendOffer.addActionListener(this);
            bidInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
            bidInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
            sendOffer.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(bidInfo);
            this.add(bid);
            this.add(sendOffer);
        }
    }

    public void redraw() {
        this.removeAll();
        this.draw();
        this.repaint();
        this.revalidate();
    }

    // Button pressed
    public void actionPerformed(ActionEvent evt) {
        // Try sending bid, if no exception is thrown displays "Bid Sent" otherwise displays exception message
        try {
            this.propertyScreenPresenter.onSendBid(bid.getText());
            JOptionPane.showMessageDialog(this, "Bid Sent.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
