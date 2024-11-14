package fr.uga.l3miage.pc.prisonersdilemma.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.models.Strategie;

import java.util.List;

public class PacificateurNaifStrategie implements Strategie {
    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire){
        int size = coupsAdversaire.size();
        if (Math.random() < 0.3) {
            return Decision.COOPERER;
        }
        // Suivre le dernier coup de l'adversaire
        return coupsAdversaire.get(size - 1);
    }
    }