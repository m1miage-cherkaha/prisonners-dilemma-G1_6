package fr.uga.l3miage.pc.prisonersdilemma.endpoints;

import org.springframework.web.bind.annotation.*;

import fr.uga.l3miage.pc.prisonersdilemma.requests.PartieCreationRequest;
import fr.uga.l3miage.pc.prisonersdilemma.requests.PartieJoinRequest;
import fr.uga.l3miage.pc.prisonersdilemma.responses.PartieResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.responses.ScoreResponseDTO;

@RestController
@RequestMapping("/api/parties")
public interface PartieEndpoint {

    @PostMapping("/create")
    PartieResponseDTO createPartie(@RequestBody PartieCreationRequest partieCreationRequest);

    @PatchMapping("/update")
    PartieResponseDTO updatePartie(@RequestBody PartieJoinRequest partieJoinRequest);

    @GetMapping("/score")
    public ScoreResponseDTO getScore();

}
