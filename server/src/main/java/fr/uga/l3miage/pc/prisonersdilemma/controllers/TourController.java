package fr.uga.l3miage.pc.prisonersdilemma.controllers;

import fr.uga.l3miage.pc.prisonersdilemma.services.PartieService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.pc.prisonersdilemma.endpoints.TourEndpoints;
import fr.uga.l3miage.pc.prisonersdilemma.requests.TourRequestDTO;
import fr.uga.l3miage.pc.prisonersdilemma.responses.TourResponseDTO;


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
