package fr.uga.l3miage.pc.prisonersdilemma.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ScoreResponseDTOTest {

    @Test
    void testScoreResponseDTOBuilder() {
        ScoreResponseDTO scoreResponseDTO = ScoreResponseDTO.builder()
                .scoreJoueur1(10)
                .scoreJoueur2(20)
                .build();

        assertEquals(10, scoreResponseDTO.getScoreJoueur1());
        assertEquals(20, scoreResponseDTO.getScoreJoueur2());
    }

    @Test
    void testScoreResponseDTOAllArgsConstructor() {
        ScoreResponseDTO scoreResponseDTO = new ScoreResponseDTO(30, 40);

        assertEquals(30, scoreResponseDTO.getScoreJoueur1());
        assertEquals(40, scoreResponseDTO.getScoreJoueur2());
    }

    @Test
    void testScoreResponseDTOSetters() {
        ScoreResponseDTO scoreResponseDTO = new ScoreResponseDTO(0, 0);
        scoreResponseDTO.setScoreJoueur1(50);
        scoreResponseDTO.setScoreJoueur2(60);

        assertEquals(50, scoreResponseDTO.getScoreJoueur1());
        assertEquals(60, scoreResponseDTO.getScoreJoueur2());
    }
}