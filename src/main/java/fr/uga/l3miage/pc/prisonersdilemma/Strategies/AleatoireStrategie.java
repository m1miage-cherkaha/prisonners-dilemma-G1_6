package fr.uga.l3miage.pc.prisonersdilemma.Strategies;

import fr.uga.l3miage.pc.prisonersdilemma.Common.Strategie;
import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;

import java.util.List;

public class AleatoireStrategie implements Strategie {
        @Override
        public Decision faireChoix(List<Decision> coupsAdversaire) {
            Decision choix = Decision.COOPERER;
            int indice = (int) (Math.random() * 2) + 1;
            if(indice==1) choix = Decision.TRAHIR;
            return choix;
        }
    }
