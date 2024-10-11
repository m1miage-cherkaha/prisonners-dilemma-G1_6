package fr.uga.l3miage.pc.prisonersdilemma.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.common.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;

import java.util.List;

public class DonnantDonnantStrategie implements Strategie {
    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire) {
        return coupsAdversaire.getLast();
    }
}