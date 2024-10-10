package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;

import java.util.List;

public class AleatoireStrategie implements Strategie {
    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire) {
        Decision choix = Decision.COOPERER;
        int indice = (int) (Math.random() * 2) + 1;
        if(indice==1) choix = Decision.TRAHIR;
        return choix;
    }
}
