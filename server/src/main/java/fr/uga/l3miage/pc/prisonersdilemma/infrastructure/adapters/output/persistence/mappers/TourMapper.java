package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.mappers;

import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.TourResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Tour;

public class TourMapper {
    private TourMapper() {
    }
    public static TourResponseDTO toTourResponseDTO(Tour tour){
        return TourResponseDTO.builder()
                .id(tour.getId())
                .status(tour.getStatus())
                .build();
    }

    
}
