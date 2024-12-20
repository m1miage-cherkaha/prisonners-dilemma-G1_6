package fr.uga.l3miage.pc.prisonersdilemma.models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Tour;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

    class PartieTest {

        private Joueur joueur1;
        private Joueur joueur2;
        private Partie partie;

        @BeforeEach
        void setUp() {
            joueur1 = new Joueur();
            joueur2 = new Joueur();
            partie = new Partie(joueur1, joueur2, 5);
        }
        @Test
        void testPartieConstructor() {
            assertNotNull(partie);
            assertEquals(joueur1, partie.getJoueur1());
            assertEquals(joueur2, partie.getJoueur2());
            assertEquals(5, partie.getNbTours());
            assertEquals("EN_COURS", partie.getStatus());
            assertNotNull(partie.getTours());
        }
        void testNoArgsConstructor() {
            Partie partie = new Partie();
            assertNotNull(partie);
            assertEquals(null, partie.getJoueur1());
            assertEquals(null, partie.getJoueur2());
            assertEquals(0, partie.getNbTours());
            assertEquals(null, partie.getTours());
        }
        void testAllArgsConstructor() {
            List<Tour> tours = new ArrayList<>();
            tours.add(new Tour());
            Partie partie = new Partie(1L, joueur1, joueur2, 5, tours, "EN_COURS");
            assertNotNull(partie);
            assertEquals(joueur1, partie.getJoueur1());
            assertEquals(joueur2, partie.getJoueur2());
            assertEquals(5, partie.getNbTours());
            assertEquals("EN_COURS", partie.getStatus());
            assertEquals(tours, partie.getTours());
        }
        @Test
        void testAllArgsConstructorNull() {
            Partie partie = new Partie(1L, null, null, 5, null, "EN_COURS");
            assertNotNull(partie);
            assertEquals(null, partie.getJoueur1());
            assertEquals(null, partie.getJoueur2());
            assertEquals(5, partie.getNbTours());
            assertEquals("EN_COURS", partie.getStatus());
            assertEquals(null, partie.getTours());
        }
        @Test
        void testSetAndGetId() {
            partie.setId(1L);
            assertEquals(1L, partie.getId());
        }

        @Test
        void testSetAndGetJoueur1() {
            Joueur newJoueur1 = new Joueur();
            partie.setJoueur1(newJoueur1);
            assertEquals(newJoueur1, partie.getJoueur1());
        }

        @Test
        void testSetAndGetJoueur2() {
            Joueur newJoueur2 = new Joueur();
            partie.setJoueur2(newJoueur2);
            assertEquals(newJoueur2, partie.getJoueur2());
        }

        @Test
        void testSetAndGetNbTours() {
            partie.setNbTours(10);
            assertEquals(10, partie.getNbTours());
        }

        @Test
        void testSetAndGetTours() {
            List<Tour> tours = new ArrayList<>();
            partie.setTours(tours);
            assertEquals(tours, partie.getTours());
        }

        @Test
        void testSetAndGetStatus() {
            partie.setStatus("In Progress");
            assertEquals("In Progress", partie.getStatus());
        }
        @Test
            void testAddTour() {
                Tour tour = new Tour();
                partie.getTours().add(tour);
                assertEquals(1, partie.getTours().size());
                assertEquals(tour, partie.getTours().get(0));
        }
        @Test
        void testAddTourNull() {
            partie.getTours().add(null);
            assertEquals(1, partie.getTours().size());
        }



}