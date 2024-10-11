package fr.uga.l3miage.pc.prisonnersdilemma.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartieJoinRequest {
     private String nomJoueur2;
     private String strategieJoueur2;
}
