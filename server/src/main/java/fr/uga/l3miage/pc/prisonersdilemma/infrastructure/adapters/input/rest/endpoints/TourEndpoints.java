package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.*;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequestMapping("/api/tours")
public interface TourEndpoints {
    @PostMapping("/play")
    TourResponseDTO postFaireChoix(@RequestBody TourRequestDTO body);
    
}
