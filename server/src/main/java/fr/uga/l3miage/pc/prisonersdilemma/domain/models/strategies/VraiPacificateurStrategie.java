package fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.Strategie;

import java.util.List;

public class VraiPacificateurStrategie implements Strategie {
    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire){
        int size = coupsAdversaire.size();
            if((size >=2) && coupsAdversaire.get(size-1) == Decision.COOPERER && coupsAdversaire.get(size - 2 ) == Decision.COOPERER){
              return Decision.COOPERER;
            }
            else{
            return (Math.random() < 0.1) ? Decision.COOPERER : Decision.TRAHIR;
        }
    }
}
