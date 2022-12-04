package screens;

import controllers.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropertyScreen extends JPanel implements ActionListener {
    PropertyScreenController propertyScreenController;
    JTextField bid = new JTextField(15);

    public PropertyScreen(PropertyScreenController controller) {
        // setup
        this.propertyScreenController = controller;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.draw();
    }

    public void draw() {

        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> propertyScreenController.back());

        // title
        JLabel title = new JLabel("Property:");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        // property info
        for (String s: this.propertyScreenController.getInfoList()) {
            JLabel l = new JLabel(s);
            l.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(l);
        }

        // check if active user is the owner of listing
        if (this.propertyScreenController.checkOwner()) {
            // if active user is owner
            JPanel bids_panel = new JPanel();
            JLabel tag = new JLabel("Bids: ");
            tag.setAlignmentX(Component.CENTER_ALIGNMENT);
            bids_panel.add(tag);
            bids_panel.setLayout(new BoxLayout(bids_panel, BoxLayout.Y_AXIS));
            for (SingleBidController c: this.propertyScreenController.createBids()) {
                SingleBid bid = new SingleBid(c);
                bid.setAlignmentX(Component.CENTER_ALIGNMENT);
                bids_panel.add(bid);
            }
            JScrollPane bids = new JScrollPane(bids_panel);
            this.add(bids);
        } else {
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
            this.propertyScreenController.sendBid(bid.getText());
            JOptionPane.showMessageDialog(this, "Bid Sent.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
