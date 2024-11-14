package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;




public class DonnantPourDeuxDonnantAleatoireStrategieTest {

    private DonnantPourDeuxDonnantAleatoireStrategie strategie;

    @BeforeEach
    public void setUp() {
        strategie = new DonnantPourDeuxDonnantAleatoireStrategie();
    }

    @Test
    public void testFaireChoixWithEmptyList() {
        List<Decision> coupsAdversaire = Arrays.asList();
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, decision);
    }

    @Test
    public void testFaireChoixWithSingleDecision() {
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER);
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertTrue(decision == Decision.COOPERER || decision == Decision.TRAHIR);
    }

    @Test
    public void testFaireChoixWithTwoSameDecisions() {
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.COOPERER);
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, decision);
    }

    @Test
    public void testFaireChoixWithTwoDifferentDecisions() {
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR);
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, decision);
    }

    @Test
    public void testFaireChoixWithThreeDecisionsLastTwoSame() {
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR, Decision.TRAHIR);
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.TRAHIR, decision);
    }

    @Test
    public void testFaireChoixWithThreeDecisionsLastTwoDifferent() {
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR, Decision.COOPERER);
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, decision);
    }
}