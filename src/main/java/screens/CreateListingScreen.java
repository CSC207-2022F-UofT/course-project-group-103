package screens;

import controllers.CreateListingController;

import javax.swing.*;
import java.awt.*;

public class CreateListingScreen extends JPanel {

    CreateListingController createListingController;
    JRadioButton house;
    JRadioButton condo;
    JRadioButton office;
    JRadioButton restaurant;
    ButtonGroup group;
    JPanel typeSelect;
    JPanel info;

    // info inputs
    JTextField name;
    JTextField address;
    JTextField sqFt;
    JTextField price;
    JTextField numBed;
    JTextField numBath;
    JTextField numLaundry;
    JTextField numKitchen;
    JTextField numOfficeRoom;
    JTextField numReception;
    JTextField kitchenSpec;

    public CreateListingScreen(CreateListingController c) {
        this.createListingController = c;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.draw();
    }

    public void draw() {

        // back button
        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> createListingController.back());

        // property type select buttons
        typeSelect = new JPanel();
        info = new JPanel();
        typeSelect.setLayout(new BoxLayout(typeSelect, BoxLayout.X_AXIS));
        typeSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        house = new JRadioButton("House");
        condo = new JRadioButton("Condo");
        office = new JRadioButton("Office");
        restaurant = new JRadioButton("Restaurant");
        group = new ButtonGroup();
        group.add(house);
        group.add(condo);
        group.add(office);
        group.add(restaurant);
        typeSelect.add(house);
        typeSelect.add(condo);
        typeSelect.add(office);
        typeSelect.add(restaurant);
        JLabel title = new JLabel("Select Property Type: ");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton confirm = new JButton("Confirm");
        confirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);
        this.add(typeSelect);
        this.add(confirm);
        JScrollPane l = new JScrollPane(info);
        l.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        l.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(l);
        confirm.addActionListener(e -> {
            if (house.isSelected()) {
                drawHouseInfo();
            }
            if (condo.isSelected()) {
                drawCondoInfo();
            }
            if (office.isSelected()) {
                drawOfficeInfo();
            }
            if (restaurant.isSelected()) {
                drawRestaurantInfo();
            }
        });
    }

    public void drawBasicInfo() {
        // draws the property info form shared between all types
        info.removeAll();
        name = new JTextField(15);
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        address = new JTextField(15);
        address.setAlignmentX(Component.CENTER_ALIGNMENT);
        sqFt = new JTextField(15);
        sqFt.setAlignmentX(Component.CENTER_ALIGNMENT);
        price = new JTextField(15);
        price.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel name_tag = new JLabel("Property Name: ");
        name_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel address_tag = new JLabel("Property Address ");
        address_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel sqFt_tag = new JLabel("Total SqFt: ");
        sqFt_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel price_tag = new JLabel("Asking Price: ");
        price_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.add(name_tag);
        info.add(name);
        info.add(address_tag);
        info.add(address);
        info.add(sqFt_tag);
        info.add(sqFt);
        info.add(price_tag);
        info.add(price);
    }

    public void drawHouseInfo() {
        // draws the property info form for houses
        this.drawBasicInfo();
        numBed = new JTextField(15);
        numBed.setAlignmentX(Component.CENTER_ALIGNMENT);
        numBath = new JTextField(15);
        numBath.setAlignmentX(Component.CENTER_ALIGNMENT);
        numKitchen = new JTextField(15);
        numKitchen.setAlignmentX(Component.CENTER_ALIGNMENT);
        numLaundry = new JTextField(15);
        numLaundry.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel bed_tag = new JLabel("Number of Bedrooms: ");
        bed_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel bath_tag = new JLabel("Number of Bathrooms: ");
        bath_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel kitchen_tag = new JLabel("Number of Kitchens: ");
        kitchen_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel laundry_tag = new JLabel("Number of Laundry Rooms: ");
        laundry_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.add(bed_tag);
        info.add(numBed);
        info.add(bath_tag);
        info.add(numBath);
        info.add(kitchen_tag);
        info.add(numKitchen);
        info.add(laundry_tag);
        info.add(numLaundry);
        JButton b = new JButton("Submit House Listing");
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.addActionListener(e -> {
            try {
                this.createListingController.sendCreateHouse(name.getText(), address.getText(), sqFt.getText(),
                        price.getText(), numBed.getText(), numBath.getText(), numLaundry.getText(),
                        numKitchen.getText());
                JOptionPane.showMessageDialog(this, "Listing Created.");
                this.createListingController.back();
            } catch(Exception exc) {
                JOptionPane.showMessageDialog(this, exc.getMessage());
            }

        });
        info.add(b);
        info.repaint();
        info.revalidate();
        this.repaint();
        this.revalidate();
    }

    public void drawCondoInfo() {
        // draws the property info form for condos
        this.drawBasicInfo();
        numBed = new JTextField(15);
        numBed.setAlignmentX(Component.CENTER_ALIGNMENT);
        numBath = new JTextField(15);
        numBath.setAlignmentX(Component.CENTER_ALIGNMENT);
        numKitchen = new JTextField(15);
        numKitchen.setAlignmentX(Component.CENTER_ALIGNMENT);
        numLaundry = new JTextField(15);
        numLaundry.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel bed_tag = new JLabel("Number of Bedrooms: ");
        bed_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel bath_tag = new JLabel("Number of Bathrooms: ");
        bath_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel kitchen_tag = new JLabel("Number of Kitchens: ");
        kitchen_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel laundry_tag = new JLabel("Number of Laundry Rooms: ");
        laundry_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.add(bed_tag);
        info.add(numBed);
        info.add(bath_tag);
        info.add(numBath);
        info.add(kitchen_tag);
        info.add(numKitchen);
        info.add(laundry_tag);
        info.add(numLaundry);
        JButton b = new JButton("Submit Condo Listing");
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.addActionListener(e -> {
            try {
                this.createListingController.sendCreateCondo(name.getText(), address.getText(), sqFt.getText(),
                        price.getText(), numBed.getText(), numBath.getText(), numLaundry.getText(),
                        numKitchen.getText());
                JOptionPane.showMessageDialog(this, "Listing Created.");
                this.createListingController.back();
            } catch(Exception exc) {
                JOptionPane.showMessageDialog(this, exc.getMessage());
            }
        });
        info.add(b);
        info.repaint();
        info.revalidate();
        this.repaint();
        this.revalidate();
    }

    public void drawOfficeInfo() {
        // draws the property info form for offices
        this.drawBasicInfo();
        numOfficeRoom = new JTextField(15);
        numOfficeRoom.setAlignmentX(Component.CENTER_ALIGNMENT);
        numReception = new JTextField(15);
        numReception.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel office_tag = new JLabel("Number of Office Rooms: ");
        office_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel reception_tag = new JLabel("Number of Receptions: ");
        reception_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.add(office_tag);
        info.add(numOfficeRoom);
        info.add(reception_tag);
        info.add(numReception);
        JButton b = new JButton("Submit Office Listing");
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.addActionListener(e -> {
            try {
                this.createListingController.sendCreateOffice(name.getText(), address.getText(), sqFt.getText(),
                        price.getText(), numOfficeRoom.getText(), numReception.getText());
                JOptionPane.showMessageDialog(this, "Listing Created.");
                this.createListingController.back();
            } catch(Exception exc) {
                JOptionPane.showMessageDialog(this, exc.getMessage());
            }
        });
        info.add(b);
        info.repaint();
        info.revalidate();
        this.repaint();
        this.revalidate();
    }

    public void drawRestaurantInfo() {
        // draws the property info form for restaurants
        this.drawBasicInfo();
        kitchenSpec = new JTextField(15);
        kitchenSpec.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel spec_tag = new JLabel("Kitchen Specifications: ");
        spec_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.add(spec_tag);
        info.add(kitchenSpec);
        JButton b = new JButton("Submit Restaurant Listing");
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.addActionListener(e -> {
            try {
                this.createListingController.sendCreateRestaurant(name.getText(), address.getText(), sqFt.getText(),
                        price.getText(), kitchenSpec.getText());
                JOptionPane.showMessageDialog(this, "Listing Created.");
                this.createListingController.back();
            } catch(Exception exc) {
                JOptionPane.showMessageDialog(this, exc.getMessage());
            }
        });
        info.add(b);
        info.repaint();
        info.revalidate();
        this.repaint();
        this.revalidate();
    }

    public void redraw() {
        this.removeAll();
        this.draw();
        this.repaint();
        this.revalidate();
    }
}
