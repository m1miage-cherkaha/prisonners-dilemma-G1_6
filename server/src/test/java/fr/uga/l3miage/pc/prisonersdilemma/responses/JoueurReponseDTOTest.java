package fr.uga.l3miage.pc.prisonersdilemma.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class JoueurReponseDTOTest {

    @Test
    void testJoueurReponseDTO() {
        Long id = 1L;
        String nom = "John Doe";
        int score = 100;

        JoueurReponseDTO joueur = new JoueurReponseDTO(id, nom, score);

        assertEquals(id, joueur.getId());
        assertEquals(nom, joueur.getNom());
        assertEquals(score, joueur.getScore());
    }

    @Test
    void testSetters() {
        JoueurReponseDTO joueur = new JoueurReponseDTO(1L, "John Doe", 100);

        joueur.setId(2L);
        joueur.setNom("Jane Doe");
        joueur.setScore(200);

        assertEquals(2L, joueur.getId());
        assertEquals("Jane Doe", joueur.getNom());
        assertEquals(200, joueur.getScore());
    }
}