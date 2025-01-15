package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies.CoopererStrategie;

import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;




class CoopererStrategieTest {

    @Test
    void testFaireChoixWithEmptyList() {
        CoopererStrategie strategie = new CoopererStrategie();
        List<Decision> coupsAdversaire = Collections.emptyList();
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, decision);
    }

    @Test
    void testFaireChoixWithNonEmptyList() {
        CoopererStrategie strategie = new CoopererStrategie();
        List<Decision> coupsAdversaire = List.of(Decision.TRAHIR, Decision.COOPERER);
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, decision);
    }
}