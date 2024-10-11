package fr.uga.l3miage.pc.prisonersdilemma.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.common.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;

import java.util.List;

public class TrahirStrategie implements Strategie {
    public Decision faireChoix(List<Decision> coupsAdversaire){
        return Decision.TRAHIR;
    }
}