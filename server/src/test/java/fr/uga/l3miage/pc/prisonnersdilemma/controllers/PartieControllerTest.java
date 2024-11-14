package fr.uga.l3miage.pc.prisonnersdilemma.controllers;
import fr.uga.l3miage.pc.prisonersdilemma.controllers.PartieController;
import fr.uga.l3miage.pc.prisonersdilemma.services.PartieService;
import fr.uga.l3miage.pc.prisonnersdilemma.requests.PartieCreationRequest;
import fr.uga.l3miage.pc.prisonnersdilemma.requests.PartieJoinRequest;
import fr.uga.l3miage.pc.prisonnersdilemma.responses.PartieResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;



public class PartieControllerTest {

    @Mock
    private PartieService partieService;

    @InjectMocks
    private PartieController partieController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePartie() {
        PartieCreationRequest request = new PartieCreationRequest(null, 0, null);
        PartieResponseDTO response = new PartieResponseDTO();
        
        when(partieService.demarrerNouvellePartie(any(PartieCreationRequest.class))).thenReturn(response);

        PartieResponseDTO result = partieController.createPartie(request);

        assertEquals(response, result);
    }

    @Test
    public void testUpdatePartie() {
        Long idPartie = 1L;
        PartieJoinRequest request = new PartieJoinRequest(null, null);
        PartieResponseDTO response = new PartieResponseDTO();
        
        when(partieService.rejoindrePartie(any(Long.class), any(PartieJoinRequest.class))).thenReturn(response);

        PartieResponseDTO result = partieController.updatePartie(idPartie, request);

        assertEquals(response, result);
    }
}