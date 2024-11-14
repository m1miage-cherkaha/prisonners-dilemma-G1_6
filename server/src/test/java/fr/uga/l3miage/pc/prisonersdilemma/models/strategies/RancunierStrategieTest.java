package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;


import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;



class RancunierStrategieTest {

    @Test
    void testFaireChoix_AllCooperate() {
        RancunierStrategie strategie = new RancunierStrategie();
        Decision result = strategie.faireChoix(Collections.nCopies(5, Decision.COOPERER));
        assertEquals(Decision.COOPERER, result);
    }

    @Test
    void testFaireChoix_OneBetray() {
        RancunierStrategie strategie = new RancunierStrategie();
        Decision result = strategie.faireChoix(Arrays.asList(Decision.COOPERER, Decision.COOPERER, Decision.TRAHIR, Decision.COOPERER));
        assertEquals(Decision.TRAHIR, result);
    }

    @Test
    void testFaireChoix_AllBetray() {
        RancunierStrategie strategie = new RancunierStrategie();
        Decision result = strategie.faireChoix(Collections.nCopies(5, Decision.TRAHIR));
        assertEquals(Decision.TRAHIR, result);
    }

    @Test
    void testFaireChoix_EmptyList() {
        RancunierStrategie strategie = new RancunierStrategie();
        Decision result = strategie.faireChoix(Collections.emptyList());
        assertEquals(Decision.COOPERER, result);
    }
}