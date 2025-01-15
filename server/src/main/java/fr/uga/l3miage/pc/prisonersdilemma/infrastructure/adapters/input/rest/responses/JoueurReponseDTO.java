package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JoueurReponseDTO {
    private Long id;
    private String nom;
    private int score;
}
