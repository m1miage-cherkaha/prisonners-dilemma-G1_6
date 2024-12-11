package fr.uga.l3miage.pc.prisonersdilemma.requests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TourRequestDTOTest {

    @Test
    void testTourRequestDTOBuilder() {
        Long idJoueur = 1L;
        String decisionJoueur1 = "COOPERATE";
        boolean isStrategyAdapter = true;

        TourRequestDTO dto = TourRequestDTO.builder()
                .idJoueur(idJoueur)
                .decisionJoueur1(decisionJoueur1)
                .isStrategyAdapter(isStrategyAdapter)
                .build();

        assertEquals(idJoueur, dto.getIdJoueur());
        assertEquals(decisionJoueur1, dto.getDecisionJoueur1());
        assertTrue(dto.isStrategyAdapter());
    }

    @Test
    void testTourRequestDTOAllArgsConstructor() {
        Long idJoueur = 2L;
        String decisionJoueur1 = "DEFECT";
        boolean isStrategyAdapter = false;

        TourRequestDTO dto = new TourRequestDTO(idJoueur, decisionJoueur1, isStrategyAdapter);

        assertEquals(idJoueur, dto.getIdJoueur());
        assertEquals(decisionJoueur1, dto.getDecisionJoueur1());
        assertFalse(dto.isStrategyAdapter());
    }

    @Test
    void testTourRequestDTOSetters() {
        TourRequestDTO dto = new TourRequestDTO(3L, "COOPERATE", true);

        dto.setIdJoueur(4L);
        dto.setDecisionJoueur1("DEFECT");
        dto.setStrategyAdapter(false);

        assertEquals(4L, dto.getIdJoueur());
        assertEquals("DEFECT", dto.getDecisionJoueur1());
        assertFalse(dto.isStrategyAdapter());
    }
}