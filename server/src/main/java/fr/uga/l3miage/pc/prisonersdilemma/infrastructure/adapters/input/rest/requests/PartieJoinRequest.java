package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PartieJoinRequest {
     private String nomJoueur2;
}