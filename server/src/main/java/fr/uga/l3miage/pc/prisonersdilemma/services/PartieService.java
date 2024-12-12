package fr.uga.l3miage.pc.prisonersdilemma.services;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.mappers.PartieMapper;
import fr.uga.l3miage.pc.prisonersdilemma.mappers.TourMapper;
import fr.uga.l3miage.pc.prisonersdilemma.models.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.models.Tour;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.PartieRepository;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.JoueurRepository;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.TourRepository;
import fr.uga.l3miage.pc.prisonersdilemma.requests.PartieCreationRequest;
import fr.uga.l3miage.pc.prisonersdilemma.requests.PartieJoinRequest;
import fr.uga.l3miage.pc.prisonersdilemma.requests.TourRequestDTO;
import fr.uga.l3miage.pc.prisonersdilemma.responses.PartieResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.responses.ScoreResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.responses.TourResponseDTO;

import org.springframework.stereotype.Service;
import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;

@Service
public class PartieService {
    private final TourService tourService;

    private final JoueurRepository joueurRepository;
    private final PartieRepository partieRepository;
    private final TourRepository tourRepository;

    public PartieService(TourService tourService, JoueurRepository joueurRepository, PartieRepository partieRepository, TourRepository tourRepository) {
        this.tourService = tourService;
        this.joueurRepository = joueurRepository;
        this.partieRepository = partieRepository;
        this.tourRepository = tourRepository;

    }

    public PartieResponseDTO demarrerNouvellePartie(PartieCreationRequest partieCreationRequest){
        Joueur joueur1 = new Joueur(partieCreationRequest.getNomJoueur1());
        joueurRepository.save(joueur1);

        Partie nouvellePartie = new Partie(joueur1,new Joueur("unknown"),partieCreationRequest.getNbTours());
        partieRepository.save(nouvellePartie);
        nouvellePartie.getJoueur1();

        return PartieMapper.toPartieResponseDTO(nouvellePartie);

    }
    public PartieResponseDTO rejoindrePartie(PartieJoinRequest partieJoinRequest){
        Partie partie = partieRepository.findAll().get(0);

        Joueur joueur2 =  new Joueur(partieJoinRequest.getNomJoueur2());
        partie.setJoueur2(joueur2);

        partieRepository.save(partie);
        joueurRepository.save(joueur2);

        return PartieMapper.toPartieResponseDTO(partie);
    }

    public TourResponseDTO jouerTour(TourRequestDTO tourRequestDTO){
        //si le dernier tour enregistré dans la dernière partie a pour statut "FINI" alors on crée un nouveau tour
        //sinon on met à jour le dernier tour
        // on calcule les points des joueurs et on met à jour les scores dans la partie et les points dans l'entity tour et dans les repo
        Partie partie = partieRepository.findAll().get(0);
        Joueur joueur1 = partie.getJoueur1();
        Tour tour = new Tour();
        if(partie.getTours().size()!=0 && partie.getTours().getLast().getStatus().equals("EN_COURS")){
            tour = partie.getTours().getLast();
            tour.setStatus("FINI");
            if(tourRequestDTO.getIdJoueur().equals(joueur1.getId())){
                tour.setDecisionJoueur1(Decision.valueOf(tourRequestDTO.getDecisionJoueur1()));
            }else{
                tour.setDecisionJoueur2(Decision.valueOf(tourRequestDTO.getDecisionJoueur1()));
            }
            tour = tourService.calculerPoints(tour, tour.getDecisionJoueur1(), tour.getDecisionJoueur2());
            tourRepository.save(tour);
            partie.getTours().add(tour);
            partieRepository.save(partie);
            return TourMapper.toTourResponseDTO(tour);
        }else{
            tour.setStatus("EN_COURS");
            tourRepository.save(tour);
            partie.getTours().add(tour);
            partieRepository.save(partie);
            return TourMapper.toTourResponseDTO(tour);
        }
    }

    public ScoreResponseDTO getScore() {
        return ScoreResponseDTO.builder()
                .scoreJoueur1(partieRepository.findAll().get(0).getJoueur1().getScore())
                .scoreJoueur2(partieRepository.findAll().get(0).getJoueur2().getScore())
                .build();
    }
}
