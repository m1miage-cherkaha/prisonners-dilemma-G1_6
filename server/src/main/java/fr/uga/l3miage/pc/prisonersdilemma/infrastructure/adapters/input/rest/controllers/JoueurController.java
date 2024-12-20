package fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.controllers;

import fr.uga.l3miage.pc.prisonersdilemma.application.services.JoueurService;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.endpoints.JoueurEndpoints;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.LeaveRequestDTO;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.JoueurReponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Joueur;

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
    public int getScore(@PathVariable Long idPlayer) {
        return joueurService.getScore(idPlayer);
    }

    @Override
    public void deleteAllJoueurs() {
        joueurService.deleteAllJoueurs();
    }
    
}
