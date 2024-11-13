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


    public PartieResponseDTO(Partie partie){
        this.id = partie.getId();
        this.joueur1Id =  partie.getJoueur1().getId();
        this.joueur2Id = partie.getJoueur2().getId();

    }
}
