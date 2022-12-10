import org.junit.jupiter.api.Test;
import presenters.EstimateMortgagePresenter;

import static org.junit.jupiter.api.Assertions.*;

class EstimateMortgageInteractorTest {

    @Test
    void create() {
        presenter_dependancy p = new presenter_dependancy();
        // use case is created in the constructor of presenter and then called
        EstimateMortgagePresenter presenter = new EstimateMortgagePresenter(p) {
            @Override
            public void onEstimateMortgageSuccess(String monthly_payments) {
                assertEquals(monthly_payments, "2081.26");
            }

            @Override
            public void onEstimateMortgageFailure(String message) {
                fail("failed to estimate mortgage");
            }
        };
        presenter.onEstimateMortgage(500000,"1000", "0.01", "20");
    }
}