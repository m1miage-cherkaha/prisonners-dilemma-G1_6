package fr.uga.l3miage.pc.prisonersdilemma.endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.pc.prisonersdilemma.requests.*;
import fr.uga.l3miage.pc.prisonersdilemma.responses.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/tours")
public interface TourEndpoints {
    @PostMapping("/play")
    TourResponseDTO postNewTour(@RequestBody TourRequest tour);
    
    /*
     * Proposition
     *  @PostMapping("/round")
        TourWaitingResponseDTO postNewTour();
    
        @PostMapping("/round/{idTour}/decisions")
        TourWaitingResponseDTO postFaireChoix(@ChoiceRequestDTO body);

        @GetMapping("/round/{idTour}/results")
        public ResultResponseDTO getResults();
        

    
        Class TourWaitingResponseDTO {
            private Long idTour;
            private int roundNumber;
            private String Status; //"not started yet", "waiting for reponse(s)" or "playing"
        }
        Class ChoiceRequestDTO {
            private Long idJoueur;
            private String choice;
        }
        Class ResultResponseDTO {
            private Long idTour;
            private int resultJoueur1;
            private int resultJoueur2;
            private String choixJoueur1;
            private String choixJoueur2;
        }

     */

}
