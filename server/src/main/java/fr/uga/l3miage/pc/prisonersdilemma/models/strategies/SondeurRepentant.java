package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;

import java.util.List;
import java.util.Random;

public class SondeurRepentant implements Strategie {

    private Random random = new Random();
    private double probabiliteDeTrahir = 0.1;
    private boolean lastMoveWasTest = false;

    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire) {
        if (coupsAdversaire.isEmpty()) {
            return Decision.COOPERER;
        }

        Decision lastMove = coupsAdversaire.get(coupsAdversaire.size() - 1);

        if (lastMoveWasTest) {
            if (lastMove == Decision.TRAHIR) {
                lastMoveWasTest = false;
                return Decision.COOPERER;
            }
            lastMoveWasTest = false;
        }

        if (random.nextDouble() < probabiliteDeTrahir) {
            lastMoveWasTest = true;
            return Decision.TRAHIR;
        }

        return lastMove;
    }
}