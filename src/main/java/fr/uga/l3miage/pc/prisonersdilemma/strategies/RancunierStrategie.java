package fr.uga.l3miage.pc.prisonersdilemma.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.common.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;

import java.util.List;

public class RancunierStrategie implements Strategie {
    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire) {
        Decision choix = Decision.COOPERER;
        for(Decision coup : coupsAdversaire){
            if(coup==Decision.TRAHIR) choix = Decision.TRAHIR;
        }
        return choix;
    }
}
