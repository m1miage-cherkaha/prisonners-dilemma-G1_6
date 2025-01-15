package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies.PacificateurNaifStrategie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PacificateurNaifStrategieTest {

    private PacificateurNaifStrategie strategie;

    @Mock
    private Random mockRandom;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        strategie = new PacificateurNaifStrategie();
        strategie.setRandom(mockRandom);
    }

    @Test
    void testCooperateWhenRandomValueLessThan03() {
        // Arrange
        when(mockRandom.nextDouble()).thenReturn(0.2);
        List<Decision> coupsAdversaire = Arrays.asList(Decision.TRAHIR, Decision.TRAHIR);

        // Act
        Decision result = strategie.faireChoix(coupsAdversaire);

        // Assert
        assertEquals(Decision.COOPERER, result);
        verify(mockRandom).nextDouble();
    }

    @Test
    void testFollowLastAdversaryMoveWhenRandomValueGreaterThan03() {
        // Arrange
        when(mockRandom.nextDouble()).thenReturn(0.5);
        List<Decision> coupsAdversaire = Arrays.asList(Decision.TRAHIR, Decision.COOPERER);

        // Act
        Decision result = strategie.faireChoix(coupsAdversaire);

        // Assert
        assertEquals(Decision.COOPERER, result);
        verify(mockRandom).nextDouble();
    }

    @Test
    void testEmptyAdversaryMovesList() {
        // Arrange
        when(mockRandom.nextDouble()).thenReturn(0.5);
        List<Decision> coupsAdversaire = new ArrayList<>();

        // Act & Assert
        assertThrows(IndexOutOfBoundsException.class, () -> {
            strategie.faireChoix(coupsAdversaire);
        });
    }

    @Test
    void testRandomnessDistribution() {
        // Arrange
        strategie.setRandom(new Random()); // Use actual Random for distribution test
        int cooperateCount = 0;
        int followLastMoveCount = 0;
        int iterations = 10000;

        List<Decision> coupsAdversaire = Arrays.asList(Decision.TRAHIR);

        // Act
        for (int i = 0; i < iterations; i++) {
            Decision result = strategie.faireChoix(coupsAdversaire);
            if (result == Decision.COOPERER) {
                cooperateCount++;
            } else {
                followLastMoveCount++;
            }
        }

        // Assert
        // Check that the distribution is close to the expected probabilities
        double cooperateProbability = (double) cooperateCount / iterations;
        assertTrue(cooperateProbability > 0.25 && cooperateProbability < 0.35,
                "Cooperation probability should be close to 0.3");
    }
}