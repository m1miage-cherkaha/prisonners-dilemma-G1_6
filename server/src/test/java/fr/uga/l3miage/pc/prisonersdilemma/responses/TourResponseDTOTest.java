package fr.uga.l3miage.pc.prisonersdilemma.responses;

import org.junit.jupiter.api.Test;

import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.TourResponseDTO;

import static org.junit.jupiter.api.Assertions.*;

class TourResponseDTOTest {

    @Test
    void testNoArgsConstructor() {
        TourResponseDTO dto = new TourResponseDTO();
        assertNull(dto.getId());
        assertEquals(0, dto.getRoundNumber());
        assertNull(dto.getStatus());
    }

    @Test
    void testAllArgsConstructor() {
        TourResponseDTO dto = new TourResponseDTO(1L, 2, "In Progress");
        assertEquals(1L, dto.getId());
        assertEquals(2, dto.getRoundNumber());
        assertEquals("In Progress", dto.getStatus());
    }

    @Test
    void testBuilder() {
        TourResponseDTO dto = TourResponseDTO.builder()
                .id(1L)
                .roundNumber(2)
                .status("In Progress")
                .build();
        assertEquals(1L, dto.getId());
        assertEquals(2, dto.getRoundNumber());
        assertEquals("In Progress", dto.getStatus());
    }

    @Test
    void testSettersAndGetters() {
        TourResponseDTO dto = new TourResponseDTO();
        dto.setId(1L);
        dto.setRoundNumber(2);
        dto.setStatus("In Progress");

        assertEquals(1L, dto.getId());
        assertEquals(2, dto.getRoundNumber());
        assertEquals("In Progress", dto.getStatus());
    }
}