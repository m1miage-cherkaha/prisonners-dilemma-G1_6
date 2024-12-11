package fr.uga.l3miage.pc.prisonersdilemma.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ScoreResponseDTO {
    private int scoreJoueur1;
    private int scoreJoueur2;
}
