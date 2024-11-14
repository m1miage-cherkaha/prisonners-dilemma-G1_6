package fr.uga.l3miage.pc.prisonersdilemma.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategie;

import static org.junit.jupiter.api.Assertions.*;


class JoueurTest {

    private Joueur joueur;

    @BeforeEach
    public void setUp() {
        joueur = new Joueur("TestPlayer");
    }

    @Test
    void testAjouterPoints() {
        joueur.ajouterPoints(10);
        assertEquals(10, joueur.getScore(), "Score should be 10 after adding 10 points");

        joueur.ajouterPoints(5);
        assertEquals(15, joueur.getScore(), "Score should be 15 after adding 5 more points");
    }

    @Test
    void testConstructorWithName() {
        assertEquals("TestPlayer", joueur.getNom(), "Name should be 'TestPlayer'");
        assertEquals(0, joueur.getScore(), "Initial score should be 0");
    }

    @Test
    void testDefaultConstructor() {
        Joueur defaultJoueur = new Joueur();
        assertNull(defaultJoueur.getNom(), "Name should be null for default constructor");
        assertEquals(0, defaultJoueur.getScore(), "Initial score should be 0 for default constructor");
    }

    @Test
    void testAllArgsConstructor() {
        Joueur allArgsJoueur = new Joueur(1L, "AllArgsPlayer", 20, TypeStrategie.TOUJOURS_COOPERER);
        assertEquals(1L, allArgsJoueur.getId(), "ID should be 1");
        assertEquals("AllArgsPlayer", allArgsJoueur.getNom(), "Name should be 'AllArgsPlayer'");
        assertEquals(20, allArgsJoueur.getScore(), "Score should be 20");
        assertEquals(TypeStrategie.TOUJOURS_COOPERER, allArgsJoueur.getStrategie(), "Strategy should be COOPERATE");
    }
}