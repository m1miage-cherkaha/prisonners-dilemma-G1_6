package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;


import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class DonnantDonnantAleatoireStrategieTest {

    private DonnantDonnantAleatoireStrategie strategie;

    @BeforeEach
    void setUp() {
        strategie = new DonnantDonnantAleatoireStrategie();
    }

    @Test
    void testFaireChoixReturnsLastDecision() {
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR, Decision.COOPERER);
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, decision);
    }

    @Test
    void testFaireChoixReturnsRandomDecision() {
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR, Decision.COOPERER);
        boolean randomDecisionOccurred = false;
        for (int i = 0; i < 100; i++) {
            Decision decision = strategie.faireChoix(coupsAdversaire);
            if (decision != Decision.COOPERER) {
                randomDecisionOccurred = true;
                break;
            }
        }
        assertTrue(randomDecisionOccurred, "Expected a random decision to occur at least once in 100 iterations");
    }
}