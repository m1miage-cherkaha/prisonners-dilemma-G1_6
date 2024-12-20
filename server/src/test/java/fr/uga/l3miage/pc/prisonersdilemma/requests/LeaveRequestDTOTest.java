package fr.uga.l3miage.pc.prisonersdilemma.requests;

import org.junit.jupiter.api.Test;

import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.LeaveRequestDTO;

import static org.junit.jupiter.api.Assertions.*;


class LeaveRequestDTOTest {

    @Test
    void testLeaveRequestDTO() {
        Long id = 1L;
        String strategy = "cooperate";

        LeaveRequestDTO leaveRequestDTO = new LeaveRequestDTO(id, strategy);

        assertEquals(id, leaveRequestDTO.getId());
        assertEquals(strategy, leaveRequestDTO.getStrategy());
    }

    @Test
    void testSetters() {
        LeaveRequestDTO leaveRequestDTO = new LeaveRequestDTO(1L, "cooperate");

        leaveRequestDTO.setId(2L);
        leaveRequestDTO.setStrategy("defect");

        assertEquals(2L, leaveRequestDTO.getId());
        assertEquals("defect", leaveRequestDTO.getStrategy());
    }
}