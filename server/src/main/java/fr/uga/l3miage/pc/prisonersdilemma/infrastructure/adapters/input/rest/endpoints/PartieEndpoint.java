package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.endpoints;

import org.springframework.web.bind.annotation.*;

import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.PartieCreationRequest;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.PartieJoinRequest;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.PartieResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.ScoreResponseDTO;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequestMapping("/api/parties")
public interface PartieEndpoint {

    @PostMapping("/create")
    PartieResponseDTO createPartie(@RequestBody PartieCreationRequest partieCreationRequest);

    @PatchMapping("/update")
    PartieResponseDTO updatePartie(@RequestBody PartieJoinRequest partieJoinRequest);

    @GetMapping("/score")
    public ScoreResponseDTO getScore();

}
