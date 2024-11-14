
package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



class SondeurNaifStrategieTest {

    private SondeurNaifStrategie strategie;

    @BeforeEach
    void setUp() {
        strategie = new SondeurNaifStrategie();
    }

    @Test
    void testFaireChoix_Trahir() {
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.COOPERER);
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertTrue(decision == Decision.TRAHIR || decision == Decision.COOPERER);
    }

    @Test
    void testFaireChoix_SuivreDernierCoup() {
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR);
        Decision decision = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.TRAHIR, decision);
    }
}