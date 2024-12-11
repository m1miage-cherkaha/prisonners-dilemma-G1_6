package fr.uga.l3miage.pc.prisonersdilemma.controllers;

import fr.uga.l3miage.pc.prisonersdilemma.endpoints.JoueurEndpoints;
import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.requests.LeaveRequestDTO;
import fr.uga.l3miage.pc.prisonersdilemma.responses.JoueurReponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.services.JoueurService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/joueurs")
public class JoueurController implements JoueurEndpoints {

    private final JoueurService joueurService;

    public JoueurController(JoueurService joueurService) {
        this.joueurService = joueurService;
    }

    // Récupérer la liste des joueurs
    public List<JoueurReponseDTO> getAllJoueurs() {
        List<JoueurReponseDTO> joueurs = new ArrayList<>();
        for(Joueur joueur : joueurService.getAllJoueurs()){
            joueurs.add(new JoueurReponseDTO(joueur.getId(), joueur.getNom(), joueur.getScore()));
        }
        return joueurs;
    }

    // Récupérer un joueur par ID
    public JoueurReponseDTO getJoueurById(@PathVariable Long idPlayer) {
        return new JoueurReponseDTO(joueurService.getJoueurById(idPlayer).getId(), joueurService.getJoueurById(idPlayer).getNom(), joueurService.getJoueurById(idPlayer).getScore());
    }

    @Override
    public boolean leaveGame(LeaveRequestDTO body) {
        return joueurService.leaveGame(body.getId(), body.getStrategy());
    }
}
