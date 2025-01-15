package fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.Strategie;

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
