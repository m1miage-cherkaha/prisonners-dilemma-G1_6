package fr.uga.l3miage.pc.prisonersdilemma.requests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class LeaveRequestDTOTest {

    @Test
    void testLeaveRequestDTOConstructorAndGetters() {
        Long id = 1L;
        String strategy = "TitForTat";

        LeaveRequestDTO leaveRequestDTO = new LeaveRequestDTO(id, strategy);

        assertEquals(id, leaveRequestDTO.getId());
        assertEquals(strategy, leaveRequestDTO.getStrategy());
    }

    @Test
    void testLeaveRequestDTOSetters() {
        LeaveRequestDTO leaveRequestDTO = new LeaveRequestDTO(1L, "TitForTat");

        Long newId = 2L;
        String newStrategy = "AlwaysCooperate";

        leaveRequestDTO.setId(newId);
        leaveRequestDTO.setStrategy(newStrategy);

        assertEquals(newId, leaveRequestDTO.getId());
        assertEquals(newStrategy, leaveRequestDTO.getStrategy());
    }

    @Test
    void testLeaveRequestDTOEqualsAndHashCode() {
        LeaveRequestDTO leaveRequestDTO1 = new LeaveRequestDTO(1L, "TitForTat");
        LeaveRequestDTO leaveRequestDTO2 = new LeaveRequestDTO(1L, "TitForTat");
        LeaveRequestDTO leaveRequestDTO3 = new LeaveRequestDTO(2L, "AlwaysCooperate");

        assertEquals(leaveRequestDTO1, leaveRequestDTO2);
        assertNotEquals(leaveRequestDTO1, leaveRequestDTO3);
        assertEquals(leaveRequestDTO1.hashCode(), leaveRequestDTO2.hashCode());
        assertNotEquals(leaveRequestDTO1.hashCode(), leaveRequestDTO3.hashCode());
    }

    @Test
    void testLeaveRequestDTOToString() {
        LeaveRequestDTO leaveRequestDTO = new LeaveRequestDTO(1L, "TitForTat");
        String expectedString = "LeaveRequestDTO(id=1, strategy=TitForTat)";

        assertEquals(expectedString, leaveRequestDTO.toString());
    }
}