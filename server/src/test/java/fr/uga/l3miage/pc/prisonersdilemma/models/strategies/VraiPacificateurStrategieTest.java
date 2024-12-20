package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies.VraiPacificateurStrategie;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VraiPacificateurStrategieTest {

    @Test
    void testFaireChoixWithTwoCooperate() {
        VraiPacificateurStrategie strategie = new VraiPacificateurStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.TRAHIR, Decision.COOPERER, Decision.COOPERER);
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, decision);
    }

    @Test
    void testFaireChoixWithLessThanTwoDecisions() {
        VraiPacificateurStrategie strategie = new VraiPacificateurStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER);
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertTrue(decision == Decision.COOPERER || decision == Decision.TRAHIR);
    }

    @Test
    void testFaireChoixWithNonCooperateDecisions() {
        VraiPacificateurStrategie strategie = new VraiPacificateurStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.TRAHIR, Decision.TRAHIR);
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertTrue(decision == Decision.COOPERER || decision == Decision.TRAHIR);
    }

    @Test
    void testFaireChoixWithMixedDecisions() {
        VraiPacificateurStrategie strategie = new VraiPacificateurStrategie();
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR, Decision.COOPERER);
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertTrue(decision == Decision.COOPERER || decision == Decision.TRAHIR);
    }
}