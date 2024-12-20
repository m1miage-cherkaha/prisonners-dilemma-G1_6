
package fr.uga.l3miage.pc.prisonersdilemma.services;

import fr.uga.l3miage.pc.prisonersdilemma.application.services.JoueurService;
import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.TypeStrategie;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.entities.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.repositories.JoueurRepository;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.output.persistence.repositories.PartieRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;




@ExtendWith(MockitoExtension.class)
class JoueurServiceTest {

    @Mock
    private JoueurRepository joueurRepository;

    @Mock
    private PartieRepository partieRepository;

    @InjectMocks
    private JoueurService joueurService;

    private Joueur joueur;

    @BeforeEach
    void setUp() {
        joueur = new Joueur();
        joueur.setId(1L);
        joueur.setNom("TestJoueur");
        joueur.setStrategie(TypeStrategie.TOUJOURS_COOPERER);
        joueur.setScore(100);
    }

    @Test
    void testCreateJoueur() {
        when(joueurRepository.save(any(Joueur.class))).thenReturn(joueur);

        Joueur createdJoueur = joueurService.createJoueur(joueur);

        assertNotNull(createdJoueur);
        assertEquals(joueur.getNom(), createdJoueur.getNom());
        verify(joueurRepository, times(1)).save(joueur);
    }

    @Test
    void testGetAllJoueurs() {
        List<Joueur> joueurs = Arrays.asList(joueur);
        when(joueurRepository.findAll()).thenReturn(joueurs);

        List<Joueur> result = joueurService.getAllJoueurs();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(joueurRepository, times(1)).findAll();
    }

    @Test
    void testGetJoueurById() {
        when(joueurRepository.findById(anyLong())).thenReturn(Optional.of(joueur));

        Joueur result = joueurService.getJoueurById(1L);

        assertNotNull(result);
        assertEquals(joueur.getNom(), result.getNom());
        verify(joueurRepository, times(1)).findById(1L);
    }

    @Test
    void testLeaveGame() {
        when(joueurRepository.findById(anyLong())).thenReturn(Optional.of(joueur));

        boolean result = joueurService.leaveGame(1L, "TOUJOURS_TRAHIR");

        assertTrue(result);
        assertEquals(TypeStrategie.TOUJOURS_TRAHIR, joueur.getStrategie());
        verify(joueurRepository, times(1)).findById(1L);
    }

    @Test
    void testGetScore() {
        when(joueurRepository.findById(anyLong())).thenReturn(Optional.of(joueur));

        int score = joueurService.getScore(1L);

        assertEquals(100, score);
        verify(joueurRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteAllJoueurs() {
        doNothing().when(partieRepository).deleteAll();
        doNothing().when(joueurRepository).deleteAll();

        joueurService.deleteAllJoueurs();

        verify(partieRepository, times(1)).deleteAll();
        verify(joueurRepository, times(1)).deleteAll();
    }
}