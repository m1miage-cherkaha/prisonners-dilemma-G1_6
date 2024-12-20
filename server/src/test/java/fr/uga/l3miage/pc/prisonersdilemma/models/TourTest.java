package fr.uga.l3miage.pc.prisonersdilemma.models;


import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Tour;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    class TourTest {

        @Test
        void testTourConstructorAndGetters() {
            Partie partie = new Partie();
            Tour tour = new Tour(1L, 10, 20, Decision.COOPERER, Decision.TRAHIR, "IN_PROGRESS", partie);

            assertEquals(1L, tour.getId());
            assertEquals(10, tour.getPointJoueur1());
            assertEquals(20, tour.getPointJoueur2());
            assertEquals(Decision.COOPERER, tour.getDecisionJoueur1());
            assertEquals(Decision.TRAHIR, tour.getDecisionJoueur2());
            assertEquals("IN_PROGRESS", tour.getStatus());
            assertEquals(partie, tour.getPartie());
        }

        @Test
        void testTourSetters() {
            Tour tour = new Tour();
            Partie partie = new Partie();

            tour.setId(2L);
            tour.setPointJoueur1(15);
            tour.setPointJoueur2(25);
            tour.setDecisionJoueur1(Decision.TRAHIR);
            tour.setDecisionJoueur2(Decision.COOPERER);
            tour.setStatus("COMPLETED");
            tour.setPartie(partie);

            assertEquals(2L, tour.getId());
            assertEquals(15, tour.getPointJoueur1());
            assertEquals(25, tour.getPointJoueur2());
            assertEquals(Decision.TRAHIR, tour.getDecisionJoueur1());
            assertEquals(Decision.COOPERER, tour.getDecisionJoueur2());
            assertEquals("COMPLETED", tour.getStatus());
            assertEquals(partie, tour.getPartie());
        }

        @Test
        void testTourNoArgsConstructor() {
            Tour tour = new Tour();

            assertNull(tour.getId());
            assertEquals(0, tour.getPointJoueur1());
            assertEquals(0, tour.getPointJoueur2());
            assertNull(tour.getDecisionJoueur1());
            assertNull(tour.getDecisionJoueur2());
            assertNull(tour.getStatus());
            assertNull(tour.getPartie());
        }

        @Test
        void testTourEqualsAndHashCode() {
            Partie partie1 = new Partie();
            Partie partie2 = new Partie();
            Tour tour1 = new Tour(1L, 10, 20, Decision.COOPERER, Decision.TRAHIR, "IN_PROGRESS", partie1);
            Tour tour2 = new Tour(1L, 10, 20, Decision.COOPERER, Decision.TRAHIR, "IN_PROGRESS", partie1);
            Tour tour3 = new Tour(2L, 15, 25, Decision.TRAHIR, Decision.COOPERER, "COMPLETED", partie2);

            assertEquals(tour1, tour2);
            assertNotEquals(tour1, tour3);
            assertEquals(tour1.hashCode(), tour2.hashCode());
            assertNotEquals(tour1.hashCode(), tour3.hashCode());
        }

        @Test
        void testTourToString() {
            Partie partie = new Partie();
            Tour tour = new Tour(1L, 10, 20, Decision.COOPERER, Decision.TRAHIR, "IN_PROGRESS", partie);

            String expected = "Tour(id=1, pointJoueur1=10, pointJoueur2=20, decisionJoueur1=COOPERER, decisionJoueur2=TRAHIR, status=IN_PROGRESS, partie=" + partie + ")";
            assertEquals(expected, tour.toString());
        }
    }