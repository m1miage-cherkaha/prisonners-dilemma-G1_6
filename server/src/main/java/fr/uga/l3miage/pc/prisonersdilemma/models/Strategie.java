package fr.uga.l3miage.pc.prisonersdilemma.models;

import fr.uga.l3miage.pc.prisonersdilemma.enums.Decision;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

@Entity
public abstract class Strategie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Strategie(){}

    public abstract Decision adapterStrategie();

}
