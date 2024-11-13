package fr.uga.l3miage.pc.prisonersdilemma.controllers;

import fr.uga.l3miage.pc.prisonersdilemma.endpoints.TourEndpoint;
import fr.uga.l3miage.pc.prisonersdilemma.models.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.requests.TourRequest;
import fr.uga.l3miage.pc.prisonersdilemma.responses.PartieResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.responses.TourResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.services.PartieService;
import fr.uga.l3miage.pc.prisonersdilemma.services.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TourController implements TourEndpoint {
    private final PartieService partieService;
    private final TourService tourService;
    @Override
    public TourResponseDTO jouerTour(Long id, TourRequest tourRequest){
        Partie partie = partieService.getPartie(id);
        return partieService.jouerTour(partie, tourRequest );
    };

}
