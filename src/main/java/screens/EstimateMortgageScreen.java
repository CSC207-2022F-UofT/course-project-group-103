package screens;

import presenters.EstimateMortgagePresenter;

import javax.swing.*;
import java.awt.*;

public class EstimateMortgageScreen extends JPanel {

    EstimateMortgagePresenter estimateMortgagePresenter;
    JTextField downpayment;
    JTextField rate;
    JTextField years;
    public EstimateMortgageScreen(EstimateMortgagePresenter presenter) {
        this.estimateMortgagePresenter = presenter;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }


    /**
     * Displays the screen for mortgage estimation
     * @param price float as passed on by the property object
     */
    public void draw(float price) {
        this.removeAll();
        // back button
        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(back);
        back.addActionListener(e -> estimateMortgagePresenter.onBack());

        JLabel price_display = new JLabel("Mortgage Estimator: " + price);

        downpayment = new JTextField(1);
        rate = new JTextField(1);
        years = new JTextField(1);

        JLabel downpayment_tag = new JLabel("Enter Downpayment: ");
        JLabel rate_tag = new JLabel("Enter Mortgage Rate: ");
        JLabel years_tag = new JLabel("Enter Amortization Period (years): ");

        JButton submit = new JButton("Get Estimate");

        downpayment.setAlignmentX(Component.CENTER_ALIGNMENT);
        rate.setAlignmentX(Component.CENTER_ALIGNMENT);
        years.setAlignmentX(Component.CENTER_ALIGNMENT);

        price_display.setAlignmentX(Component.CENTER_ALIGNMENT);
        downpayment_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        rate_tag.setAlignmentX(Component.CENTER_ALIGNMENT);
        years_tag.setAlignmentX(Component.CENTER_ALIGNMENT);

        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(price_display);
        this.add(downpayment_tag);
        this.add(downpayment);
        this.add(rate_tag);
        this.add(rate);
        this.add(years_tag);
        this.add(years);
        this.add(submit);

        submit.addActionListener(e -> this.estimateMortgagePresenter.onEstimateMortgage(price, downpayment.getText(),
                rate.getText(), years.getText()));

        this.repaint();
        this.revalidate();

    }
}
