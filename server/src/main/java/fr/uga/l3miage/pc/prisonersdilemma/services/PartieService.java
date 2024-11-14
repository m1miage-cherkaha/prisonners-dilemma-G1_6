package fr.uga.l3miage.pc.prisonersdilemma.services;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategie;
import fr.uga.l3miage.pc.prisonersdilemma.mappers.PartieMapper;
import fr.uga.l3miage.pc.prisonersdilemma.mappers.TourMapper;
import fr.uga.l3miage.pc.prisonersdilemma.models.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.models.Tour;
import fr.uga.l3miage.pc.prisonersdilemma.models.strategies.*;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.PartieRepository;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.JoueurRepository;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.TourRepository;
import fr.uga.l3miage.pc.prisonnersdilemma.requests.PartieCreationRequest;
import fr.uga.l3miage.pc.prisonnersdilemma.requests.PartieJoinRequest;
import fr.uga.l3miage.pc.prisonnersdilemma.requests.TourRequest;
import fr.uga.l3miage.pc.prisonnersdilemma.responses.PartieResponseDTO;
import fr.uga.l3miage.pc.prisonnersdilemma.responses.TourResponseDTO;

import org.springframework.stereotype.Service;
import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;

import java.lang.reflect.Type;
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

    public PartieResponseDTO demarrerNouvellePartie(PartieCreationRequest partieCreationRequest){
        Joueur joueur1 = new Joueur(partieCreationRequest.getNomJoueur1());
        joueurRepository.save(joueur1);

        TypeStrategie strategieJoueur1 = choisirStrategie(partieCreationRequest.getStrategieJoueur1());

        Partie nouvellePartie = new Partie(joueur1,new Joueur("unknown"),partieCreationRequest.getNbTours());
        nouvellePartie.getJoueur1().setStrategie(strategieJoueur1);

        partieRepository.save(nouvellePartie);

        return PartieMapper.toPartieResponseDTO(nouvellePartie);

    }
    public PartieResponseDTO rejoindrePartie(Long id, PartieJoinRequest partieJoinRequest){
        Partie partie = partieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Partie non trouvée"));

        Joueur joueur2 =  new Joueur(partieJoinRequest.getNomJoueur2());
        TypeStrategie strategieJoueur2 = choisirStrategie(partieJoinRequest.getStrategieJoueur2());

        partie.getJoueur2().setStrategie(strategieJoueur2);
        partie.setJoueur2(joueur2);

        partieRepository.save(partie);
        joueurRepository.save(joueur2);

        return PartieMapper.toPartieResponseDTO(partie);
    }
    private TypeStrategie choisirStrategie(String strategieChoisie) {
        switch (strategieChoisie) {
            case "TOUJOURS_COOPERER":
                return TypeStrategie.TOUJOURS_COOPERER;
            case "TOUJOURS_TRAHIR":
                return TypeStrategie.TOUJOURS_TRAHIR;
            case "DONNANT_DONNANT":
                return TypeStrategie.DONNANT_DONNANT;
            case "RANCUNIER":
                return TypeStrategie.RANCUNIER;
            case "ALEATOIRE":
                return TypeStrategie.ALEATOIRE;
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
        tour = tourService.calculerPoints(tour, Decision.fromString(tourRequest.getDecisionJoueur1()),Decision.fromString(tourRequest.getDecisionJoueur2()));

        // Mettre à jour les scores de la partie
        partie.getJoueur1().ajouterPoints(tour.getPointJoueur1());
        partie.getJoueur2().ajouterPoints(tour.getPointJoueur2());

        // Ajouter le tour à la partie
        partie.getTours().add(tour);

        // Sauvegarder le tour et la partie
        tourRepository.save(tour);
        partieRepository.save(partie);

        return TourMapper.toTourResponseDTO(tour);


    }
}
