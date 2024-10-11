package fr.uga.l3miage.pc.prisonersdilemma.Strategies;

import fr.uga.l3miage.pc.prisonersdilemma.Common.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;

import java.util.List;

public class TrahirStrategie implements Strategie {
    public Decision faireChoix(List<Decision> coupsAdversaire){
        return Decision.TRAHIR;
    }
}