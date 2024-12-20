package fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.Strategie;

import java.util.List;

public class DonnantDonnantStrategie implements Strategie {
    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire) {
        return !coupsAdversaire.isEmpty() ? coupsAdversaire.get(coupsAdversaire.size() - 1) : Decision.COOPERER;
        
    }
}
