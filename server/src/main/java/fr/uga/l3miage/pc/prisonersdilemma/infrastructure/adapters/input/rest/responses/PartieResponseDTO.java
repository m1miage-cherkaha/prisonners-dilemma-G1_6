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
public class PartieResponseDTO {
    private Long id;
    private Long joueur1Id;
    private Long joueur2Id;
    private int nbTours;
    private String status;
}
