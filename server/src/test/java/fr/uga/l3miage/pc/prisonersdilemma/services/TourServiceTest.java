
package fr.uga.l3miage.pc.prisonersdilemma.services;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Partie;
import fr.uga.l3miage.pc.prisonersdilemma.models.Tour;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.TourRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;



public class TourServiceTest {

    @Mock
    private TourRepository tourRepository;

    @InjectMocks
    private TourService tourService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDemarrerNouveauTour() {
        Partie partie = new Partie();
        Tour tour = new Tour();
        tour.setPartie(partie);
        tour.setPointJoueur1(0);
        tour.setPointJoueur2(0);
        tour.setDecisionJoueur1(null);
        tour.setDecisionJoueur2(null);

        when(tourRepository.save(any(Tour.class))).thenReturn(tour);

        Tour result = tourService.demarrerNouveauTour(partie);

        assertEquals(tour, result);
        assertEquals(partie, result.getPartie());
        assertEquals(0, result.getPointJoueur1());
        assertEquals(0, result.getPointJoueur2());
        assertEquals(null, result.getDecisionJoueur1());
        assertEquals(null, result.getDecisionJoueur2());
    }

    @Test
    public void testCalculerPoints_CoopererCooperer() {
        Tour tour = new Tour();
        tour = tourService.calculerPoints(tour, Decision.COOPERER, Decision.COOPERER);

        assertEquals(3, tour.getPointJoueur1());
        assertEquals(3, tour.getPointJoueur2());
    }

    @Test
    public void testCalculerPoints_TrahirCooperer() {
        Tour tour = new Tour();
        tour = tourService.calculerPoints(tour, Decision.TRAHIR, Decision.COOPERER);

        assertEquals(5, tour.getPointJoueur1());
        assertEquals(0, tour.getPointJoueur2());
    }

    @Test
    public void testCalculerPoints_CoopererTrahir() {
        Tour tour = new Tour();
        tour = tourService.calculerPoints(tour, Decision.COOPERER, Decision.TRAHIR);

        assertEquals(0, tour.getPointJoueur1());
        assertEquals(5, tour.getPointJoueur2());
    }

    @Test
    public void testCalculerPoints_TrahirTrahir() {
        Tour tour = new Tour();
        tour = tourService.calculerPoints(tour, Decision.TRAHIR, Decision.TRAHIR);

        assertEquals(1, tour.getPointJoueur1());
        assertEquals(1, tour.getPointJoueur2());
    }
}