package fr.uga.l3miage.pc.prisonersdilemma.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TourResponseDTO {
    private Long id;
    private int pointJoueur1;
    private int pointJoueur2;
    private String decisionJoueur1;
    private String decisionJoueur2;
}
