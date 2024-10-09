package fr.uga.l3miage.pc.prisonersdilemma.services;

import fr.uga.l3miage.pc.prisonersdilemma.models.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.models.strategies.*;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.PartieRepository;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.JoueurRepository;
import org.springframework.stereotype.Service;
import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;

import java.util.Optional;

@Service
public class PartieService {
    private final JoueurRepository joueurRepository;
    private final PartieRepository partieRepository;

    public PartieService(JoueurRepository joueurRepository, PartieRepository partieRepository) {
        this.joueurRepository = joueurRepository;
        this.partieRepository = partieRepository;
    }

    public Partie demarrerNouvellePartie(Long joueur1Id, Long joueur2Id, int nbTours) {
        Optional<Joueur> joueur1 = joueurRepository.findById(joueur1Id);
        Optional<Joueur> joueur2 = joueurRepository.findById(joueur2Id);

        if (joueur1.isPresent() && joueur2.isPresent()) {
            Partie nouvellePartie = new Partie(joueur1.get(), joueur2.get(), nbTours);
            return partieRepository.save(nouvellePartie);
        } else {
            throw new IllegalArgumentException("Joueurs non trouvés");
        }
    }

    public void joueurAbandonne(Partie partie, Long joueurId, String strategieChoisie) {
        Strategie strategieServeur = choisirStrategie(strategieChoisie);

        // Si c'est joueur1 qui abandonne
        if (partie.getJoueur1().getId().equals(joueurId)) {
            partie.setStrategieJoueur1(strategieServeur);
        } else {
            // Si c'est joueur2 qui abandonne
            partie.setStrategieJoueur2(strategieServeur);
        }
    }
    private Strategie choisirStrategie(String strategieChoisie) {
        switch (strategieChoisie.toLowerCase()) {
            case "toujours_cooperer":
                return new CoopererStrategie();
            case "toujours_trahir":
                return new TrahirStrategie();
            case "donnant_donnant":
                return new DonnantDonnantStrategie();
            case "rancunier":
                return new RancunierStrategie();
            case "aleatoire":
                return new AleatoireStrategie();
            default:
                throw new IllegalArgumentException("Stratégie non reconnue : " + strategieChoisie);
        }
    }
    public void jouerTour(Partie partie, String choixJoueur1, String choixJoueur2) {
        partie.getJoueur1().setChoix(choixJoueur1);
        partie.getJoueur2().setChoix(choixJoueur2);

        // Calcul du score
        if (choixJoueur1.equals("c") && choixJoueur2.equals("c")) {
            partie.getJoueur1().ajouterPoints(3);
            partie.getJoueur2().ajouterPoints(3);
        } else if (choixJoueur1.equals("t") && choixJoueur2.equals("t")) {
            partie.getJoueur1().ajouterPoints(1);
            partie.getJoueur2().ajouterPoints(1);
        } else if (choixJoueur1.equals("t") && choixJoueur2.equals("c")) {
            partie.getJoueur1().ajouterPoints(5);
            partie.getJoueur2().ajouterPoints(0);
        } else if (choixJoueur1.equals("c") && choixJoueur2.equals("t")) {
            partie.getJoueur1().ajouterPoints(0);
            partie.getJoueur2().ajouterPoints(5);
        }

        // Mettre à jour les joueurs dans la base de données
        joueurRepository.save(partie.getJoueur1());
        joueurRepository.save(partie.getJoueur2());
    }

    public Partie getPartie(Long partieId) {
        return partieRepository.findById(partieId).orElseThrow(() -> new IllegalArgumentException("Partie non trouvée"));
    }
}
