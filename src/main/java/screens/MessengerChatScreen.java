package screens;

import interactors.exceptions.MessengerNotFound;
import interactors.exceptions.UndefinedUserType;
import presenters.MessengerPresenter;
import presenters.SendMessagePresenter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MessengerChatScreen extends JPanel implements ActionListener {

    MessengerPresenter messengerPresenter;

    SendMessagePresenter sendMessagePresenter;

    JPanel pane1;

    JPanel pane2;

    JTextArea text;

    JComboBox messengers;

    JButton sendMessage;



    public MessengerChatScreen(MessengerPresenter presenter1, SendMessagePresenter presenter2) throws MessengerNotFound, UndefinedUserType, IOException {
        this.messengerPresenter = presenter1;
        this.sendMessagePresenter = presenter2;

    }

    public void draw(String User2ID) throws MessengerNotFound, UndefinedUserType, IOException {
        if (User2ID == null) {
            this.removeAll();
            // pane 1 & 2
            pane1 = new JPanel(new BorderLayout());
            pane2 = new JPanel(new BorderLayout(1, 410));
            pane2.setBackground(new Color(0x888888));

            // combobox of messengers
            String sender_id = messengerPresenter.viewInterface.getActiveUser();
            String[] contacts = messengerPresenter.getNames(sender_id);
            messengers = new JComboBox<>(contacts);
            messengers.addActionListener(this);
            pane1.add(messengers, BorderLayout.EAST);

            // back button
            JButton back = new JButton("Back");
            back.setAlignmentX(Component.CENTER_ALIGNMENT);
            back.setAlignmentY(Component.TOP_ALIGNMENT);
            pane1.add(back, BorderLayout.PAGE_START);
            back.addActionListener(e -> messengerPresenter.onBack());

            // Send message button
            sendMessage = new JButton("send message");
            sendMessage.setAlignmentY(Component.BOTTOM_ALIGNMENT);
            pane1.add(sendMessage, BorderLayout.PAGE_END);

            // Send Message text
            text = new JTextArea();
            text.setBackground(new Color(0xbbbbbb));
            text.setPreferredSize(new Dimension(250, 70));
            text.setLineWrap(true);
            pane2.add(text, BorderLayout.PAGE_END);
            Dimension dim = new Dimension(250, 350);
            pane2.setPreferredSize(dim);

            this.add(pane1, BorderLayout.WEST);
            this.add(pane2, BorderLayout.CENTER);

            this.repaint();
            this.revalidate();


        } else {

            this.removeAll();

            // pane 1 & 2
            pane1 = new JPanel(new BorderLayout());
            pane2 = new JPanel(new BorderLayout(1, 410));
            pane2.setBackground(new Color(0x888888));

            // combobox of messengers
            String sender_id = messengerPresenter.viewInterface.getActiveUser();
            String[] contacts = messengerPresenter.getNames(sender_id);
            messengers = new JComboBox<>(contacts);
            messengers.setPreferredSize(new Dimension(400, 100));
            messengers.addActionListener(this);
            pane1.add(messengers, BorderLayout.CENTER);

            // back button
            JButton back = new JButton("Back");
            back.setAlignmentX(Component.CENTER_ALIGNMENT);
            pane1.add(back, BorderLayout.PAGE_START);
            back.addActionListener(e -> messengerPresenter.onBack());

            // Send message button
            sendMessage = new JButton("send message");

            pane1.add(sendMessage, BorderLayout.PAGE_END);
            pane2.setLayout(new BoxLayout(pane2, BoxLayout.Y_AXIS));
            // Show message logs
            for (String log: messengerPresenter.getChat(sender_id, User2ID)) {
                pane2.add(new JLabel(log), BorderLayout.CENTER);
            }

            // Send Message text
            text = new JTextArea();
            text.setBackground(new Color(0xbbbbbb));
            text.setLineWrap(true);
            pane2.add(text, BorderLayout.PAGE_END);
            Dimension dim = new Dimension(250, 350);
            pane2.setPreferredSize(dim);
            sendMessage.addActionListener(e -> {

                try {
                    sendMessagePresenter.onPress(sender_id, User2ID, text.getText());
                } catch (MessengerNotFound | UndefinedUserType | IOException ex) {
                    throw new RuntimeException(ex);
                }

            });

            this.add(pane1, BorderLayout.WEST);
            this.add(pane2, BorderLayout.CENTER);
            this.setVisible(true);

            this.repaint();
            this.revalidate();
        }
    }

    public void actionPerformed(ActionEvent e) {
            String username = (String) messengers.getSelectedItem();
            String User2_ID = messengerPresenter.getUserID(username);
            this.removeAll();
            try {
                this.draw(User2_ID);
            } catch (MessengerNotFound | UndefinedUserType | IOException ex) {
                throw new RuntimeException(ex);
            }
            this.repaint();
            this.revalidate();

    }
}
