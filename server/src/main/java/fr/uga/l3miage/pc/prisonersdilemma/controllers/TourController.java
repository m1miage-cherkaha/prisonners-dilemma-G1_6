package fr.uga.l3miage.pc.prisonersdilemma.controllers;

import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.pc.prisonersdilemma.services.PartieService;
import fr.uga.l3miage.pc.prisonersdilemma.services.TourService;
import fr.uga.l3miage.pc.prisonersdilemma.endpoints.TourEndpoints;
import fr.uga.l3miage.pc.prisonersdilemma.requests.TourRequest;
import fr.uga.l3miage.pc.prisonersdilemma.responses.TourResponseDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TourController implements TourEndpoints {
    private final PartieService tourService;
    
    @Override
    public TourResponseDTO postNewTour(TourRequest tour) {
        return tourService.jouerTour(tour);
    }
    

}
