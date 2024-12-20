
package fr.uga.l3miage.pc.prisonersdilemma.models.strategies.adaptateur;
import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.TypeStrategie;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies.adaptateur.Adaptateur;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;



class AdaptateurTest {

    @Test
    void testToujoursCooperer() {
        Adaptateur adaptateur = new Adaptateur(TypeStrategie.TOUJOURS_COOPERER);
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR);
        Decision decision = adaptateur.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, decision);
    }

    @Test
    void testToujoursTrahir() {
        Adaptateur adaptateur = new Adaptateur(TypeStrategie.TOUJOURS_TRAHIR);
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR);
        Decision decision = adaptateur.faireChoix(coupsAdversaire);
        assertEquals(Decision.TRAHIR, decision);
    }

    @Test
    void testStrategieNonReconnue() {
        Adaptateur adaptateur = new Adaptateur(TypeStrategie.ALEATOIRE);
        List<Decision> coupsAdversaire = Arrays.asList(Decision.COOPERER, Decision.TRAHIR);
        Decision decision = adaptateur.faireChoix(coupsAdversaire);
        assertEquals(Decision.COOPERER, decision);
    }
}