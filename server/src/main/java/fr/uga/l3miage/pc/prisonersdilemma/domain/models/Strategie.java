package fr.uga.l3miage.pc.prisonersdilemma.domain.models;

import java.util.List;

import fr.uga.l3miage.pc.prisonersdilemma.domain.enums.Decision;

public interface Strategie {
    Decision faireChoix(List<Decision> coupsAdversaire);
}
