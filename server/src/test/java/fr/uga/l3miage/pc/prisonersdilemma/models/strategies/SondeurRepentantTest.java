package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies.SondeurRepentant;

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

class SondeurRepentantTest {

    private SondeurRepentant strategie;

    @Mock
    private Random mockRandom;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        strategie = new SondeurRepentant();

        // Use reflection to set the private random field
        try {
            java.lang.reflect.Field randomField = SondeurRepentant.class.getDeclaredField("random");
            randomField.setAccessible(true);
            randomField.set(strategie, mockRandom);
        } catch (Exception e) {
            fail("Could not set up mock Random");
        }
    }

    @Test
    void testCooperateOnEmptyAdversaryMoves() {
        // Arrange
        List<Decision> coupsAdversaire = new ArrayList<>();

        // Act
        Decision result = strategie.faireChoix(coupsAdversaire);

        // Assert
        assertEquals(Decision.COOPERER, result);
    }

    @Test
    void testFollowLastMoveWhenNotTesting() {
        // Arrange
        when(mockRandom.nextDouble()).thenReturn(0.2);
        List<Decision> coupsAdversaire = Arrays.asList(Decision.TRAHIR);

        // Act
        Decision result = strategie.faireChoix(coupsAdversaire);

        // Assert
        assertEquals(Decision.TRAHIR, result);
        verify(mockRandom).nextDouble();
    }

    @Test
    void testRandomTestMove() {
        // Arrange
        when(mockRandom.nextDouble()).thenReturn(0.05);
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER);

        // Act
        Decision result = strategie.faireChoix(coupsAdversaire);

        // Assert
        assertEquals(Decision.TRAHIR, result);
        verify(mockRandom).nextDouble();
    }

    @Test
    void testRepentAfterTestingWithTrahirResponse() {
        // Arrange
        when(mockRandom.nextDouble()).thenReturn(0.05);
        List<Decision> coupsAdversaire = new ArrayList<>(Arrays.asList(Decision.COOPERER));

        // First call: test move (TRAHIR)
        Decision firstResult = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.TRAHIR, firstResult);

        // Simulate adversary's response with TRAHIR
        coupsAdversaire.add(Decision.TRAHIR);

        // Second call: should cooperate after testing
        Decision secondResult = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, secondResult);
    }

    @Test
    void testContinueNormalStrategyAfterTestingWithCooperateResponse() {
        // Arrange
        when(mockRandom.nextDouble()).thenReturn(0.05);
        List<Decision> coupsAdversaire = new ArrayList<>(Arrays.asList(Decision.COOPERER));

        // First call: test move (TRAHIR)
        Decision firstResult = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.TRAHIR, firstResult);

        // Simulate adversary's response with COOPERER
        coupsAdversaire.add(Decision.COOPERER);

        // Second call: should follow last move
        Decision secondResult = strategie.faireChoix(coupsAdversaire);
        assertEquals(Decision.TRAHIR, secondResult);
    }

    @Test
    void testRandomnessDistribution() {
        // Arrange
        strategie = new SondeurRepentant();
        int testMoveCount = 0;
        int normalMoveCount = 0;
        int iterations = 10000;

        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER);

        // Act
        for (int i = 0; i < iterations; i++) {
            Decision decision = strategie.faireChoix(coupsAdversaire);
            
            if (decision == Decision.TRAHIR) {
                testMoveCount++;
            } else {
                normalMoveCount++;
            }
        }

        // Assert
        // Check that test moves occur roughly 10% of the time
        double testProbability = (double) testMoveCount / iterations;
        assertTrue(testProbability > 0.05 && testProbability < 0.15,
                "Test move probability should be close to 0.1");
    }
}