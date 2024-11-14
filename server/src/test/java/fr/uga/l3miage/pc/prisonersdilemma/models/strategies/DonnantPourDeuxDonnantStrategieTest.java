package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;




public class DonnantPourDeuxDonnantStrategieTest {

    @Test
    public void testFaireChoixWithTwoSameDecisions() {
        DonnantPourDeuxDonnantStrategie strategie = new DonnantPourDeuxDonnantStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.COOPERER);
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, result);
    }

    @Test
    public void testFaireChoixWithTwoDifferentDecisions() {
        DonnantPourDeuxDonnantStrategie strategie = new DonnantPourDeuxDonnantStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR);
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, result);
    }

    @Test
    public void testFaireChoixWithLessThanTwoDecisions() {
        DonnantPourDeuxDonnantStrategie strategie = new DonnantPourDeuxDonnantStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER);
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, result);
    }

    @Test
    public void testFaireChoixWithEmptyList() {
        DonnantPourDeuxDonnantStrategie strategie = new DonnantPourDeuxDonnantStrategie();
        List<Decision> coupsAdversaire = Arrays.asList();
        Decision result = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, result);
    }
}