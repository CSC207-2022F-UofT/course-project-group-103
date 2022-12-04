package screens;

import controllers.ListingController;
import controllers.SingleListingController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListingScreen extends JPanel implements ActionListener {
    ListingController listingController;

    JTextField pricerange;
    JTextField sqftrange;
    JCheckBox house;
    JCheckBox condo;
    JCheckBox office;
    JCheckBox restaurant;
    JPanel panel = new JPanel();

    public ListingScreen(ListingController c) {
        this.listingController = c;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.draw();
    }

    public void draw() {

        // reset the filter text
        pricerange = new JTextField("0-1000000",15);
        sqftrange = new JTextField("0-10000",15);

        // back button
        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> listingController.back());

        // filters setup
        JLabel price_tag = new JLabel("Price Range: ");
        JLabel sqft_tag = new JLabel("SqFt Range: ");
        price_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        sqft_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        pricerange.setAlignmentX(Component.CENTER_ALIGNMENT);
        sqftrange.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel types = new JPanel();
        types.setLayout(new BoxLayout(types, BoxLayout.X_AXIS));
        house = new JCheckBox("House");
        condo = new JCheckBox("Condo");
        office = new JCheckBox("Office");
        restaurant = new JCheckBox("Restaurant");
        types.add(house);
        types.add(condo);
        types.add(office);
        types.add(restaurant);
        this.add(types);
        this.add(price_tag);
        this.add(pricerange);
        this.add(sqft_tag);
        this.add(sqftrange);
        JButton refresh = new JButton("Refresh");
        refresh.setAlignmentX(Component.CENTER_ALIGNMENT);
        refresh.addActionListener(this);
        this.add(refresh);

        // set up the listings scroll panel
        this.setUpListings();
        JScrollPane l = new JScrollPane(panel);
        l.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        l.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(l);
    }

    public void setUpListings() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (SingleListingController controller: this.listingController.createListings()) {
            SingleListing j = new SingleListing(controller);
            j.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(j);
        }
    }

    public void redraw() {
        this.listingController.sendListingReset();
        panel.removeAll();
        this.removeAll();
        this.draw();
        this.repaint();
        this.revalidate();
    }

    public void actionPerformed(ActionEvent evt) {
        this.listingController.sendListingUpdate(pricerange.getText(), sqftrange.getText());
        this.listingController.sendListingTypeUpdate(house.isSelected(), condo.isSelected(),
                office.isSelected(),restaurant.isSelected());
        panel.removeAll();
        this.setUpListings();
        panel.repaint();
        panel.revalidate();
    }
}
