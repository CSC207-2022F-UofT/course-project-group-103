package screens;

import interactors.SingleListingModel;
import presenters.ListingScreenPresenter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListingScreen extends JPanel implements ActionListener {
    ListingScreenPresenter listingScreenPresenter;
    JTextField pricerange;
    JTextField sqftrange;
    JCheckBox house;
    JCheckBox condo;
    JCheckBox office;
    JCheckBox restaurant;
    JPanel panel = new JPanel();

    public ListingScreen(ListingScreenPresenter presenter) {
        this.listingScreenPresenter = presenter;
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
        back.addActionListener(e -> listingScreenPresenter.onBack());

        // filters setup
        JLabel price_tag = new JLabel("Price Range: ");
        JLabel sqft_tag = new JLabel("SqFt Range: ");
        price_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        sqft_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        pricerange.setAlignmentX(Component.CENTER_ALIGNMENT);
        sqftrange.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel types = new JPanel();
        types.setLayout(new BoxLayout(types, BoxLayout.X_AXIS));
        house = new JCheckBox("House", true);
        condo = new JCheckBox("Condo", true);
        office = new JCheckBox("Office", true);
        restaurant = new JCheckBox("Restaurant", true);
        types.add(house);
        types.add(condo);
        types.add(office);
        types.add(restaurant);
        this.add(types);
        JPanel inputs = new JPanel();
        inputs.setLayout(new BoxLayout(inputs, BoxLayout.Y_AXIS));
        inputs.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputs.setPreferredSize(new Dimension(200, 100));
        inputs.setMaximumSize(new Dimension(200, 100));
        inputs.add(price_tag);
        inputs.add(pricerange);
        inputs.add(sqft_tag);
        inputs.add(sqftrange);
        this.add(inputs);
        JButton refresh = new JButton("Refresh");
        refresh.setAlignmentX(Component.CENTER_ALIGNMENT);
        refresh.addActionListener(this);
        this.add(refresh);

        // set up the listings scroll panel (empty until panel loaded)
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JScrollPane l = new JScrollPane(panel);
        l.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        l.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(l);
    }

    public void setUpListings(ArrayList<SingleListingModel> info) {
        panel.removeAll();
        for (SingleListingModel m: info) {
            String id = m.getID();
            JLabel address = new JLabel("Address: " + m.getAddress());
            address.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel price = new JLabel("Price: " + Float.toString(m.getPrice()));
            price.setAlignmentX(Component.CENTER_ALIGNMENT);
            JButton b = new JButton("View Property");
            b.setAlignmentX(Component.CENTER_ALIGNMENT);
            b.addActionListener(e -> {
                this.listingScreenPresenter.onAccessProperty(id);
            });
            panel.add(address);
            panel.add(price);
            panel.add(b);
            panel.add(new JLabel(" "));
        }
        panel.repaint();
        panel.revalidate();
    }

    public void redraw() {
        this.removeAll();
        this.draw();
        this.repaint();
        this.revalidate();
    }

    public void actionPerformed(ActionEvent evt) {
        this.listingScreenPresenter.onListingUpdate(pricerange.getText(), sqftrange.getText(), house.isSelected(),
                condo.isSelected(), office.isSelected(), restaurant.isSelected());
    }
}
