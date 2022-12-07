package screens;

import presenters.SingleReviewPresenter;

import javax.swing.*;

public class SingleReview extends JPanel {

    SingleReviewPresenter singleReviewPresenter;

    public SingleReview(SingleReviewPresenter presenter) {
        this.singleReviewPresenter = presenter;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // info
        for (String s: this.singleReviewPresenter.onReviewInfo()) {
            this.add(new JLabel(s));
        }
        this.add(new JLabel(" "));
    }

}
