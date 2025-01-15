package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LeaveRequestDTO {
    private Long id;
    private String strategy;
}
