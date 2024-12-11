package fr.uga.l3miage.pc.prisonersdilemma.controllers;

import fr.uga.l3miage.pc.prisonersdilemma.services.PartieService;
import fr.uga.l3miage.pc.prisonersdilemma.endpoints.TourEndpoints;
import fr.uga.l3miage.pc.prisonersdilemma.requests.TourRequestDTO;
import fr.uga.l3miage.pc.prisonersdilemma.responses.TourResponseDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TourController implements TourEndpoints {
    private final PartieService tourService;
    
    @Override
    public TourResponseDTO postFaireChoix(TourRequestDTO tour) {
        return tourService.jouerTour(tour);
    }
    

}
