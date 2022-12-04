package screens;

import controllers.LoginScreenController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JPanel implements ActionListener{

    LoginScreenController LoginPageController;
    JTextField username = new JTextField(15);
    JPasswordField password = new JPasswordField(15);

    public LoginScreen(LoginScreenController controller) {
        // setup
        this.LoginPageController = controller;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // title
        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        JButton login = new JButton("Login");
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        login.addActionListener(this);
        this.add(username);
        this.add(password);
        this.add(login);
    }

    // Button pressed
    public void actionPerformed(ActionEvent evt) {
        String u = username.getText();
        String p = new String(password.getPassword());
        if (!LoginPageController.login(u,p)) {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password.");
        }
    }
}
