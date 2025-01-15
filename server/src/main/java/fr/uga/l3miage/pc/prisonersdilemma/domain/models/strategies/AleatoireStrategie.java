package fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.Strategie;

import java.util.List;
import java.util.Random;

public class AleatoireStrategie implements Strategie {
    private final Random random = new Random();
    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire) {
        Decision choix = Decision.COOPERER;
        int indice = (random.nextInt(10) * 2) + 1;
        if(indice==1) choix = Decision.TRAHIR;
        return choix;
    }
}
