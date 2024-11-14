package fr.uga.l3miage.pc.prisonersdilemma.services;

import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.JoueurRepository;
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
public class JoueurServiceTest {

    @Mock
    private JoueurRepository joueurRepository;

    @InjectMocks
    private JoueurService joueurService;

    private Joueur joueur;

    @BeforeEach
    void setUp() {
        joueur = new Joueur();
        joueur.setId(1L);
        joueur.setNom("Test Joueur");
    }

    @Test
    void testCreateJoueur() {
        when(joueurRepository.save(any(Joueur.class))).thenReturn(joueur);

        Joueur createdJoueur = joueurService.createJoueur(joueur);

        assertNotNull(createdJoueur);
        assertEquals(joueur.getId(), createdJoueur.getId());
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
        assertEquals(joueur.getId(), result.get(0).getId());
        verify(joueurRepository, times(1)).findAll();
    }

    @Test
    void testGetJoueurById() {
        when(joueurRepository.findById(anyLong())).thenReturn(Optional.of(joueur));

        Joueur foundJoueur = joueurService.getJoueurById(1L);

        assertNotNull(foundJoueur);
        assertEquals(joueur.getId(), foundJoueur.getId());
        assertEquals(joueur.getNom(), foundJoueur.getNom());
        verify(joueurRepository, times(1)).findById(1L);
    }

    @Test
    void testGetJoueurByIdNotFound() {
        when(joueurRepository.findById(anyLong())).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            joueurService.getJoueurById(1L);
        });

        assertEquals("Joueur non trouvé", exception.getMessage());
        verify(joueurRepository, times(1)).findById(1L);
    }
}