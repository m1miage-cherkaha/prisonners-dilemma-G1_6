package fr.uga.l3miage.pc.prisonersdilemma.controllers;

import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.services.JoueurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/joueurs")
public class JoueurController {

    private final JoueurService joueurService;

    public JoueurController(JoueurService joueurService) {
        this.joueurService = joueurService;
    }

    // Récupérer la liste des joueurs
    @GetMapping
    public ResponseEntity<List<Joueur>> getAllJoueurs() {
        return ResponseEntity.ok(joueurService.getAllJoueurs());
    }

    // Créer un nouveau joueur
    @PostMapping
    public ResponseEntity<Joueur> createJoueur(@RequestBody Joueur joueur) {
        return ResponseEntity.ok(joueurService.createJoueur(joueur));
    }

    // Récupérer un joueur par ID
    @GetMapping("/{id}")
    public ResponseEntity<Joueur> getJoueurById(@PathVariable Long id) {
        return ResponseEntity.ok(joueurService.getJoueurById(id));
    }
}
