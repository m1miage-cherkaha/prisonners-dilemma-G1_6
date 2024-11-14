package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;

import java.util.List;

public class DonnantPourDeuxDonnantAleatoireStrategie implements Strategie {

    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire) {
        int size = coupsAdversaire.size();
        if(size>0){
            int indice = (int) (Math.random() * 2) + 1;
            if (indice == 1) {
                return Decision.TRAHIR;
            }

            if (size >= 2 && coupsAdversaire.get(size - 1) == coupsAdversaire.get(size - 2)) {
                return coupsAdversaire.get(size - 1);
            }
        }
        
        return Decision.COOPERER;
    }
}