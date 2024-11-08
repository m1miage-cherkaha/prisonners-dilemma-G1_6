package fr.uga.l3miage.pc.prisonersdilemma.requests;

import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartieJoinRequest {
     private String nomJoueur2;
     private Strategie strategieJoueur2;
}
