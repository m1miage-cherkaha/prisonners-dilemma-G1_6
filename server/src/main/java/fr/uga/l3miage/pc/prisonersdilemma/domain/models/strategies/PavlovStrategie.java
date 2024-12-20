package fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.Strategie;

import java.util.List;

public class PavlovStrategie implements Strategie {
    private Decision lastDecision = Decision.COOPERER;
    private int lastScore = 0;

    public void setLastScore(int score) {
        this.lastScore = score;
    }

    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire) {
        if (lastScore == 5 || lastScore == 3) {
            return lastDecision;  // Repeat last choice
        } else {
            // Alternate choice if last score was neither 5 nor 3
            lastDecision = (lastDecision == Decision.COOPERER) ? Decision.TRAHIR : Decision.COOPERER;
            return lastDecision;
        }
    }
    }