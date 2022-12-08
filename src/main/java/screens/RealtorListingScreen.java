package screens;

import presenters.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RealtorListingScreen extends JPanel implements ActionListener{
    RealtorListingPresenter realtorListingPresenter;
    JPanel panel = new JPanel();

    public RealtorListingScreen(RealtorListingPresenter p){
        this.realtorListingPresenter = p;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> realtorListingPresenter.onBack());
        this.displayRealtors();

        JScrollPane sp = new JScrollPane(panel);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(sp);
    }

    public void displayRealtors() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (ArrayList<String> al: this.realtorListingPresenter.realtors()) {
            JLabel l1 = new JLabel(al.get(0));
            JLabel l2 = new JLabel(al.get(1));
            JButton hire = new JButton("Hire Realtor");

            l1.setAlignmentX(Component.CENTER_ALIGNMENT);
            l2.setAlignmentX(Component.CENTER_ALIGNMENT);
            hire.setAlignmentX(Component.CENTER_ALIGNMENT);

            panel.add(l1);
            panel.add(l2);
            panel.add(hire);
            hire.addActionListener(this);
        }
    }

    // Button pressed
    public void actionPerformed(ActionEvent evt) {
        try {
            // check if user already hired realtor
            realtorListingPresenter.realtorHire();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

}
