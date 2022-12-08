package screens;

import interactors.exceptions.UndefinedUserType;
import presenters.ChangePasswordScreenPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChangePasswordScreen extends JPanel implements ActionListener {

    ChangePasswordScreenPresenter changePasswordScreenPresenter;
    JTextField securityAnswer;
    JTextField newPassword;

    public ChangePasswordScreen(ChangePasswordScreenPresenter changePasswordScreenPresenter) throws IOException {
        this.changePasswordScreenPresenter = changePasswordScreenPresenter;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        String securityQuestion = this.changePasswordScreenPresenter.getSecurityQuestion();
        boolean active = false;
        this.draw(securityQuestion, active);
    }

    void draw(String securityQuestion, boolean active) {
        securityAnswer = new JTextField(15);
        newPassword = new JTextField(15);

        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> {
                    if (active) {
                        changePasswordScreenPresenter.onBack();
                    } else {
                        changePasswordScreenPresenter.onBackInactive();
                    }
                });

        JLabel title = new JLabel("Change Password");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        JButton change_password = new JButton("Change Password");
        change_password.setAlignmentX(Component.CENTER_ALIGNMENT);
        change_password.addActionListener(this);
        JLabel security_answer_tag = new JLabel("Enter Security Answer: ");
        security_answer_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        securityAnswer.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel new_password_tag = new JLabel("Enter New Password: ");
        new_password_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        newPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel security_question_tag = new JLabel("Security Question: " + securityQuestion);
        security_question_tag.setAlignmentX(CENTER_ALIGNMENT);

        this.add(security_question_tag);
        this.add(security_answer_tag);
        this.add(securityAnswer);
        this.add(new_password_tag);
        this.add(newPassword);
        this.add(change_password);
    }

    /**
     * Draws the Change Password Screen.
     */
    public void redraw(String securityQuestion, boolean active) {
        this.removeAll();
        this.draw(securityQuestion, active);
        this.repaint();
        this.revalidate();
    }

    public void actionPerformed(ActionEvent e) {
        String sa = securityAnswer.getText();
        String new_pass = newPassword.getText();
        String user = this.changePasswordScreenPresenter.getUser();
        try {
            this.changePasswordScreenPresenter.onChangePassword(user, sa, new_pass);
        } catch (IOException | UndefinedUserType ex) {
            throw new RuntimeException(ex);
        }
    }
}
