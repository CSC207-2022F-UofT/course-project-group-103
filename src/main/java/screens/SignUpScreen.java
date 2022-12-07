package screens;

import presenters.SignUpScreenPresenter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpScreen extends JPanel implements ActionListener{

    SignUpScreenPresenter signUpScreenPresenter;
    JTextField username;
    JTextField contact;
    JPasswordField password;
    JPasswordField confirm_password;

    public SignUpScreen(SignUpScreenPresenter presenter) {
        // setup
        this.signUpScreenPresenter = presenter;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.draw();
    }

    public void draw() {
        // input fields setup
        username = new JTextField(15);
        contact = new JTextField(15);
        password = new JPasswordField(15);
        confirm_password=  new JPasswordField(15);

        // back button
        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> signUpScreenPresenter.onBack());

        // title
        JLabel title = new JLabel("Sign Up");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        // draw input fields
        JButton signup = new JButton("Create Account");
        signup.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel username_tag = new JLabel("Enter Username: ");
        username_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        username.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel contact_tag = new JLabel("Enter Email: ");
        contact_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        contact.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel password_tag = new JLabel("Enter Password: ");
        password_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        password.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel confirm_password_tag = new JLabel("Confirm Password: ");
        confirm_password_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirm_password.setAlignmentX(Component.CENTER_ALIGNMENT);
        signup.addActionListener(this);
        this.add(username_tag);
        this.add(username);
        this.add(contact_tag);
        this.add(contact);
        this.add(password_tag);
        this.add(password);
        this.add(confirm_password_tag);
        this.add(confirm_password);
        this.add(signup);
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
        String c = contact.getText();
        String pass = new String(password.getPassword());
        String confirm_pass = new String(confirm_password.getPassword());
        this.signUpScreenPresenter.onSignUp(u, c, pass, confirm_pass);
    }
}
