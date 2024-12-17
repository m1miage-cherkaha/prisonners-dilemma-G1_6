
package fr.uga.l3miage.pc.prisonersdilemma.models;


import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

class StrategieTest {

    private class MockStrategie implements Strategie {
        @Override
        public Decision faireChoix(List<Decision> coupsAdversaire) {
            // Simple mock implementation for testing purposes
            if (coupsAdversaire.isEmpty()) {
                return Decision.COOPERER;
            }
            return coupsAdversaire.get(coupsAdversaire.size() - 1);
        }
    }

    @Test
    void testFaireChoixWithEmptyList() {
        Strategie strategie = new MockStrategie();
        List<Decision> coupsAdversaire = Arrays.asList();
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, result);
    }

    @Test
    void testFaireChoixWithSingleDecision() {
        Strategie strategie = new MockStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.TRAHIR);
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.TRAHIR, result);
    }

    @Test
    void testFaireChoixWithMultipleDecisions() {
        Strategie strategie = new MockStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR, Decision.COOPERER);
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, result);
    }
}