package fr.uga.l3miage.pc.prisonersdilemma.responses;

import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.models.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartieResponseDTO {
    private Long id;
    private Long joueur1Id;
    private Long joueur2Id;
    private int nbTours;
    private int scoreJoueur1;
    private int scoreJoueur2;
    private Strategie strategieJoueur1;
    private Strategie strategieJoueur2;

    public PartieResponseDTO(Partie partie){
        this.joueur1Id =  partie.getJoueur1().getId();
        this.nbTours = partie.getNbTours();
    }
}
