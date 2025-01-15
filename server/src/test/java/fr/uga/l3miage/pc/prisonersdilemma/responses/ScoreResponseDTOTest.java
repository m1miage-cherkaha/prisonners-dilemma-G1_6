package fr.uga.l3miage.pc.prisonersdilemma.responses;


import org.junit.jupiter.api.Test;

import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.ScoreResponseDTO;

import static org.junit.jupiter.api.Assertions.*;

class ScoreResponseDTOTest {

    @Test
    void testScoreResponseDTOBuilder() {
        ScoreResponseDTO scoreResponse = ScoreResponseDTO.builder()
                .scoreJoueur1(10)
                .scoreJoueur2(20)
                .build();

        assertEquals(10, scoreResponse.getScoreJoueur1());
        assertEquals(20, scoreResponse.getScoreJoueur2());
    }

    @Test
    void testScoreResponseDTOAllArgsConstructor() {
        ScoreResponseDTO scoreResponse = new ScoreResponseDTO(30, 40);

        assertEquals(30, scoreResponse.getScoreJoueur1());
        assertEquals(40, scoreResponse.getScoreJoueur2());
    }

    @Test
    void testScoreResponseDTOSetters() {
        ScoreResponseDTO scoreResponse = new ScoreResponseDTO(0, 0);
        scoreResponse.setScoreJoueur1(50);
        scoreResponse.setScoreJoueur2(60);

        assertEquals(50, scoreResponse.getScoreJoueur1());
        assertEquals(60, scoreResponse.getScoreJoueur2());
    }
}