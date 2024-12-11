package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;

import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;



class PavlovStrategieTest {

    private PavlovStrategie pavlovStrategie;

    @BeforeEach
    void setUp() {
        pavlovStrategie = new PavlovStrategie();
    }

    @Test
    void testFaireChoix_initialDecision() {
        Decision decision = pavlovStrategie.faireChoix(Collections.emptyList());
        assertEquals(Decision.TRAHIR, decision, "Initial decision should be COOPERER");
    }

    @Test
    void testFaireChoix_repeatLastDecision() {
        pavlovStrategie.setLastScore(5);
        Decision decision = pavlovStrategie.faireChoix(Collections.emptyList());
        assertEquals(Decision.COOPERER, decision, "Decision should repeat last decision COOPERER when last score is 5");

        pavlovStrategie.setLastScore(3);
        decision = pavlovStrategie.faireChoix(Collections.emptyList());
        assertEquals(Decision.COOPERER, decision, "Decision should repeat last decision COOPERER when last score is 3");
    }

    @Test
    void testFaireChoix_alternateDecision() {
        pavlovStrategie.setLastScore(1);
        Decision decision = pavlovStrategie.faireChoix(Collections.emptyList());
        assertEquals(Decision.TRAHIR, decision, "Decision should alternate to TRAHIR when last score is not 5 or 3");

        pavlovStrategie.setLastScore(2);
        decision = pavlovStrategie.faireChoix(Collections.emptyList());
        assertEquals(Decision.COOPERER, decision, "Decision should alternate to COOPERER when last score is not 5 or 3");
    }
}