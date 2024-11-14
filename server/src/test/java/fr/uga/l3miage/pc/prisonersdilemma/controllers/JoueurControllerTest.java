package fr.uga.l3miage.pc.prisonersdilemma.controllers;


import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.services.JoueurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



class JoueurControllerTest {

    @Mock
    private JoueurService joueurService;

    @InjectMocks
    private JoueurController joueurController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllJoueurs() {
        List<Joueur> joueurs = Arrays.asList(new Joueur(), new Joueur());
        when(joueurService.getAllJoueurs()).thenReturn(joueurs);

        ResponseEntity<List<Joueur>> response = joueurController.getAllJoueurs();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(joueurs, response.getBody());
        verify(joueurService, times(1)).getAllJoueurs();
    }

    @Test
    void testCreateJoueur() {
        Joueur joueur = new Joueur();
        when(joueurService.createJoueur(joueur)).thenReturn(joueur);

        ResponseEntity<Joueur> response = joueurController.createJoueur(joueur);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(joueur, response.getBody());
        verify(joueurService, times(1)).createJoueur(joueur);
    }

    @Test
    void testGetJoueurById() {
        Long id = 1L;
        Joueur joueur = new Joueur();
        when(joueurService.getJoueurById(id)).thenReturn(joueur);

        ResponseEntity<Joueur> response = joueurController.getJoueurById(id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(joueur, response.getBody());
        verify(joueurService, times(1)).getJoueurById(id);
    }
}