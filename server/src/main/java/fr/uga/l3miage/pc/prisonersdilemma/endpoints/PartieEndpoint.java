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

    @PatchMapping("/update/{idPartie}")
    PartieResponseDTO updatePartie(@PathVariable Long idPartie, @RequestBody PartieJoinRequest partieJoinRequest);

    @GetMapping("/score")
    public int getScore();

    /*
     * Proposition
     * @GetMapping("/score")
     * public ScoreResponseDTO getScore();
     * 
     * @PostMapping('/player/{idPlayer}/leave')
     * public boolean leaveGame(@PathVariable LeaveRequestDTO body);
     * 
     * Class LeaveRequestDTO {
     *  private Long idPlayer;
     *  private String strategy; 
     * }
     * 
     * Class ScoreResponseDTO {
     *   private int scoreJoueur1;
     *   private int scoreJoueur2;
     * }
     */

}
