package fr.uga.l3miage.pc.prisonersdilemma.controllers;
import fr.uga.l3miage.pc.prisonersdilemma.application.services.PartieService;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.controllers.PartieController;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.PartieCreationRequest;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.PartieJoinRequest;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.PartieResponseDTO;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.ScoreResponseDTO;

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
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePartie() {
        PartieCreationRequest request = new PartieCreationRequest("joueur1", 3);
        PartieResponseDTO response = new PartieResponseDTO();
        when(partieService.demarrerNouvellePartie(any(PartieCreationRequest.class))).thenReturn(response);

        PartieResponseDTO result = partieController.createPartie(request);

        assertEquals(response, result);
    }

    @Test
    void testGetScore() {
        ScoreResponseDTO response = new ScoreResponseDTO(2,2);
        when(partieService.getScore()).thenReturn(response);

        ScoreResponseDTO result = partieController.getScore();

        assertEquals(response, result);
    }

    @Test
    void testUpdatePartie() {
        PartieJoinRequest request = new PartieJoinRequest("joueur2");
        PartieResponseDTO response = new PartieResponseDTO();
        when(partieService.rejoindrePartie(any(PartieJoinRequest.class))).thenReturn(response);

        PartieResponseDTO result = partieController.updatePartie(request);

        assertEquals(response, result);
    }
}