package screens;

import presenters.LoginScreenPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JPanel implements ActionListener{

    LoginScreenPresenter loginScreenPresenter;
    JTextField username;
    JPasswordField password;

    public LoginScreen(LoginScreenPresenter presenter) {
        // setup
        this.loginScreenPresenter = presenter;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.draw();
    }

    public void draw() {

        // input field setup
        JPanel inputs = new JPanel();
        inputs.setLayout(new BoxLayout(inputs, BoxLayout.Y_AXIS));
        inputs.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputs.setPreferredSize(new Dimension(200, 50));
        inputs.setMaximumSize(new Dimension(200, 50));
        username = new JTextField(15);
        password = new JPasswordField(15);
        inputs.add(username);
        inputs.add(password);

        // title
        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        JButton login = new JButton("Login");
        login.setAlignmentX(Component.CENTER_ALIGNMENT);
        login.addActionListener(this);

        JButton signUp = new JButton("Sign Up");
        signUp.setAlignmentX(Component.CENTER_ALIGNMENT);
        signUp.addActionListener(e -> loginScreenPresenter.onSignUp());

        this.add(inputs);
        this.add(login);
        this.add(signUp);
    }

    public void redraw() {
        this.removeAll();
        this.draw();
        this.repaint();
        this.revalidate();
    }

    // Button pressed
    public void actionPerformed(ActionEvent evt) {
        String u = username.getText();
        String p = new String(password.getPassword());
        loginScreenPresenter.onLogin(u, p);
    }
}
