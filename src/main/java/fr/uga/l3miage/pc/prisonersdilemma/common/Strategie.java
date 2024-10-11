package fr.uga.l3miage.pc.prisonersdilemma.common;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;

import java.util.List;

public interface Strategie {
        Decision faireChoix(List<Decision> coupsAdversaire);
}
