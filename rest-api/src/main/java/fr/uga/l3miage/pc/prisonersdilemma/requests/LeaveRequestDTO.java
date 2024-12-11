package fr.uga.l3miage.pc.prisonersdilemma.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeaveRequestDTO {
    private Long id;
    private String strategy;
}
