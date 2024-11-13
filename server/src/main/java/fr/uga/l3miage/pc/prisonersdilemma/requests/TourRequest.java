package fr.uga.l3miage.pc.prisonersdilemma.requests;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TourRequest {
    private Long id;
    private Decision decisionJoueur1;
    private Decision decisionJoueur2;
}
