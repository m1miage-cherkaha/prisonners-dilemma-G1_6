package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.pc.prisonersdilemma.application.services.PartieService;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.endpoints.TourEndpoints;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.TourRequestDTO;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.TourResponseDTO;


@RestController
@RequestMapping("/api/tours")
public class TourController implements TourEndpoints {
    private final PartieService tourService;
    
    public TourController(PartieService tourService) {
        this.tourService = tourService;
    }
    @Override
    public TourResponseDTO postFaireChoix(TourRequestDTO tour) {
        return tourService.jouerTour(tour);
    }
    

}
