package fr.uga.l3miage.pc.prisonersdilemma.controllers;


import fr.uga.l3miage.pc.prisonersdilemma.models.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.services.PartieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parties")
public class PartieController {
    private final PartieService partieService;

    public PartieController(PartieService partieService) {
        this.partieService = partieService;
    }

    @PostMapping("/nouvelle")
    public ResponseEntity<Partie> demarrerNouvellePartie(@RequestParam Long joueur1Id, @RequestParam Long joueur2Id, @RequestParam int nbTours) {
        Partie partie = partieService.demarrerNouvellePartie(joueur1Id, joueur2Id, nbTours);
        return ResponseEntity.ok(partie);
    }

    @PostMapping("/{id}/tour")
    public ResponseEntity<?> jouerTour(@PathVariable Long id, @RequestParam String choixJoueur1, @RequestParam String choixJoueur2) {
        Partie partie = partieService.getPartie(id);
        partieService.jouerTour(partie, choixJoueur1, choixJoueur2);
        return ResponseEntity.ok("Tour joué");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partie> getPartie(@PathVariable Long id) {
        Partie partie = partieService.getPartie(id);
        return ResponseEntity.ok(partie);
    }
    @PostMapping("/{partieId}/abandon")
    public ResponseEntity<?> joueurAbandonne(
            @PathVariable Long partieId,
            @RequestParam Long joueurId,
            @RequestParam String strategieChoisie) {

        Partie partie = partieService.getPartie(partieId);
        partieService.joueurAbandonne(partie, joueurId, strategieChoisie);
        return ResponseEntity.ok("Le joueur a abandonné et la stratégie " + strategieChoisie + " est appliquée.");
    }
}

