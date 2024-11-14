package fr.uga.l3miage.pc.prisonnersdilemma.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TourRequest {
    private Long idPartie;
    private Long id;
    private String decisionJoueur1;
    private String decisionJoueur2;
}
