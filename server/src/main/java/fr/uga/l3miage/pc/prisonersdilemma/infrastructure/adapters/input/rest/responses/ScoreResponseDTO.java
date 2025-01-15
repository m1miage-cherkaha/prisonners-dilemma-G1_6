package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ScoreResponseDTO {
    private int scoreJoueur1;
    private int scoreJoueur2;
}
