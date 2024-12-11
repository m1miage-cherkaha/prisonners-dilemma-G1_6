package fr.uga.l3miage.pc.prisonersdilemma.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TourRequestDTO {
    private Long idJoueur;
    private String decisionJoueur1;
    private boolean isStrategyAdapter;
}
