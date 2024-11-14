package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;

import java.util.List;

public class Adaptatif implements Strategie {

    private final List<Decision> initialMoves = List.of(
            Decision.COOPERER, Decision.COOPERER, Decision.COOPERER, Decision.COOPERER, Decision.COOPERER, Decision.COOPERER,
            Decision.TRAHIR, Decision.TRAHIR, Decision.TRAHIR, Decision.TRAHIR, Decision.TRAHIR
    );
    private int currentMove = 0;
    private int scoreCooperate = 0;
    private int scoreBetray = 0;
    private int totalCooperate = 0;
    private int totalBetray = 0;

    public void updateScore(int score, Decision lastDecision) {
        if (lastDecision == Decision.COOPERER) {
            scoreCooperate += score;
            totalCooperate++;
        } else {
            scoreBetray += score;
            totalBetray++;
        }
    }

    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire) {
        if (currentMove < initialMoves.size()) {
            return initialMoves.get(currentMove++);
        }

        double avgCooperate = (totalCooperate > 0) ? (double) scoreCooperate / totalCooperate : 0;
        double avgBetray = (totalBetray > 0) ? (double) scoreBetray / totalBetray : 0;

        return avgBetray > avgCooperate ? Decision.TRAHIR : Decision.COOPERER;
    }
}