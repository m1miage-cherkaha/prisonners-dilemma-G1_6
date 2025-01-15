package fr.uga.l3miage.pc.prisonersdilemma.models;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.TypeStrategie;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Joueur;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    @Test
    void testDefaultConstructor() {
        // Act
        Joueur joueur = new Joueur();

        // Assert
        assertNull(joueur.getId());
        assertNull(joueur.getNom());
        assertEquals(0, joueur.getScore());
        assertNull(joueur.getStrategie());
    }

    @Test
    void testConstructorWithName() {
        // Arrange
        String nomJoueur = "Alice";

        // Act
        Joueur joueur = new Joueur(nomJoueur);

        // Assert
        assertNull(joueur.getId());
        assertEquals(nomJoueur, joueur.getNom());
        assertEquals(0, joueur.getScore());
        assertNull(joueur.getStrategie());
    }

    @Test
    void testFullConstructor() {
        // Arrange
        Long id = 1L;
        String nomJoueur = "Bob";
        int scoreInitial = 10;
        TypeStrategie strategieJoueur = TypeStrategie.DONNANT_DONNANT;

        // Act
        Joueur joueur = new Joueur(id, nomJoueur, scoreInitial, strategieJoueur);

        // Assert
        assertEquals(id, joueur.getId());
        assertEquals(nomJoueur, joueur.getNom());
        assertEquals(scoreInitial, joueur.getScore());
        assertEquals(strategieJoueur, joueur.getStrategie());
    }

    @Test
    void testAjouterPoints() {
        // Arrange
        Joueur joueur = new Joueur("Charlie");
        int pointsInitiaux = joueur.getScore();
        int pointsAAjouter = 5;

        // Act
        joueur.ajouterPoints(pointsAAjouter);

        // Assert
        assertEquals(pointsInitiaux + pointsAAjouter, joueur.getScore());
    }

    @Test
    void testAjouterPointsNegative() {
        // Arrange
        Joueur joueur = new Joueur("David");
        int pointsInitiaux = 10;
        joueur.setScore(pointsInitiaux);
        int pointsAAjouter = -3;

        // Act
        joueur.ajouterPoints(pointsAAjouter);

        // Assert
        assertEquals(pointsInitiaux + pointsAAjouter, joueur.getScore());
    }

    @Test
    void testSettersAndGetters() {
        // Arrange
        Joueur joueur = new Joueur();
        Long id = 2L;
        String nomJoueur = "Eve";
        int scoreJoueur = 15;
        TypeStrategie strategieJoueur = TypeStrategie.TOUJOURS_COOPERER;

        // Act
        joueur.setId(id);
        joueur.setNom(nomJoueur);
        joueur.setScore(scoreJoueur);
        joueur.setStrategie(strategieJoueur);

        // Assert
        assertEquals(id, joueur.getId());
        assertEquals(nomJoueur, joueur.getNom());
        assertEquals(scoreJoueur, joueur.getScore());
        assertEquals(strategieJoueur, joueur.getStrategie());
    }
}