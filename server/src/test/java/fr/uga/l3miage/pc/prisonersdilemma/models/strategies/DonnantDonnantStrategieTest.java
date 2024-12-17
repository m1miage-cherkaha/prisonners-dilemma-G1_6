package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;


import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;



class DonnantDonnantStrategieTest {

    @Test
    void testFaireChoixWithSingleDecision() {
        DonnantDonnantStrategie strategie = new DonnantDonnantStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER);
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, result);
    }

    @Test
    void testFaireChoixWithMultipleDecisions() {
        DonnantDonnantStrategie strategie = new DonnantDonnantStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR, Decision.COOPERER);
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, result);
    }

    @Test
    void testFaireChoixWithLastDecisionDefect() {
        DonnantDonnantStrategie strategie = new DonnantDonnantStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR);
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.TRAHIR, result);
    }

    @Test
    void testFaireChoixWithEmptyList() {
        DonnantDonnantStrategie strategie = new DonnantDonnantStrategie();
        List<Decision> coupsAdversaire = Arrays.asList();
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, result);
        
    }
}