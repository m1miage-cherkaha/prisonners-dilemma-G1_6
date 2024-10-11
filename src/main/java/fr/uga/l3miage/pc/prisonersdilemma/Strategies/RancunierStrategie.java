package fr.uga.l3miage.pc.prisonersdilemma.Strategies;

import fr.uga.l3miage.pc.prisonersdilemma.Common.Strategie;
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
