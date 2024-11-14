package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;

import java.util.List;

public class DonnantDonnantAleatoireStrategie implements Strategie {
    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire) {
        int indice = (int) (Math.random() * 10) + 1;
        if (indice == 1) {
            return (Math.random() < 0.5) ? Decision.COOPERER : Decision.TRAHIR;
        }
        return coupsAdversaire.get(coupsAdversaire.size() - 1);
    }
}