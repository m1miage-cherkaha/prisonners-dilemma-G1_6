package fr.uga.l3miage.pc.prisonnersdilemma.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TourRequest {
    private Long id;
    private String decisionJoueur1;
    private String decisionJoueur2;
}
