package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies.DonnantDonnantAleatoireStrategie;

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

class DonnantDonnantAleatoireStrategieTest {

    private DonnantDonnantAleatoireStrategie strategie;

    @Mock
    private Random mockRandom;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        strategie = new DonnantDonnantAleatoireStrategie();

        // Use reflection to set the private random field
        try {
            java.lang.reflect.Field randomField = DonnantDonnantAleatoireStrategie.class.getDeclaredField("random");
            randomField.setAccessible(true);
            randomField.set(strategie, mockRandom);
        } catch (Exception e) {
            fail("Could not set up mock Random");
        }
    }

    @Test
    void testFollowLastMoveNormally() {
        // Arrange
        when(mockRandom.nextInt(10)).thenReturn(5); // Not the special case (1)
        List<Decision> coupsAdversaire = Arrays.asList(Decision.TRAHIR, Decision.COOPERER);

        // Act
        Decision result = strategie.faireChoix(coupsAdversaire);

        // Assert
        assertEquals(Decision.COOPERER, result);
        verify(mockRandom).nextInt(10);
    }

    @Test
    void testRandomDecisionWhenIndexIsOne() {
        // Arrange
        when(mockRandom.nextInt(10)).thenReturn(0); // Special case (index 1)
        when(mockRandom.nextInt(2)).thenReturn(0); // Cooperation
        List<Decision> coupsAdversaire = Arrays.asList(Decision.TRAHIR);

        // Act
        Decision result = strategie.faireChoix(coupsAdversaire);

        // Assert
        assertEquals(Decision.COOPERER, result);
        verify(mockRandom).nextInt(10);
        verify(mockRandom).nextInt(2);
    }

    @Test
    void testRandomDecisionWhenIndexIsOneTrahir() {
        // Arrange
        when(mockRandom.nextInt(10)).thenReturn(0); // Special case (index 1)
        when(mockRandom.nextInt(2)).thenReturn(1); // Betrayal
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER);

        // Act
        Decision result = strategie.faireChoix(coupsAdversaire);

        // Assert
        assertEquals(Decision.TRAHIR, result);
        verify(mockRandom).nextInt(10);
        verify(mockRandom).nextInt(2);
    }

    @Test
    void testEmptyAdversaryMovesList() {
        // Arrange
        when(mockRandom.nextInt(10)).thenReturn(5); // Not the special case (1)

        // Act & Assert
        assertThrows(IndexOutOfBoundsException.class, 
        () -> strategie.faireChoix(new ArrayList<>()));
    }

    //@Test
    void testRandomnessDistribution() {
        // Arrange
        strategie = new DonnantDonnantAleatoireStrategie();
        int randomDecisionCount = 0;
        int followLastMoveCount = 0;
        int iterations = 10000;

        List<Decision> coupsAdversaire = Arrays.asList(Decision.TRAHIR);

        // Act
        for (int i = 0; i < iterations; i++) {
            Decision decision = strategie.faireChoix(coupsAdversaire);
            
            // Determine if it was a random or follow-last-move decision
            if (decision != Decision.TRAHIR) {
                randomDecisionCount++;
            } else {
                followLastMoveCount++;
            }
        }

        // Assert
        // Check that random decisions occur roughly 10% of the time
        double randomProbability = (double) randomDecisionCount / iterations;
        assertTrue(randomProbability > 0.05 && randomProbability < 0.15,
                "Random decision probability should be close to 0.1");
    }
}