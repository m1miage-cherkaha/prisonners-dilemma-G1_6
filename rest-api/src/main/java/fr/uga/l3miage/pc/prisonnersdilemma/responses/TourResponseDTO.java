package fr.uga.l3miage.pc.prisonnersdilemma.responses;

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

    /*public TourResponseDTO(Tour tour) {
        this.id = tour.getId();
        this.pointJoueur1 = tour.getPointJoueur1();
        this.pointJoueur2 = tour.getPointJoueur2();
        this.decisionJoueur1 = tour.getDecisionJoueur1().toString();
        this.decisionJoueur2 = tour.getDecisionJoueur2().toString();
    }*/
}
