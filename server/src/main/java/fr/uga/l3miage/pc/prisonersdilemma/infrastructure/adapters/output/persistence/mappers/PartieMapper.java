package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.mappers;

import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.PartieResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Partie;

public class PartieMapper {
    private PartieMapper() {
    }
    public static PartieResponseDTO toPartieResponseDTO(Partie partie){
        return PartieResponseDTO.builder()
                .id(partie.getId())
                .joueur1Id(partie.getJoueur1().getId())
                .joueur2Id(partie.getJoueur2().getId())
                .nbTours(partie.getNbTours())
                .status(partie.getStatus())
                .build();
    }
    
}
