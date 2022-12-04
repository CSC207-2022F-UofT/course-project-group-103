package Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropertyPageScreen extends JPanel implements ActionListener{
    /**
     * PropertyPageInteractor and PropertyPageController objects must be created
     * before PropertyPageScreen object can be created.
     */
    PropertyPageController propertyPageController;

    /**
     * The bid chosen by the user
     */
    JTextField bid = new JTextField(15);

    public PropertyPageScreen(PropertyPageController controller) {
        // setup
        this.propertyPageController = controller;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // title
        JLabel title = new JLabel("Property Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        // property info
        for (String s: this.propertyPageController.getInfoList()) {
            JLabel l = new JLabel(s);
            l.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(l);
        }

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

    // Button pressed
    public void actionPerformed(ActionEvent evt) {
        // Try sending bid, if no exception is thrown displays "Bid Sent" otherwise displays exception message
        try {
            this.propertyPageController.sendBid(bid.getText());
            JOptionPane.showMessageDialog(this, "Bid Sent.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
