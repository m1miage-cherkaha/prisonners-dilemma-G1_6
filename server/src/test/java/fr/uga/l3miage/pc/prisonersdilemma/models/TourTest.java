package fr.uga.l3miage.pc.prisonersdilemma.models;


import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TourTest {

    private Tour tour;

    @BeforeEach
    void setUp() {
        tour = new Tour();
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(tour);
        assertNull(tour.getId());
        assertEquals(0, tour.getPointJoueur1());
        assertEquals(0, tour.getPointJoueur2());
        assertNull(tour.getDecisionJoueur1());
        assertNull(tour.getDecisionJoueur2());
        assertNull(tour.getPartie());
    }

    @Test
    void testAllArgsConstructor() {
        Partie partie = new Partie();
        Tour tour = new Tour(1L, 10, 20, Decision.COOPERER, Decision.TRAHIR, partie);

        assertEquals(1L, tour.getId());
        assertEquals(10, tour.getPointJoueur1());
        assertEquals(20, tour.getPointJoueur2());
        assertEquals(Decision.COOPERER, tour.getDecisionJoueur1());
        assertEquals(Decision.TRAHIR, tour.getDecisionJoueur2());
        assertEquals(partie, tour.getPartie());
    }

    @Test
    void testSettersAndGetters() {
        tour.setId(2L);
        tour.setPointJoueur1(15);
        tour.setPointJoueur2(25);
        tour.setDecisionJoueur1(Decision.COOPERER);
        tour.setDecisionJoueur2(Decision.TRAHIR);
        Partie partie = new Partie();
        tour.setPartie(partie);

        assertEquals(2L, tour.getId());
        assertEquals(15, tour.getPointJoueur1());
        assertEquals(25, tour.getPointJoueur2());
        assertEquals(Decision.COOPERER, tour.getDecisionJoueur1());
        assertEquals(Decision.TRAHIR, tour.getDecisionJoueur2());
        assertEquals(partie, tour.getPartie());
    }
}