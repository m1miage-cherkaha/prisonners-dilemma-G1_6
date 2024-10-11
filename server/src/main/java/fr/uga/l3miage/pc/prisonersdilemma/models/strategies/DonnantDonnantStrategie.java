package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;

import java.util.List;

public class DonnantDonnantStrategie implements Strategie {
    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire) {
        Decision lastDecision = Decision.COOPERER;
        if (!coupsAdversaire.isEmpty()) {
           lastDecision = coupsAdversaire.get(coupsAdversaire.size() - 1);
            // Proceed with using lastDecision
        }

        return lastDecision;
    }
}
