package fr.uga.l3miage.pc.prisonersdilemma.models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



class PartieTest {

    private Joueur joueur1;
    private Joueur joueur2;
    private Partie partie;

    @BeforeEach
    public void setUp() {
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
    }

    @Test
    void testSetJoueur1() {
        Joueur newJoueur1 = new Joueur();
        partie.setJoueur1(newJoueur1);
        assertEquals(newJoueur1, partie.getJoueur1());
    }

    @Test
    void testSetJoueur2() {
        Joueur newJoueur2 = new Joueur();
        partie.setJoueur2(newJoueur2);
        assertEquals(newJoueur2, partie.getJoueur2());
    }

    @Test
    void testSetNbTours() {
        partie.setNbTours(10);
        assertEquals(10, partie.getNbTours());
    }

    @Test
    void testSetTours() {
        List<Tour> tours = new ArrayList<>();
        partie.setTours(tours);
        assertEquals(tours, partie.getTours());
    }
}