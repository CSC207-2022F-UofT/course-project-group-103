package Screens;

import Exceptions.UndefinedPropertyType;
import Interactors.AccessSinglePropertyInteractor;

import javax.swing.*;

public class SinglePropertyPageScreen {

    SinglePropertyPageScreenController controller;

    public SinglePropertyPageScreen(SinglePropertyPageScreenController controller) throws UndefinedPropertyType {
        this.controller = controller;

        JPanel panel = new JPanel();
        panel.setSize(500, 500);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (int i = 1; i < this.controller.getInfo().size(); i++) {
            JLabel label = new JLabel(this.controller.getInfo().get(i));
            label.setVerticalAlignment(SwingConstants.TOP);
            label.setHorizontalAlignment(SwingConstants.LEFT);
            panel.add(label);
        }
        JFrame frame = new JFrame();
        frame.setSize(10000, 10000);
        frame.setResizable(false);
        frame.setTitle(this.controller.getName());
        frame.setVisible(true);
        frame.add(panel);
        frame.pack();

    }
}
