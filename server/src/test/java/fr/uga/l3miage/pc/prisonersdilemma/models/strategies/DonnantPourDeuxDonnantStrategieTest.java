package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;




class DonnantPourDeuxDonnantStrategieTest {

    @Test
    void testFaireChoixWithTwoSameDecisions() {
        DonnantPourDeuxDonnantStrategie strategie = new DonnantPourDeuxDonnantStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.COOPERER);
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, result);
    }

    @Test
    void testFaireChoixWithTwoDifferentDecisions() {
        DonnantPourDeuxDonnantStrategie strategie = new DonnantPourDeuxDonnantStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR);
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, result);
    }

    @Test
    void testFaireChoixWithLessThanTwoDecisions() {
        DonnantPourDeuxDonnantStrategie strategie = new DonnantPourDeuxDonnantStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER);
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, result);
    }

    @Test
    void testFaireChoixWithEmptyList() {
        DonnantPourDeuxDonnantStrategie strategie = new DonnantPourDeuxDonnantStrategie();
        List<Decision> coupsAdversaire = Arrays.asList();
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, result);
    }
}