package Screens;

import Exceptions.UndefinedUserType;
import Interactors.SendMessageInteractor;
import Interactors.OpenMessengerInteractor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

public class MessengerChatScreen {
    public MessengerChatScreen( SendMessageController sendMessageController, OpenMessengerController openMessengerController)
            throws UndefinedUserType, IOException {

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Messenger Screen");
        frame.pack();
        frame.setSize(700, 500);
        JPanel pane1 = new JPanel(new BorderLayout());
        JPanel pane2 = new JPanel(new BorderLayout(1, 410));


//         Panel 1 (Sidebar)
        String[] contacts = {"Omar", "Zein", "Brandon", "Daniel"};
        JComboBox messengers = new JComboBox(contacts);
        messengers.setPreferredSize(new Dimension(100, 400));
        pane1.add(messengers, BorderLayout.CENTER);

        JButton sendMessage = new JButton("Send Message");
        pane1.add(sendMessage, BorderLayout.PAGE_END);

//         Panel 2 (Chat)
        pane2.setBackground(new Color(0xbbbbbb));

        JTextArea message = new JTextArea();
        message.setLineWrap(true);
        message.setLineWrap(true);
        message.setPreferredSize(new Dimension(100, 25));
        pane2.add(message, BorderLayout.PAGE_END);

        JLabel test = new JLabel("test this is a test");
        test.setBounds(200, 400, 100, 15);
        test.setAlignmentY(Component.TOP_ALIGNMENT);
        test.setAlignmentX(Component.LEFT_ALIGNMENT);
        pane2.add(test, BorderLayout.CENTER);

        frame.add(pane1, BorderLayout.WEST);
        frame.add(pane2, BorderLayout.CENTER);
        frame.setTitle("Messenger Screen");
        frame.setVisible(true);
    }

    public static void main(String[] args) throws UndefinedUserType, IOException {
        SendMessageInteractor sendMessageInteractor = new SendMessageInteractor("1", "4", "hello world");
        SendMessageController sendMessageController = new SendMessageController(sendMessageInteractor);
        OpenMessengerInteractor openMessengerInteractor = new OpenMessengerInteractor("4", "2");
        OpenMessengerController openMessengerController = new OpenMessengerController(openMessengerInteractor);
        new MessengerChatScreen(sendMessageController, openMessengerController);
    }
}
