package fr.uga.l3miage.pc.prisonersdilemma.responses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PartieResponseDTOTest {

    @Test
    void testNoArgsConstructor() {
        PartieResponseDTO dto = new PartieResponseDTO();
        assertNotNull(dto);
    }

    @Test
    void testAllArgsConstructor() {
        PartieResponseDTO dto = new PartieResponseDTO(1L, 2L, 3L, 5, "IN_PROGRESS");
        assertEquals(1L, dto.getId());
        assertEquals(2L, dto.getJoueur1Id());
        assertEquals(3L, dto.getJoueur2Id());
        assertEquals(5, dto.getNbTours());
        assertEquals("IN_PROGRESS", dto.getStatus());
    }

    @Test
    void testBuilder() {
        PartieResponseDTO dto = PartieResponseDTO.builder()
                .id(1L)
                .joueur1Id(2L)
                .joueur2Id(3L)
                .nbTours(5)
                .status("IN_PROGRESS")
                .build();
        assertEquals(1L, dto.getId());
        assertEquals(2L, dto.getJoueur1Id());
        assertEquals(3L, dto.getJoueur2Id());
        assertEquals(5, dto.getNbTours());
        assertEquals("IN_PROGRESS", dto.getStatus());
    }

    @Test
    void testSettersAndGetters() {
        PartieResponseDTO dto = new PartieResponseDTO();
        dto.setId(1L);
        dto.setJoueur1Id(2L);
        dto.setJoueur2Id(3L);
        dto.setNbTours(5);
        dto.setStatus("IN_PROGRESS");

        assertEquals(1L, dto.getId());
        assertEquals(2L, dto.getJoueur1Id());
        assertEquals(3L, dto.getJoueur2Id());
        assertEquals(5, dto.getNbTours());
        assertEquals("IN_PROGRESS", dto.getStatus());
    }
}