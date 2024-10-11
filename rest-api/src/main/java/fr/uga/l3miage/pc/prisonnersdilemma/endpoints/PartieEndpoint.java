package fr.uga.l3miage.pc.prisonnersdilemma.endpoints;

import org.springframework.web.bind.annotation.*;

import fr.uga.l3miage.pc.prisonnersdilemma.requests.PartieCreationRequest;
import fr.uga.l3miage.pc.prisonnersdilemma.requests.PartieJoinRequest;
import fr.uga.l3miage.pc.prisonnersdilemma.responses.PartieResponseDTO;

@RestController
@RequestMapping("/api/parties")
public interface PartieEndpoint {

    @PostMapping("/create")
    PartieResponseDTO createPartie(@RequestBody PartieCreationRequest partieCreationRequest);

    @PatchMapping("/update/{idPartie}")
    PartieResponseDTO updatePartie(@PathVariable Long idPartie, @RequestBody PartieJoinRequest partieJoinRequest);

}
