package fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.Strategie;

import java.util.List;

public class SondeurNaifStrategie implements Strategie {
    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire){
        int size = coupsAdversaire.size();
        if (Math.random() < 0.3) {
            return Decision.TRAHIR;
        }
        // Suivre le dernier coup de l'adversaire
        return coupsAdversaire.get(size - 1);
    }
    }