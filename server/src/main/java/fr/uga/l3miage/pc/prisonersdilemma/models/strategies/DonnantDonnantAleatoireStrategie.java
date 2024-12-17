package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;

import java.util.List;
import java.util.Random;

public class DonnantDonnantAleatoireStrategie implements Strategie {
    private final Random random = new Random();

    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire) {
        int indice = random.nextInt(10) + 1;
        if (indice == 1) {
            return (random.nextInt(2) < 1) ? Decision.COOPERER : Decision.TRAHIR;
        }
        return coupsAdversaire.get(coupsAdversaire.size() - 1);
    }
}