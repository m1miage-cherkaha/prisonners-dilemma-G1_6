package fr.uga.l3miage.pc.prisonersdilemma.endpoints;

import fr.uga.l3miage.pc.prisonersdilemma.requests.PartieCreationRequest;
import fr.uga.l3miage.pc.prisonersdilemma.requests.PartieJoinRequest;
import fr.uga.l3miage.pc.prisonersdilemma.responses.PartieResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parties")
public interface PartieEndpoint {

    @PostMapping("/create")
    PartieResponseDTO createPartie(@RequestBody PartieCreationRequest partieCreationRequest);

    @PatchMapping("/update/{idPartie}")
    PartieResponseDTO updatePartie(@PathVariable Long idPartie, @RequestBody PartieJoinRequest partieJoinRequest);
}
