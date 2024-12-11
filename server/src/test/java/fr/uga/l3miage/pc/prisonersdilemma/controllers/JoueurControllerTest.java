
package fr.uga.l3miage.pc.prisonersdilemma.controllers;


import fr.uga.l3miage.pc.prisonersdilemma.enums.TypeStrategie;
import fr.uga.l3miage.pc.prisonersdilemma.models.Joueur;
import fr.uga.l3miage.pc.prisonersdilemma.requests.LeaveRequestDTO;
import fr.uga.l3miage.pc.prisonersdilemma.responses.JoueurReponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.services.JoueurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllJoueurs() {
        Joueur joueur1 = new Joueur(1L, "Player1",100, TypeStrategie.DONNANT_DONNANT);
        Joueur joueur2 = new Joueur(2L, "Player2", 200, TypeStrategie.TOUJOURS_COOPERER);
        when(joueurService.getAllJoueurs()).thenReturn(Arrays.asList(joueur1, joueur2));

        List<JoueurReponseDTO> joueurs = joueurController.getAllJoueurs();

        assertEquals(2, joueurs.size());
        assertEquals("Player1", joueurs.get(0).getNom());
        assertEquals(100, joueurs.get(0).getScore());
        assertEquals("Player2", joueurs.get(1).getNom());
        assertEquals(200, joueurs.get(1).getScore());
    }

    @Test
    void testGetJoueurById() {
        Joueur joueur = new Joueur(1L, "Player1", 100, TypeStrategie.TOUJOURS_COOPERER);
        when(joueurService.getJoueurById(1L)).thenReturn(joueur);

        JoueurReponseDTO joueurReponseDTO = joueurController.getJoueurById(1L);

        assertEquals(1L, joueurReponseDTO.getId());
        assertEquals("Player1", joueurReponseDTO.getNom());
        assertEquals(100, joueurReponseDTO.getScore());
    }

    @Test
    void testLeaveGame() {
        LeaveRequestDTO leaveRequestDTO = new LeaveRequestDTO(1L, "strategy");
        when(joueurService.leaveGame(1L, "strategy")).thenReturn(true);

        boolean result = joueurController.leaveGame(leaveRequestDTO);

        assertEquals(true, result);
    }
}