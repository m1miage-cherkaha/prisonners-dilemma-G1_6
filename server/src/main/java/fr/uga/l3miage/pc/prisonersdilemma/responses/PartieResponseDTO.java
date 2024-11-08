package fr.uga.l3miage.pc.prisonersdilemma.responses;

import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartieResponseDTO {
    private String nomJoueur1;
    private int nbTours;
    private Strategie strategieJoueur1;
}
