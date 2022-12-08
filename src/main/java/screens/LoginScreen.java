package screens;

import presenters.ActiveAccountPresenter;
import presenters.ChangePasswordScreenPresenter;
import presenters.LoginScreenPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Objects;

public class LoginScreen extends JPanel implements ActionListener{

    LoginScreenPresenter loginScreenPresenter;
    ActiveAccountPresenter activeAccountPresenter;
    ChangePasswordScreenPresenter changePasswordScreenPresenter;
    JTextField username;
    JPasswordField password;

    public LoginScreen(LoginScreenPresenter presenter, ActiveAccountPresenter activeAccountPresenter,
                       ChangePasswordScreenPresenter changePasswordScreenPresenter) {
        // setup
        this.loginScreenPresenter = presenter;
        this.activeAccountPresenter = activeAccountPresenter;
        this.changePasswordScreenPresenter = changePasswordScreenPresenter;
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
        signUp.addActionListener(e -> {loginScreenPresenter.onSignUp();});

        JButton forgot_password = new JButton("Forgot Password");
        forgot_password.setAlignmentX(CENTER_ALIGNMENT);
        forgot_password.addActionListener(e -> {
            String name = username.getText();
            try {
                loginScreenPresenter.onOpenChangePassword(name, "Please input a username.");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        this.add(inputs);
        this.add(login);
        this.add(signUp);
        this.add(forgot_password);
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
        try {
            loginScreenPresenter.onLogin(u, p);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

}
