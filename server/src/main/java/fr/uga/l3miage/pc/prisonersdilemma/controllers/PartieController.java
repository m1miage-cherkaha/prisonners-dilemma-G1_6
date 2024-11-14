package fr.uga.l3miage.pc.prisonersdilemma.controllers;


import fr.uga.l3miage.pc.prisonersdilemma.services.PartieService;
import fr.uga.l3miage.pc.prisonnersdilemma.endpoints.PartieEndpoint;
import fr.uga.l3miage.pc.prisonnersdilemma.requests.PartieCreationRequest;
import fr.uga.l3miage.pc.prisonnersdilemma.requests.PartieJoinRequest;
import fr.uga.l3miage.pc.prisonnersdilemma.responses.PartieResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PartieController implements PartieEndpoint {
    private final PartieService partieService;

   @Override
   public PartieResponseDTO createPartie(PartieCreationRequest partieCreationRequest){
        return partieService.demarrerNouvellePartie(partieCreationRequest);
    }

    @Override
    public PartieResponseDTO updatePartie(Long idPartie, PartieJoinRequest partieJoinRequest) {
        return partieService.rejoindrePartie(idPartie, partieJoinRequest);
    }
}

