package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;


import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies.Adaptatif;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AdaptatifTest {

    private Adaptatif adaptatif;

    @BeforeEach
    public void setUp() {
        adaptatif = new Adaptatif();
    }

    @Test
    void testInitialMoves() {
        for (int i = 0; i < 6; i++) {
            assertEquals(Decision.COOPERER, adaptatif.faireChoix(List.of()));
        }
        for (int i = 6; i < 11; i++) {
            assertEquals(Decision.TRAHIR, adaptatif.faireChoix(List.of()));
        }
    }

    @Test
    void testUpdateScoreAndFaireChoix() {
        // Simulate some decisions and scores
        adaptatif.updateScore(3, Decision.COOPERER);
        adaptatif.updateScore(5, Decision.TRAHIR);
        adaptatif.updateScore(2, Decision.COOPERER);
        adaptatif.updateScore(4, Decision.TRAHIR);

        // Skip initial moves
        for (int i = 0; i < 11; i++) {
            adaptatif.faireChoix(List.of());
        }

        // Test decision after initial moves
        assertEquals(Decision.TRAHIR, adaptatif.faireChoix(List.of()));
    }

    @Test
    void testFaireChoixAfterInitialMoves() {
        // Skip initial moves
        for (int i = 0; i < 11; i++) {
            adaptatif.faireChoix(List.of());
        }

        // Simulate some decisions and scores
        adaptatif.updateScore(3, Decision.COOPERER);
        adaptatif.updateScore(5, Decision.TRAHIR);
        adaptatif.updateScore(2, Decision.COOPERER);
        adaptatif.updateScore(4, Decision.TRAHIR);

        // Test decision after initial moves
        assertEquals(Decision.TRAHIR, adaptatif.faireChoix(List.of()));

        // Update scores to favor cooperation
        adaptatif.updateScore(10, Decision.COOPERER);
        adaptatif.updateScore(1, Decision.TRAHIR);

        // Test decision after updating scores
        assertEquals(Decision.COOPERER, adaptatif.faireChoix(List.of()));
    }
}