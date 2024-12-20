package fr.uga.l3miage.pc.prisonersdilemma.domain.models.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;
import fr.uga.l3miage.pc.prisonersdilemma.domain.models.Strategie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

public class PacificateurNaifStrategie implements Strategie {
    @Setter
    @Getter
    private Random random = new Random();
    @Override
    public Decision faireChoix(List<Decision> coupsAdversaire){
        int size = coupsAdversaire.size();
        if (random.nextDouble() < 0.3) {
            return Decision.COOPERER;
        }
        // Suivre le dernier coup de l'adversaire
        return coupsAdversaire.get(size - 1);
    }
    }