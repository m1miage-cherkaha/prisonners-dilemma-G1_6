package fr.uga.l3miage.pc.prisonersdilemma.services;

import fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategie;
import fr.uga.l3miage.pc.prisonersdilemma.models.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.models.Tour;
import fr.uga.l3miage.pc.prisonersdilemma.models.strategies.*;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.PartieRepository;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.JoueurRepository;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.TourRepository;
import fr.uga.l3miage.pc.prisonersdilemma.requests.PartieCreationRequest;
import fr.uga.l3miage.pc.prisonersdilemma.requests.PartieJoinRequest;
import fr.uga.l3miage.pc.prisonersdilemma.requests.TourRequest;
import fr.uga.l3miage.pc.prisonersdilemma.responses.PartieResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.responses.TourResponseDTO;
import org.springframework.stereotype.Service;
import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;

import java.util.Optional;

import static fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategie.*;

@Service
public class PartieService {
    private final JoueurRepository joueurRepository;
    private final PartieRepository partieRepository;
    private final TourRepository tourRepository;

    private final TourService tourService;

    public PartieService(JoueurRepository joueurRepository, PartieRepository partieRepository, TourRepository tourRepository, TourService tourService) {
        this.joueurRepository = joueurRepository;
        this.partieRepository = partieRepository;
        this.tourRepository = tourRepository;
        this.tourService = tourService;

    }

//    public Partie demarrerNouvellePartie(Long joueur1Id, Long joueur2Id, int nbTours) {
//        Optional<Joueur> joueur1 = joueurRepository.findById(joueur1Id);
//        Optional<Joueur> joueur2 = joueurRepository.findById(joueur2Id);
//
//        if (joueur1.isPresent() && joueur2.isPresent()) {
//            Partie nouvellePartie = new Partie(joueur1.get(), joueur2.get(), nbTours);
//            return partieRepository.save(nouvellePartie);
//        } else {
//            throw new IllegalArgumentException("Joueurs non trouvés");
//        }
//    }

    public PartieResponseDTO demarrerNouvellePartie(PartieCreationRequest partieCreationRequest){
        Joueur joueur1 = new Joueur(partieCreationRequest.getNomJoueur1());
        joueurRepository.save(joueur1);

        Strategie strategieJoueur1 = choisirStrategie(partieCreationRequest.getStrategieJoueur1());

        Partie nouvellePartie = new Partie(joueur1,null,partieCreationRequest.getNbTours());
        nouvellePartie.setStrategieJoueur1(strategieJoueur1);

        Partie savedPartie = partieRepository.save(nouvellePartie);

        return new PartieResponseDTO(savedPartie);

    }
    public PartieResponseDTO rejoindrePartie(Long id, PartieJoinRequest partieJoinRequest){
        Partie partie = partieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Partie non trouvée"));

        Joueur joueur2 =  new Joueur(partieJoinRequest.getNomJoueur2());
        joueurRepository.save(joueur2);
        Strategie strategieJoueur2 = choisirStrategie(partieJoinRequest.getStrategieJoueur2());

        partie.setStrategieJoueur2(strategieJoueur2);
        partie.setJoueur2(joueur2);

        partieRepository.save(partie);

        return null;
    }
//    public void joueurAbandonne(Partie partie, Long joueurId, String strategieChoisie) {
//        Strategie strategieServeur = choisirStrategie(strategieChoisie);
//
//        // Si c'est joueur1 qui abandonne
//        if (partie.getJoueur1().getId().equals(joueurId)) {
//            partie.setStrategieJoueur1(strategieServeur);
//        } else {
//            // Si c'est joueur2 qui abandonne
//            partie.setStrategieJoueur2(strategieServeur);
//        }
//    }
    private Strategie choisirStrategie(TypeStrategie strategieChoisie) {
        switch (strategieChoisie) {
            case TOUJOURS_COOPERER:
                return new CoopererStrategie();
            case TOUJOURS_TRAHIR:
                return new TrahirStrategie();
            case DONNANT_DONNANT:
                return new DonnantDonnantStrategie();
            case RANCUNIER:
                return new RancunierStrategie();
            case ALEATOIRE:
                return new AleatoireStrategie();
            default:
                throw new IllegalArgumentException("Stratégie non reconnue : " + strategieChoisie);
        }
    }

    public TourResponseDTO jouerTour(Partie partie , TourRequest tourRequest){
        // vérifier si le nombre de tours a été atteint
        //ICI

        // Appeler TourService pour initialiser un nouveau tour
        Tour tour = tourService.demarrerNouveauTour(partie);

        // Appliquer les décisions des joueurs et calculer les points
        tour = tourService.calculerPoints(tour, tourRequest.getDecisionJoueur1(), tourRequest.getDecisionJoueur2());

        // Mettre à jour les scores de la partie
        partie.setScoreJoueur1(partie.getScoreJoueur1() + tour.getPointJoueur1());
        partie.setScoreJoueur2(partie.getScoreJoueur2() + tour.getPointJoueur2());

        // Ajouter le tour à la partie
        partie.getTours().add(tour);

        // Sauvegarder le tour et la partie
        tourRepository.save(tour);
        partieRepository.save(partie);

        return new TourResponseDTO(tour);


    }
//    public void jouerTour(Partie partie, String choixJoueur1, String choixJoueur2) {
//        partie.getJoueur1().setChoix(choixJoueur1);
//        partie.getJoueur2().setChoix(choixJoueur2);
//
//        // Calcul du score
//        if (choixJoueur1.equals("c") && choixJoueur2.equals("c")) {
//            partie.getJoueur1().ajouterPoints(3);
//            partie.getJoueur2().ajouterPoints(3);
//        } else if (choixJoueur1.equals("t") && choixJoueur2.equals("t")) {
//            partie.getJoueur1().ajouterPoints(1);
//            partie.getJoueur2().ajouterPoints(1);
//        } else if (choixJoueur1.equals("t") && choixJoueur2.equals("c")) {
//            partie.getJoueur1().ajouterPoints(5);
//            partie.getJoueur2().ajouterPoints(0);
//        } else if (choixJoueur1.equals("c") && choixJoueur2.equals("t")) {
//            partie.getJoueur1().ajouterPoints(0);
//            partie.getJoueur2().ajouterPoints(5);
//        }
//
//        // Mettre à jour les joueurs dans la base de données
//        joueurRepository.save(partie.getJoueur1());
//        joueurRepository.save(partie.getJoueur2());
//    }

    public Partie getPartie(Long partieId) {
        return partieRepository.findById(partieId).orElseThrow(() -> new IllegalArgumentException("Partie non trouvée"));
    }
}
