package fr.uga.l3miage.pc.prisonersdilemma.endpoints;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.l3miage.pc.prisonersdilemma.requests.LeaveRequestDTO;
import fr.uga.l3miage.pc.prisonersdilemma.responses.JoueurReponseDTO;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/joueurs")
public interface JoueurEndpoints {
    @GetMapping("/players/all")
    public List<JoueurReponseDTO> getAllJoueurs();

    @PostMapping("/player/{idPlayer}")
    public JoueurReponseDTO getJoueurById(@PathVariable Long idPlayer);

    @PostMapping("/player/{idPlayer}/leave")
    public boolean leaveGame(@RequestBody LeaveRequestDTO body);
}
