package fr.uga.l3miage.pc.prisonnersdilemma.endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.pc.prisonnersdilemma.requests.TourRequest;
import fr.uga.l3miage.pc.prisonnersdilemma.responses.TourResponseDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/tours")
public interface TourEndpoints {
    @PostMapping("/play")
    TourResponseDTO postTour(@RequestBody TourRequest tour);
    
}
