package fr.uga.l3miage.pc.prisonnersdilemma.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PartieCreationRequest {
    private String nomJoueur1;
    private int nbTours;
    private String strategieJoueur1;
}
