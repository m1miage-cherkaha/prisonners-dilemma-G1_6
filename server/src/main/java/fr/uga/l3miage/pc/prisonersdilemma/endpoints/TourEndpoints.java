package fr.uga.l3miage.pc.prisonersdilemma.endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.pc.prisonersdilemma.requests.*;
import fr.uga.l3miage.pc.prisonersdilemma.responses.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/tours")
public interface TourEndpoints {
    @PostMapping("/play")
    TourResponseDTO postFaireChoix(@RequestBody TourRequestDTO body);

}
