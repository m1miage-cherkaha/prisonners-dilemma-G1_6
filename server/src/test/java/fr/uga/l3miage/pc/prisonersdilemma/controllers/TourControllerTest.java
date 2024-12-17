package fr.uga.l3miage.pc.prisonersdilemma.controllers;

import fr.uga.l3miage.pc.prisonersdilemma.services.PartieService;
import fr.uga.l3miage.pc.prisonersdilemma.requests.TourRequestDTO;
import fr.uga.l3miage.pc.prisonersdilemma.responses.TourResponseDTO;
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
        MockitoAnnotations.initMocks(this);
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