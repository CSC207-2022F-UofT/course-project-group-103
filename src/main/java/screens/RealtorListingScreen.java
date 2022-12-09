package screens;

import interactors.SingleRealtorModel;
import presenters.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RealtorListingScreen extends JPanel{
    RealtorListingPresenter realtorListingPresenter;
    JPanel panel = new JPanel();

    public RealtorListingScreen(RealtorListingPresenter p) {
        this.realtorListingPresenter = p;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> realtorListingPresenter.onBack());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JScrollPane scroll = new JScrollPane(panel);
        this.add(scroll);
    }

    public void draw(ArrayList<SingleRealtorModel> realtors) {
        panel.removeAll();
        for (SingleRealtorModel r: realtors) {
            String id = r.getID();
            JLabel name = new JLabel("Name: " + r.getName());
            name.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel contact = new JLabel("Contact: " + r.getContact());
            contact.setAlignmentX(Component.CENTER_ALIGNMENT);
            JButton hire = new JButton("Hire");
            hire.setAlignmentX(Component.CENTER_ALIGNMENT);
            hire.addActionListener(e -> {
                this.realtorListingPresenter.onHireRealtor(id);});
            panel.add(name);
            panel.add(contact);
            panel.add(hire);
            panel.add(new JLabel(" "));

        }
        panel.repaint();
        panel.revalidate();
    }

}
