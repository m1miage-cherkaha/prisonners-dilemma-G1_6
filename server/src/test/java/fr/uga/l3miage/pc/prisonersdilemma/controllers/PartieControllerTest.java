package fr.uga.l3miage.pc.prisonersdilemma.controllers;
import fr.uga.l3miage.pc.prisonersdilemma.controllers.PartieController;
import fr.uga.l3miage.pc.prisonersdilemma.services.PartieService;
import fr.uga.l3miage.pc.prisonersdilemma.requests.PartieCreationRequest;
import fr.uga.l3miage.pc.prisonersdilemma.requests.PartieJoinRequest;
import fr.uga.l3miage.pc.prisonersdilemma.responses.PartieResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;



class PartieControllerTest {

    @Mock
    private PartieService partieService;

    @InjectMocks
    private PartieController partieController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreatePartie() {
        //Given
        PartieCreationRequest request = new PartieCreationRequest(null, 0, null);
        PartieResponseDTO response = new PartieResponseDTO();

        //when
        when(partieService.demarrerNouvellePartie(any(PartieCreationRequest.class))).thenReturn(response);
        
        //then
        PartieResponseDTO result = partieController.createPartie(request);

        assertEquals(response, result);
    }

    @Test
    void testUpdatePartie() {
        Long idPartie = 1L;
        PartieJoinRequest request = new PartieJoinRequest(null, null);
        PartieResponseDTO response = new PartieResponseDTO();
        
        when(partieService.rejoindrePartie(any(Long.class), any(PartieJoinRequest.class))).thenReturn(response);

        PartieResponseDTO result = partieController.updatePartie(idPartie, request);

        assertEquals(response, result);
    }
}