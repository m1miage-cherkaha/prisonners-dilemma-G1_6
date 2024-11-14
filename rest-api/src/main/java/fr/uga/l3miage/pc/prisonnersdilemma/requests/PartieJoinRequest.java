package fr.uga.l3miage.pc.prisonnersdilemma.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PartieJoinRequest {
     private String nomJoueur2;
     private String strategieJoueur2;
}
