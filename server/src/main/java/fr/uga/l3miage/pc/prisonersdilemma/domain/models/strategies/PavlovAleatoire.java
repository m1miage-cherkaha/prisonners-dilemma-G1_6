package fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.Strategie;

import java.util.List;
import java.util.Random;

public class PavlovAleatoire implements Strategie {

    private final Random random = new Random();
    private Decision lastDecision = Decision.COOPERER;
    private int lastScore = 0;

    public void setLastScore(int score) {
        this.lastScore = score;
    }

    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire) {
        if (random.nextDouble() < 0.1) { 
            lastDecision = (random.nextBoolean()) ? Decision.COOPERER : Decision.TRAHIR;
            return lastDecision;
        }
        if (lastScore == 5 || lastScore == 3) {
            return lastDecision;  
        } else {
            lastDecision = (lastDecision == Decision.COOPERER) ? Decision.TRAHIR : Decision.COOPERER;
            return lastDecision;
        }
    }
}
