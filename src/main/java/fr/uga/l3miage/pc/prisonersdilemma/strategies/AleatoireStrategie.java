package fr.uga.l3miage.pc.prisonersdilemma.strategies;

import fr.uga.l3miage.pc.prisonersdilemma.common.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;

import java.util.List;
import java.util.Random;

public class AleatoireStrategie implements Strategie {
        @Override
        public Decision faireChoix(List<Decision> coupsAdversaire) {
            Decision choix = Decision.COOPERER;
            int indice = (new Random()).nextInt(2) + 1;
            if(indice==1) choix = Decision.TRAHIR;
            return choix;
        }
    }
