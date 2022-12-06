package Screens;

import javax.swing.*;
import java.awt.*;

public class MessengerScreen {
    public MessengerScreen() {
        JFrame frame = new JFrame();;

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chat");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);
    }

}
