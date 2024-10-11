package fr.uga.l3miage.pc.prisonersdilemma.mappers;

import fr.uga.l3miage.pc.prisonersdilemma.models.Partie;
import fr.uga.l3miage.pc.prisonnersdilemma.responses.PartieResponseDTO;

public class PartieMapper {
    static public PartieResponseDTO toPartieResponseDTO(Partie partie){
        return PartieResponseDTO.builder()
                .id(partie.getId())
                .joueur1Id(partie.getJoueur1().getId())
                .joueur2Id(partie.getJoueur2().getId())
                .build();
    }
    
}
