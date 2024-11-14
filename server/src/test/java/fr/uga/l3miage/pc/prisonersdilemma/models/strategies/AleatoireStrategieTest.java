package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class AleatoireStrategieTest {

    @Test
    public void testFaireChoix() {
        AleatoireStrategie strategie = new AleatoireStrategie();
        List<Decision> coupsAdversaire = new ArrayList<>();

        // Run the strategy multiple times to check for randomness
        boolean foundCooperer = false;
        boolean foundTrahir = false;

        for (int i = 0; i < 100; i++) {
            Decision decision = strategie.faireChoix(coupsAdversaire);
            if (decision == Decision.COOPERER) {
                foundCooperer = true;
            } else if (decision == Decision.TRAHIR) {
                foundTrahir = true;
            }
            if (foundCooperer && foundTrahir) {
                break;
            }
        }

        assertTrue(foundCooperer, "The strategy should sometimes choose to cooperate.");
        assertTrue(foundTrahir, "The strategy should sometimes choose to betray.");
    }
}