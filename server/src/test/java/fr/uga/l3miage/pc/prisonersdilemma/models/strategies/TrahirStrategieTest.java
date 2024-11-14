package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;


import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TrahirStrategieTest {

    @Test
    void testFaireChoix() {
        TrahirStrategie trahirStrategie = new TrahirStrategie();
        List<Decision> coupsAdversaire = Collections.emptyList(); // The input doesn't matter for this strategy

        Decision decision = trahirStrategie.faireChoix(coupsAdversaire);

        assertEquals(Decision.TRAHIR, decision, "The strategy should always return TRAHIR");
    }
}