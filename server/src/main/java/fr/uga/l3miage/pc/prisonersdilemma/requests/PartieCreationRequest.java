package fr.uga.l3miage.pc.prisonersdilemma.requests;

import fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategie;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartieCreationRequest {
    private String nomJoueur1;
    private int nbTours;
    private TypeStrategie strategieJoueur1;
}
