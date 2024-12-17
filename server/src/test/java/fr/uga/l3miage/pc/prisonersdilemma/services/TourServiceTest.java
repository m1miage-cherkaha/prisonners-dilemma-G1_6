
package fr.uga.l3miage.pc.prisonersdilemma.services;
import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Tour;
import fr.uga.l3miage.pc.prisonersdilemma.repositories.TourRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;



class TourServiceTest {

    @Mock
    private TourRepository tourRepository;

    @InjectMocks
    private TourService tourService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDemarrerNouveauTour() {
        Tour tour = new Tour();
        tour.setPointJoueur1(0);
        tour.setPointJoueur2(0);
        tour.setDecisionJoueur1(null);
        tour.setDecisionJoueur2(null);

        when(tourRepository.save(tour)).thenReturn(tour);

        Tour result = tourService.demarrerNouveauTour();

        assertEquals(0, result.getPointJoueur1());
        assertEquals(0, result.getPointJoueur2());
        assertEquals(null, result.getDecisionJoueur1());
        assertEquals(null, result.getDecisionJoueur2());
    }

    @Test
    void testCalculerPoints_CoopererCooperer() {
        Tour tour = new Tour();
        Decision decisionJoueur1 = Decision.COOPERER;
        Decision decisionJoueur2 = Decision.COOPERER;

        Tour result = tourService.calculerPoints(tour, decisionJoueur1, decisionJoueur2);

        assertEquals(3, result.getPointJoueur1());
        assertEquals(3, result.getPointJoueur2());
    }

    @Test
    void testCalculerPoints_TrahirCooperer() {
        Tour tour = new Tour();
        Decision decisionJoueur1 = Decision.TRAHIR;
        Decision decisionJoueur2 = Decision.COOPERER;

        Tour result = tourService.calculerPoints(tour, decisionJoueur1, decisionJoueur2);

        assertEquals(5, result.getPointJoueur1());
        assertEquals(0, result.getPointJoueur2());
    }

    @Test
    void testCalculerPoints_CoopererTrahir() {
        Tour tour = new Tour();
        Decision decisionJoueur1 = Decision.COOPERER;
        Decision decisionJoueur2 = Decision.TRAHIR;

        Tour result = tourService.calculerPoints(tour, decisionJoueur1, decisionJoueur2);

        assertEquals(0, result.getPointJoueur1());
        assertEquals(5, result.getPointJoueur2());
    }

    @Test
    void testCalculerPoints_TrahirTrahir() {
        Tour tour = new Tour();
        Decision decisionJoueur1 = Decision.TRAHIR;
        Decision decisionJoueur2 = Decision.TRAHIR;

        Tour result = tourService.calculerPoints(tour, decisionJoueur1, decisionJoueur2);

        assertEquals(1, result.getPointJoueur1());
        assertEquals(1, result.getPointJoueur2());
    }
}