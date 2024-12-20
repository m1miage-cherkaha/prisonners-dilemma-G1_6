package fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.Strategie;

import java.util.List;

public class CoopererStrategie implements Strategie {
    public Decision faireChoix(List<Decision> coupsAdversaire){
        return Decision.COOPERER;
    }
}
