import org.junit.jupiter.api.Test;
import presenters.EstimateMortgagePresenter;
import screens.GUI;

import static org.junit.jupiter.api.Assertions.*;

class EstimateMortgageInteractorTest {

    @Test
    void create() {
        GUI view = new GUI();
        // use case is created in the constructor of presenter and then called
        EstimateMortgagePresenter presenter = new EstimateMortgagePresenter(view) {
            @Override
            public void onEstimateMortgageSuccess(String monthly_payments) {
                assertEquals(monthly_payments, "2081.26");
            }

            @Override
            public void onEstimateMortgageFailure(String message) {
                assertEquals(message, "Failed to estimate");
            }
        };
        presenter.onEstimateMortgage(500000,"1000", "0.01", "20");
    }
}