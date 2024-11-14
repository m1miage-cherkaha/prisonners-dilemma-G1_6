
package fr.uga.l3miage.pc.prisonersdilemma.services;
import fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategie;
import fr.uga.l3miage.pc.prisonersdilemma.mappers.PartieMapper;
import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.models.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.JoueurRepository;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.PartieRepository;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.TourRepository;
import fr.uga.l3miage.pc.prisonnersdilemma.requests.PartieCreationRequest;
import fr.uga.l3miage.pc.prisonnersdilemma.requests.PartieJoinRequest;
import fr.uga.l3miage.pc.prisonnersdilemma.responses.PartieResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import static fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategie.fromString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;




class PartieServiceTest {

    @Mock
    private JoueurRepository joueurRepository;

    @Mock
    private PartieRepository partieRepository;

    @Mock
    private TourRepository tourRepository;

    @Mock
    private TourService tourService;

    @InjectMocks
    private PartieService partieService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void demarrerNouvellePartie_shouldCreateAndReturnPartie() {
        PartieCreationRequest request = new PartieCreationRequest("", 0, "");
        request.setNomJoueur1("Joueur1");
        request.setStrategieJoueur1("TOUJOURS_COOPERER");
        request.setNbTours(5);

        Joueur joueur = new Joueur("Joueur1");
        Partie partie = new Partie(joueur, new Joueur("unknown"), 5);
        partie.getJoueur1().setStrategie(TypeStrategie.TOUJOURS_COOPERER);

        when(joueurRepository.findById(any())).thenReturn(Optional.of(joueur));
        when(partieRepository.save(any(Partie.class))).thenReturn(partie);

        PartieResponseDTO response = partieService.demarrerNouvellePartie(request);

        assertNotNull(response);
        assertEquals("Joueur1", joueurRepository.findById(response.getJoueur1Id()).orElseThrow().getNom());
        assertEquals(TypeStrategie.TOUJOURS_COOPERER, joueurRepository.findById(response.getJoueur1Id()).orElseThrow().getStrategie());
        verify(joueurRepository, times(1)).save(any(Joueur.class));
        verify(partieRepository, times(1)).save(any(Partie.class));
    }

    @Test
    void rejoindrePartie_shouldAddJoueur2ToPartie() {
        PartieJoinRequest request = new PartieJoinRequest("", "");
        request.setNomJoueur2("Joueur2");
        request.setStrategieJoueur2("TOUJOURS_TRAHIR");

        Joueur joueur1 = new Joueur("Joueur1");

        Joueur joueur2 = new Joueur("Joueur2");
        joueur2.setStrategie(fromString("TOUJOURS_TRAHIR"));
        Partie partieDejaExistante = new Partie(joueur1, new Joueur("unknown"), 5);

        when(partieRepository.findById(anyLong())).thenReturn(Optional.of(partieDejaExistante));
        when(joueurRepository.findById(any())).thenReturn(Optional.of(joueur2));

        PartieResponseDTO response = partieService.rejoindrePartie(1L, request);

        assertNotNull(response);
        assertEquals("Joueur2", joueurRepository.findById(response.getJoueur2Id()).orElseThrow().getNom());
        assertEquals(TypeStrategie.TOUJOURS_TRAHIR, joueurRepository.findById(response.getJoueur2Id()).orElseThrow().getStrategie());
        verify(partieRepository, times(1)).findById(anyLong());
        verify(joueurRepository, times(1)).save(any(Joueur.class));
        verify(partieRepository, times(1)).save(any(Partie.class));
    }

    @Test
    void rejoindrePartie_shouldThrowExceptionWhenPartieNotFound() {
        PartieJoinRequest request = new PartieJoinRequest("", "");
        request.setNomJoueur2("Joueur2");
        request.setStrategieJoueur2("TOUJOURS_TRAHIR");

        when(partieRepository.findById(anyLong())).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            partieService.rejoindrePartie(1L, request);
        });

        assertEquals("Partie non trouvée", exception.getMessage());
        verify(partieRepository, times(1)).findById(anyLong());
        verify(joueurRepository, times(0)).save(any(Joueur.class));
        verify(partieRepository, times(0)).save(any(Partie.class));
    }
}