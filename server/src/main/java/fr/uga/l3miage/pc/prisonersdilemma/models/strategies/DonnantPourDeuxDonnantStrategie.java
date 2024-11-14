package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;

import java.util.List;

public class DonnantPourDeuxDonnantStrategie implements Strategie {

    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire){
        int size = coupsAdversaire.size();
        if(size >= 2 && coupsAdversaire.get(size-1)   == coupsAdversaire.get(size - 2)){
            return coupsAdversaire.get(coupsAdversaire.size() - 1);
        }
        return Decision.COOPERER;
    }
}