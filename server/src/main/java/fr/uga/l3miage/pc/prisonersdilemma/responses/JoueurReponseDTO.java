package fr.uga.l3miage.pc.prisonersdilemma.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoueurReponseDTO {
    private Long id;
    private String nom;
    private int score;

}
