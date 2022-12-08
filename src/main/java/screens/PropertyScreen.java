package screens;

import interactors.BidModel;
import interactors.PropertyModel;
import presenters.*;
import javax.swing.*;
import java.awt.*;

public class PropertyScreen extends JPanel {
    PropertyScreenPresenter propertyScreenPresenter;
    JTextField bid;
    JPanel info_panel;

    public PropertyScreen(PropertyScreenPresenter presenter) {
        // setup
        this.propertyScreenPresenter = presenter;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.draw();
    }

    public void draw() {

        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> propertyScreenPresenter.onBack());

        // title
        JLabel title = new JLabel("Property:");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        // property info
        info_panel = new JPanel();
        info_panel.setLayout(new BoxLayout(info_panel, BoxLayout.Y_AXIS));
        info_panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(info_panel);
    }

    public void setUpInfo(PropertyModel property, String userID) {
        info_panel.removeAll();
        String propertyID = property.getPropertyID();
        String ownerID = property.getOwnerID();
        float propertyPrice = property.getPrice();
        boolean isOwner = property.getOwnerID().equals(userID);
        JLabel type = new JLabel("Type: " + property.getType());
        type.setAlignmentX(Component.CENTER_ALIGNMENT);
        info_panel.add(type);
        JLabel address = new JLabel("Address: " + property.getAddress());
        address.setAlignmentX(Component.CENTER_ALIGNMENT);
        info_panel.add(address);
        JLabel owner = new JLabel("Owner: " + property.getOwner());
        owner.setAlignmentX(Component.CENTER_ALIGNMENT);
        info_panel.add(owner);
        JLabel sqft = new JLabel("SqFt: " + property.getSqFt());
        sqft.setAlignmentX(Component.CENTER_ALIGNMENT);
        info_panel.add(sqft);
        JLabel price = new JLabel("Price: " + property.getPrice());
        price.setAlignmentX(Component.CENTER_ALIGNMENT);
        info_panel.add(price);
        if (property.getType().equals("House") || property.getType().equals("Condo")) {
            JLabel numBed = new JLabel("Number of Bedrooms: " + property.getNumBed());
            numBed.setAlignmentX(Component.CENTER_ALIGNMENT);
            info_panel.add(numBed);
            JLabel numBath = new JLabel("Number of Bathrooms: " + property.getNumBath());
            numBath.setAlignmentX(Component.CENTER_ALIGNMENT);
            info_panel.add(numBath);
            JLabel numLaundry = new JLabel("Number of Laundry Rooms: " + property.getNumLaundry());
            numLaundry.setAlignmentX(Component.CENTER_ALIGNMENT);
            info_panel.add(numLaundry);
            JLabel numKitchen = new JLabel("Number of Kitchens: " + property.getNumKitchens());
            numKitchen.setAlignmentX(Component.CENTER_ALIGNMENT);
            info_panel.add(numKitchen);
        }
        if (property.getType().equals("Office")) {
            JLabel numOffice = new JLabel("Number of Office Rooms: " + property.getNumOffice());
            numOffice.setAlignmentX(Component.CENTER_ALIGNMENT);
            info_panel.add(numOffice);
            JLabel numReception = new JLabel("Number of Receptions: " + property.getNumReception());
            numReception.setAlignmentX(Component.CENTER_ALIGNMENT);
            info_panel.add(numReception);
        }
        if (property.getType().equals("Kitchen")) {
            JLabel spec = new JLabel("Kitchen Specifications: " + property.getSpec());
            spec.setAlignmentX(Component.CENTER_ALIGNMENT);
            info_panel.add(spec);
        }
        if (isOwner) {
            // delete property button
            JButton delete = new JButton("Delete Property");
            delete.setAlignmentX(Component.CENTER_ALIGNMENT);
            delete.addActionListener(e -> {
                String password = JOptionPane.showInputDialog(this, "Enter Password: ");
                propertyScreenPresenter.onDelete(propertyID, password);});
            info_panel.add(delete);

            // bids on property
            JPanel bids = new JPanel();
            bids.setLayout(new BoxLayout(bids, BoxLayout.Y_AXIS));
            for (BidModel bid: property.getBids()) {
                String id = bid.getID();
                JLabel bidder = new JLabel("Name: " + bid.getName());
                bidder.setAlignmentX(Component.CENTER_ALIGNMENT);
                bids.add(bidder);
                JLabel bidAmount = new JLabel("Offer: " + bid.getBid());
                bidAmount.setAlignmentX(Component.CENTER_ALIGNMENT);
                bids.add(bidAmount);
                JButton account = new JButton("Go to Account");
                account.setAlignmentX(Component.CENTER_ALIGNMENT);
                account.addActionListener(e -> propertyScreenPresenter.onBidderAccount(id));
                bids.add(account);
                bids.add(new JLabel(" "));
            }
            JScrollPane bids_pane = new JScrollPane(bids);
            info_panel.add(bids_pane);
        } else {
            // owner account button
            JButton ownerAccount = new JButton("Owner Account");
            ownerAccount.setAlignmentX(Component.CENTER_ALIGNMENT);
            info_panel.add(ownerAccount);
            ownerAccount.addActionListener(e -> propertyScreenPresenter.onOwnerAccount(ownerID));

            // send offer field
            bid = new JTextField(15);
            JLabel bidInfo = new JLabel("Set Offer Amount: ");
            JButton sendOffer = new JButton("Send Offer");
            bidInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
            bidInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
            sendOffer.setAlignmentX(Component.CENTER_ALIGNMENT);
            info_panel.add(bidInfo);
            info_panel.add(bid);
            info_panel.add(sendOffer);
            sendOffer.addActionListener(e -> {propertyScreenPresenter.onSendBid(propertyID, bid.getText());});

            // estimate mortgage
            JButton estimateMortgage = new JButton("Estimate Mortgage");
            estimateMortgage.setAlignmentX(Component.CENTER_ALIGNMENT);
            info_panel.add(estimateMortgage);
            estimateMortgage.addActionListener(e -> {propertyScreenPresenter.onEstimateMortgage(propertyPrice);});
        }
        info_panel.repaint();
        info_panel.revalidate();
    }
}
