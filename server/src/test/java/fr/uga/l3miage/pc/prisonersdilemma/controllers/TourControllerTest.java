package fr.uga.l3miage.pc.prisonersdilemma.controllers;

import fr.uga.l3miage.pc.prisonersdilemma.application.services.PartieService;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.controllers.TourController;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.requests.TourRequestDTO;
import fr.uga.l3miage.pc.prisonersdilemma.infrastructure.adapters.input.rest.responses.TourResponseDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class TourControllerTest {

    @Mock
    private PartieService partieService;

    @InjectMocks
    private TourController tourController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPostFaireChoixSansAdaptateur() {
        TourRequestDTO tourRequest = new TourRequestDTO(1L, "TOUJOURS_COOPERER", false);
        TourResponseDTO expectedResponse = new TourResponseDTO();

        when(partieService.jouerTour(tourRequest)).thenReturn(expectedResponse);

        TourResponseDTO actualResponse = tourController.postFaireChoix(tourRequest);

        assertEquals(expectedResponse, actualResponse);
    }
}