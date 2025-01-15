package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.pc.prisonersdilemma.application.services.PartieService;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.endpoints.PartieEndpoint;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.PartieCreationRequest;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.PartieJoinRequest;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.PartieResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.ScoreResponseDTO;


@RestController
@RequestMapping("/api/parties")
public class PartieController implements PartieEndpoint {
    private final PartieService partieService;

    public PartieController(PartieService partieService) {
        this.partieService = partieService;
    }
   @Override
   public PartieResponseDTO createPartie(PartieCreationRequest partieCreationRequest){
        return partieService.demarrerNouvellePartie(partieCreationRequest);
    }

    @Override
    public ScoreResponseDTO getScore() {
        return partieService.getScore();
    }

    @Override
    public PartieResponseDTO updatePartie(PartieJoinRequest partieJoinRequest) {
        return partieService.rejoindrePartie(partieJoinRequest);
    }
}

