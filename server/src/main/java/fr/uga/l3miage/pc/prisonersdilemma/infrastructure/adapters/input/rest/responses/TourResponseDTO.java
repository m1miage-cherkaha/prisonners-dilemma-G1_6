package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TourResponseDTO {
    private Long id;
    private int roundNumber;
    private String status;
}
