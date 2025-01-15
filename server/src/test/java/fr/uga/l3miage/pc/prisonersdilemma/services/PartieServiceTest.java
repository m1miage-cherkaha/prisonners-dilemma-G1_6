
package fr.uga.l3miage.pc.prisonersdilemma.services;

import fr.uga.l3miage.pc.prisonersdilemma.application.services.PartieService;
import fr.uga.l3miage.pc.prisonersdilemma.application.services.TourService;
import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.PartieCreationRequest;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.PartieJoinRequest;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.TourRequestDTO;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.PartieResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.ScoreResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.TourResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Tour;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.repositories.JoueurRepository;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.repositories.PartieRepository;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.repositories.TourRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;





class PartieServiceTest {

    @Mock
    private TourService tourService;

    @Mock
    private JoueurRepository joueurRepository;

    @Mock
    private PartieRepository partieRepository;

    @Mock
    private TourRepository tourRepository;

    @InjectMocks
    private PartieService partieService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDemarrerNouvellePartie() {
        PartieCreationRequest request = new PartieCreationRequest("Player1", 5);

        Joueur joueur1 = new Joueur("Player1");
        joueur1.setNom("Player1");
        Partie nouvellePartie = new Partie(joueur1, new Joueur("unknown"), 5);

        when(joueurRepository.save(any(Joueur.class))).thenReturn(joueur1);
        when(partieRepository.save(any(Partie.class))).thenReturn(nouvellePartie);

        PartieResponseDTO response = partieService.demarrerNouvellePartie(request);

        Optional<Joueur> joueurExpected = joueurRepository.findById((Long)response.getId());
        if(joueurExpected.isPresent()){
            assertEquals("Player1", joueurExpected.get().getNom());
        }
        verify(joueurRepository, times(2)).save(any(Joueur.class));
        verify(partieRepository, times(1)).save(any(Partie.class));
    }

    @Test
    void testRejoindrePartie() {
        PartieJoinRequest request = new PartieJoinRequest("joueur2");
        request.setNomJoueur2("Player2");

        Partie partie = new Partie(new Joueur("Player1"), new Joueur("unknown"), 5);
        List<Partie> parties = new ArrayList<>();
        parties.add(partie);

        when(partieRepository.findAll()).thenReturn(parties);
        when(joueurRepository.save(any(Joueur.class))).thenReturn(new Joueur("Player2"));
        when(partieRepository.save(any(Partie.class))).thenReturn(partie);

        PartieResponseDTO response = partieService.rejoindrePartie(request);

        Optional<Joueur> joueurExpected = joueurRepository.findById((Long)response.getId());
        if(joueurExpected.isPresent()){
            assertEquals("Player2", joueurExpected.get().getNom());
        }
        verify(joueurRepository, times(1)).save(any(Joueur.class));
        verify(partieRepository, times(1)).save(any(Partie.class));
    }

    @Test
    void testJouerTour() {
        TourRequestDTO request = new TourRequestDTO(1L, "COOPERATE", false);

        Joueur joueur1 = new Joueur("Player1");
        Partie partie = new Partie(joueur1, new Joueur("Player2"), 5);
        partie.setTours(new LinkedList<>());

        List<Partie> parties = new ArrayList<>();
        parties.add(partie);

        when(partieRepository.findAll()).thenReturn(parties);
        when(tourRepository.save(any(Tour.class))).thenReturn(new Tour());
        when(tourService.calculerPoints(any(Tour.class), any(Decision.class), any(Decision.class))).thenReturn(new Tour());

        TourResponseDTO response = partieService.jouerTour(request);

        assertEquals("EN_COURS", response.getStatus());
        verify(tourRepository, times(1)).save(any(Tour.class));
        verify(partieRepository, times(1)).save(any(Partie.class));
    }

    @Test
    void testGetScore() {
        Joueur joueur1 = new Joueur("Player1");
        joueur1.setScore(10);
        Joueur joueur2 = new Joueur("Player2");
        joueur2.setScore(15);

        Partie partie = new Partie(joueur1, joueur2, 5);
        List<Partie> parties = new ArrayList<>();
        parties.add(partie);

        when(partieRepository.findAll()).thenReturn(parties);

        ScoreResponseDTO response = partieService.getScore();

        assertEquals(10, response.getScoreJoueur1());
        assertEquals(15, response.getScoreJoueur2());
    }
}