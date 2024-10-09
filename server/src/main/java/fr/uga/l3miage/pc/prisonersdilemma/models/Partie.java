package fr.uga.l3miage.pc.prisonersdilemma.models;


import fr.uga.l3miage.pc.prisonersdilemma.enums.Strategie;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Partie /* implements Runnable*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Joueur joueur1;
    @ManyToOne
    private Joueur joueur2;

    private int scoreJoueur1;
    private int scoreJoueur2;
    @Enumerated(EnumType.STRING)
    private Strategie strategieServeur;
    private int nbTours;
    @OneToMany
    private List<Tour> Tours;

    public Partie() {}

    public Partie(Joueur joueur1, Joueur joueur2, int nbTours/*Strategie strategieServeur*/) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.nbTours = nbTours;
        /*this.strategieServeur = strategieServeur;*/
        //ajout strat par défaut
    }

    // Getters et Setters
    public Long getId() { return id; }
    public Joueur getJoueur1() { return joueur1; }
    public void setJoueur1(Joueur joueur1) { this.joueur1 = joueur1; }
    public Joueur getJoueur2() { return joueur2; }
    public void setJoueur2(Joueur joueur2) { this.joueur2 = joueur2; }
    public int getNbTours() { return nbTours; }
    public void setNbTours(int nbTours) { this.nbTours = nbTours; }

}
