package presenters;

import interactors.SingleReviewInteractor;
import java.util.ArrayList;

public class SingleReviewPresenter {

    SingleReviewInteractor singleReviewInteractor;
    ViewInterface viewInterface;

    public SingleReviewPresenter(SingleReviewInteractor i, ViewInterface p) {
        this.singleReviewInteractor = i;
        this.viewInterface = p;
    }

    public ArrayList<String> onReviewInfo() {
        return this.singleReviewInteractor.reviewInfo();
    }
}
