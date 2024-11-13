package fr.uga.l3miage.pc.prisonersdilemma.endpoints;

import fr.uga.l3miage.pc.prisonersdilemma.requests.TourRequest;
import fr.uga.l3miage.pc.prisonersdilemma.responses.PartieResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.responses.TourResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parties/{partieId}/tours")
public interface TourEndpoint {
//    @PostMapping
//    public TourResponseDTO jouerTour(@PathVariable Long partieId, @RequestBody TourRequest tourRequest);

    // GetIdTour
}
