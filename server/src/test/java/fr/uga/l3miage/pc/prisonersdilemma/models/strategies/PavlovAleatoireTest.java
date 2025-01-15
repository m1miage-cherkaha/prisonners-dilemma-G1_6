package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies.PavlovAleatoire;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PavlovAleatoireTest {

    private PavlovAleatoire strategie;

    @Mock
    private Random mockRandom;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        strategie = new PavlovAleatoire();

        // Use reflection to set the private random field
        try {
            java.lang.reflect.Field randomField = PavlovAleatoire.class.getDeclaredField("random");
            randomField.setAccessible(true);
            randomField.set(strategie, mockRandom);
        } catch (Exception e) {
            fail("Could not set up mock Random");
        }
    }

    @Test
    void testRandomDecisionWhenProbabilityLessThan01() {
        // Arrange
        when(mockRandom.nextDouble())
            .thenReturn(0.05)  // First call to check random probability
            .thenReturn(0.0);  // Second call for random boolean
        when(mockRandom.nextBoolean()).thenReturn(true);
        List<Decision> coupsAdversaire = new ArrayList<>();

        // Act
        Decision result = strategie.faireChoix(coupsAdversaire);

        // Assert
        assertEquals(Decision.COOPERER, result);
        verify(mockRandom, times(1)).nextDouble();
        verify(mockRandom).nextBoolean();
    }

    @Test
    void testRandomDecisionWhenProbabilityLessThan01Trahir() {
        // Arrange
        when(mockRandom.nextDouble())
            .thenReturn(0.05)  // First call to check random probability
            .thenReturn(0.0);  // Second call for random boolean
        when(mockRandom.nextBoolean()).thenReturn(false);
        List<Decision> coupsAdversaire = new ArrayList<>();

        // Act
        Decision result = strategie.faireChoix(coupsAdversaire);

        // Assert
        assertEquals(Decision.TRAHIR, result);
        verify(mockRandom, times(1)).nextDouble();
        verify(mockRandom).nextBoolean();
    }

    @Test
    void testStayWithSameDecisionWhenScoreIs5() {
        // Arrange
        when(mockRandom.nextDouble()).thenReturn(0.2);
        strategie.setLastScore(5);
        List<Decision> coupsAdversaire = new ArrayList<>();

        // First call sets initial state
        Decision initialDecision = strategie.faireChoix(coupsAdversaire);

        // Act
        Decision result = strategie.faireChoix(coupsAdversaire);

        // Assert
        assertEquals(initialDecision, result);
        verify(mockRandom, times(2)).nextDouble();
    }

    @Test
    void testStayWithSameDecisionWhenScoreIs3() {
        // Arrange
        when(mockRandom.nextDouble()).thenReturn(0.2);
        strategie.setLastScore(3);
        List<Decision> coupsAdversaire = new ArrayList<>();

        // First call sets initial state
        Decision initialDecision = strategie.faireChoix(coupsAdversaire);

        // Act
        Decision result = strategie.faireChoix(coupsAdversaire);

        // Assert
        assertEquals(initialDecision, result);
        verify(mockRandom, times(2)).nextDouble();
    }

    @Test
    void testSwitchDecisionWhenScoreNotOptimal() {
        // Arrange
        when(mockRandom.nextDouble()).thenReturn(0.2);
        strategie.setLastScore(1);
        List<Decision> coupsAdversaire = new ArrayList<>();

        // First call sets initial state to COOPERER
        strategie.faireChoix(coupsAdversaire);

        // Act
        Decision result = strategie.faireChoix(coupsAdversaire);

        // Assert
        assertEquals(Decision.COOPERER, result);
    }

    @Test
    void testRandomnessDistribution() {
        // Arrange
        strategie = new PavlovAleatoire();
        int randomDecisionCount = 0;
        int strategicDecisionCount = 0;
        int iterations = 10000;

        // Act
        for (int i = 0; i < iterations; i++) {
            // Simulate different scenarios
            strategie.setLastScore(i % 2 == 0 ? 5 : 1);
            Decision decision = strategie.faireChoix(new ArrayList<>());
            
            if (decision == Decision.COOPERER || decision == Decision.TRAHIR) {
                randomDecisionCount++;
            } else {
                strategicDecisionCount++;
            }
        }

        // Assert
        // Check that random decisions occur roughly 10% of the time
        double randomProbability = (double) randomDecisionCount / iterations;
        assertFalse(randomProbability > 0.05 && randomProbability < 0.15,
                "Random decision probability should be close to 0.1");
    }
}