import interactors.EstimateMortgageInteractor;
import interactors.output_boundary.EstimateMortgageOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstimateMortgageInteractorTest {

    @Test
    void create() {
        class Output implements EstimateMortgageOutput {
            @Override
            public void onEstimateMortgageSuccess(String monthly_payments) {
                assertEquals("2081.26", monthly_payments);
            }

            @Override
            public void onEstimateMortgageFailure(String message) {
                fail("failed to estiamte mortgage");
            }
        }
        Output output = new Output();
        EstimateMortgageInteractor test = new EstimateMortgageInteractor(output);
        test.estimateMortgage(500000, "1000", "0.01", "20");
    }
}