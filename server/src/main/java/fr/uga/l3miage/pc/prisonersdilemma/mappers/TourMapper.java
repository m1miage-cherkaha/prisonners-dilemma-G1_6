package fr.uga.l3miage.pc.prisonersdilemma.mappers;

import fr.uga.l3miage.pc.prisonersdilemma.models.Tour;
import fr.uga.l3miage.pc.prisonersdilemma.responses.TourResponseDTO;

public class TourMapper {
    private TourMapper() {
    }
    public static TourResponseDTO toTourResponseDTO(Tour tour){
        return TourResponseDTO.builder()
                .id(tour.getId())
                .decisionJoueur1(tour.getDecisionJoueur1().toString())
                .decisionJoueur2(tour.getDecisionJoueur2().toString())
                .build();
    }

    
}
